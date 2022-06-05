package com.okex.open.api.test.ws.privates.channel.config;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.joda.time.DateTime;

import com.alibaba.fastjson2.JSON;
import com.okex.open.api.enums.CharsetEnum;
import com.okex.open.api.utils.DateUtils;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

/**
 * 
 * @author spb512
 * @date 2022年6月5日 下午5:02:59
 *
 */
public class WebSocketClient {
	private static WebSocket webSocket = null;
	private static Boolean flag = true;
	private static Boolean isConnect = false;
	private static String sign;
//	private final static HashFunction crc32 = Hashing.crc32();
//	private static Map<String, Optional<SpotOrderBook>> bookMap = new HashMap<>();
//	private static Logger logger = Logger.getLogger(PrivateChannelTest.class);

	public WebSocketClient() {
	}

	/**
	 * 与服务器建立连接，参数为服务器的URL
	 * 
	 * @param url
	 * @return
	 */
	public static WebSocket connection(final String url) {

		OkHttpClient client = new OkHttpClient.Builder().readTimeout(5, TimeUnit.SECONDS).build();
		Request request = new Request.Builder().url(url).build();

		webSocket = client.newWebSocket(request, new WebSocketListener() {
			ScheduledExecutorService service;

			@Override
			public void onOpen(final WebSocket webSocket, final Response response) {
				// 连接成功后，设置定时器，每隔25s，自动向服务器发送心跳，保持与服务器连接
				isConnect = true;
				System.out.println(Instant.now().toString() + " Connected to the server success!");
				Runnable runnable = new Runnable() {
					@Override
					public void run() {
						// task to run goes here
						sendMessage("ping");
					}
				};
				service = Executors.newSingleThreadScheduledExecutor();
				// 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间
				service.scheduleAtFixedRate(runnable, 25, 25, TimeUnit.SECONDS);
			}

			@Override
			public void onClosing(WebSocket webSocket, int code, String reason) {
				System.out.println("Connection is about to disconnect！");
				webSocket.close(1000, "Long time no message was sent or received！");
				webSocket = null;
			}

			@Override
			public void onClosed(final WebSocket webSocket, final int code, final String reason) {
				System.out.println("Connection dropped！");
			}

			@Override
			public void onFailure(final WebSocket webSocket, final Throwable t, final Response response) {
				System.out.println("Connection failed,Please reconnect!");
				if (Objects.nonNull(service)) {

					service.shutdown();
				}
			}

			@Override
			public void onMessage(final WebSocket webSocket, final String bytes) {
				// 测试服务器返回的字节
				final String byteString = bytes.toString();

				final String s = byteString;

				System.out.println(DateFormatUtils.format(new Date(), DateUtils.TIME_STYLE_S4) + " Receive: " + s);

				String login = "login";
				String endStr = "true}";
				if (null != s && s.contains(login)) {
					if (s.endsWith(endStr)) {
						flag = true;
					}
				}
			}
		});
		return webSocket;
	}

	/*
	 * private static void isLogin(String s) { if (null != s && s.contains("login"))
	 * { if (s.endsWith("true}")) { flag = true; } } }
	 */
	/**
	 * 获得sign
	 * 
	 * @param message
	 * @param secret
	 * @return
	 */
	private static String sha256Hmac(String message, String secret) {
		String hash = "";
		try {
			Mac sha256Hmac = Mac.getInstance("HmacSHA256");
			SecretKeySpec secretKey = new SecretKeySpec(secret.getBytes(CharsetEnum.UTF_8.charset()), "HmacSHA256");
			sha256Hmac.init(secretKey);
			byte[] bytes = sha256Hmac.doFinal(message.getBytes(CharsetEnum.UTF_8.charset()));
			hash = Base64.getEncoder().encodeToString(bytes);
		} catch (Exception e) {
			System.out.println("Error HmacSHA256 ===========" + e.getMessage());
		}
		return hash;
	}

	private static String listToJson(List<Map<String, Object>> list) {
		List<Map<String, Object>> mapList = new ArrayList<>();
		for (Map<String, Object> map : list) {
			mapList.add(map);
		}
		String jsonString = JSON.toJSONString(mapList);
		return jsonString;
	}

	/**
	 * 登录
	 * 
	 * @param apiKey
	 * @param passPhrase
	 * @param secretKey
	 */
	public static void login(String apiKey, String passPhrase, String secretKey) {
		String timestamp = DateTime.now().getMillis() / 1000 + "";
		String message = timestamp + "GET" + "/users/self/verify";
		sign = sha256Hmac(message, secretKey);
		String str = "{\"op\"" + ":" + "\"login\"" + "," + "\"args\"" + ":" + "[{" + "\"apiKey\"" + ":" + "\"" + apiKey
				+ "\"" + "," + "\"passphrase\"" + ":" + "\"" + passPhrase + "\"" + "," + "\"timestamp\"" + ":" + "\""
				+ timestamp + "\"" + "," + "\"sign\"" + ":" + "\"" + sign + "\"" + "}]}";
		sendMessage(str);
	}

	/**
	 * 订阅，参数为频道组成的集合
	 * 
	 * @param list
	 */
	public static void subscribe(List<Map<String, Object>> list) {
		String s = listToJson(list);
		String str = "{\"op\": \"subscribe\", \"args\":" + s + "}";

		if (null != webSocket) {
			sendMessage(str);
		}
	}

	/**
	 * 取消订阅，参数为频道组成的集合
	 * 
	 * @param list
	 */
	public static void unsubscribe(List<Map<String, Object>> list) {
		String s = listToJson(list);
		String str = "{\"op\": \"unsubscribe\", \"args\":" + s + "}";
		if (null != webSocket) {
			sendMessage(str);
		}
	}

	private static void sendMessage(String str) {
		if (null != webSocket) {
			try {
				Thread.sleep(1300);
			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println("Send a message to the server:" + str);
			webSocket.send(str);
		} else {
			System.out.println("Please establish the connection before you operate it！");
		}
	}

	/**
	 * 断开连接
	 */
	public static void closeConnection() {
		if (null != webSocket) {
			webSocket.close(1000, "User actively closes the connection");
		} else {
			System.out.println("Please establish the connection before you operate it！");
		}
	}

	public boolean getIsLogin() {
		return flag;
	}

	public boolean getIsConnect() {
		return isConnect;
	}

}
