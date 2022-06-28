package com.okx.open.api.test.ws.privates.channel;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.okx.open.api.test.ws.privates.channel.config.WebSocketClient;
import com.okx.open.api.test.ws.privates.channel.config.WebSocketConfig;

/**
 * 
 * @author spb512
 * @date 2022年6月5日 下午5:02:59
 *
 */
public class PrivateChannelTest {
	private static final WebSocketClient WEBSOCKET_CLIENT = new WebSocketClient();
//	private static Logger logger = Logger.getLogger(PrivateChannelTest.class);

	@Before
	public void connect() {
		WebSocketConfig.loginConnect(WEBSOCKET_CLIENT);

	}

	@After
	public void close() {
		System.out.println(Instant.now().toString() + "Private channels close connect!");
		WebSocketClient.closeConnection();
	}

	/**
	 * 账户频道 Account Channel
	 */
	@Test
	public void privateAccountChannel() {
		// 添加订阅频道
		ArrayList<Map<String, Object>> channelList = new ArrayList<>();
		Map<String, Object> accountMap = new HashMap<String, Object>(16);

		accountMap.put("channel", "account");
		accountMap.put("ccy", "USDT");

		channelList.add(accountMap);

		// 调用订阅方法
		WebSocketClient.subscribe(channelList);
		// 为保证测试方法不停，需要让线程延迟
		try {
			Thread.sleep(10000000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 持仓频道 Positions Channel
	 */
	@Test
	public void privatePositionsChannel() {
		// 添加订阅频道
		ArrayList<Map<String, Object>> channelList = new ArrayList<>();
		Map<String, Object> positionsMap = new HashMap<String, Object>(16);

		positionsMap.put("channel", "positions");
		positionsMap.put("instType", "SWAP");
		positionsMap.put("uly", "XRP-USDT");
		positionsMap.put("instId", "XRP-USDT-SWAP");

		channelList.add(positionsMap);

		// 调用订阅方法
		WebSocketClient.subscribe(channelList);
		// 为保证测试方法不停，需要让线程延迟
		try {
			Thread.sleep(10000000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 账户余额和持仓频道 Balance and Position Channel
	 */
	@Test
	public void privateBalanceAndPositionChannel() {
		// 添加订阅频道
		ArrayList<Map<String, Object>> channelList = new ArrayList<>();
		Map<String, Object> orderMap = new HashMap<String, Object>(16);

		orderMap.put("channel", "balance_and_position");

		channelList.add(orderMap);

		// 调用订阅方法
		WebSocketClient.subscribe(channelList);
		// 为保证测试方法不停，需要让线程延迟
		try {
			Thread.sleep(10000000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 订单频道 Order Channel
	 */
	@Test
	public void privateOrderChannel() {
		// 添加订阅频道
		ArrayList<Map<String, Object>> channelList = new ArrayList<>();
		Map<String, Object> orderMap = new HashMap<String, Object>(16);

		orderMap.put("channel", "orders");
		orderMap.put("instType", "SWAP");
		orderMap.put("uly", "XRP-USDT");
		orderMap.put("instId", "XRP-USDT-SWAP");

		channelList.add(orderMap);

		// 调用订阅方法
		WebSocketClient.subscribe(channelList);
		// 为保证测试方法不停，需要让线程延迟
		try {
			Thread.sleep(10000000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 策略委托订单频道 Algo Orders Channel
	 */
	@Test
	public void privateAlgoOrdersChannel() {
		// 添加订阅频道
		ArrayList<Map<String, Object>> channelList = new ArrayList<>();
		Map<String, Object> algoOrders = new HashMap<String, Object>(16);

		algoOrders.put("channel", "orders-algo");
		algoOrders.put("instType", "FUTURES");
		algoOrders.put("uly", "BTC-USDT");
		algoOrders.put("instId", "BTC-USDT-210625");

		channelList.add(algoOrders);

		// 调用订阅方法
		WebSocketClient.subscribe(channelList);
		// 为保证测试方法不停，需要让线程延迟
		try {
			Thread.sleep(10000000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 取消订阅
	 */
	@Test
	public void unsubscribeChannel() {
		ArrayList<Map<String, Object>> channelList = new ArrayList<>();

		Map<String, Object> map = new HashMap<String, Object>(16);
		map.put("channel", "balance_and_position");
		map.put("instId", "BTC-USD-210924");
		channelList.add(map);
		WebSocketClient.unsubscribe(channelList);
		// 为保证收到服务端返回的消息，需要让线程延迟
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
