package com.okx.open.api.websocket;

/**
 * 
 * @author spb512
 * @date 2022年6月5日 下午5:02:59
 *
 */
public interface WebSocketListener {

	/**
	 * Called when a string message was received.
	 *
	 * @param ws   The WebSocket.
	 *
	 * @param text The text message.
	 *
	 * @throws Exception An exception thrown by an implementation of this method.
	 *                   The exception is passed to
	 *                   {@link #handleCallbackError(WebSocket, Throwable)}.
	 */
	void onTextMessage(WebSocket ws, String text) throws Exception;

	/**
	 * Called after onHandshakeReceived returns true Indicates that a complete
	 * WebSocket connection has been established, and we are ready to send/receive
	 * data.
	 *
	 * @param ws The WebSocket instance this event is occuring on.
	 */
	void onWebsocketOpen(WebSocket ws);

	/**
	 * Called when an method threw a {@code Throwable}.
	 *
	 * @param websocket The WebSocket.
	 *
	 * @param cause
	 *
	 * @throws Throwable An exception thrown by an implementation of this method.
	 *                   The exception is just ignored.
	 *
	 */
	void handleCallbackError(WebSocket websocket, Throwable cause);

	/**
	 * Called after WebSocket#close is explicity called, or when the other end of
	 * the WebSocket connection is closed.
	 *
	 * @param ws   The WebSocket instance this event is occuring on.
	 * @param code
	 */
	void onWebsocketClose(WebSocket ws, int code);

	/**
	 * Called when a pong frame is received.
	 *
	 * @param ws The WebSocket instance this event is occuring on.
	 **/
	void onWebsocketPong(WebSocket ws);
}
