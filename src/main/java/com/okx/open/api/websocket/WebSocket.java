package com.okx.open.api.websocket;

/**
 * 
 * @author spb512
 * @date 2022年6月5日 下午5:02:59
 *
 */
public interface WebSocket {

	/**
	 * 连接
	 */
	void connect();

	/**
	 * 关闭
	 */
	void close();

	/**
	 * 登录
	 * 
	 * @param apiKey
	 * @param apiSecret
	 * @param passphrase
	 */
	void login(String apiKey, String apiSecret, String passphrase);

	/**
	 * 订阅
	 * 
	 * @param args
	 */
	void subscribe(String... args);

	/**
	 * 退订
	 * 
	 * @param args
	 */
	void unSubscribe(String... args);

	/**
	 * 发送ping
	 */
	void sendPing();

	/**
	 * 检查和
	 * 
	 * @param data
	 * @return
	 */
	boolean checkSum(String data);
}
