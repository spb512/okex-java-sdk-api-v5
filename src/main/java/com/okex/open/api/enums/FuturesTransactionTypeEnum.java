package com.okex.open.api.enums;

/**
 * 
 * @author spb512
 * @date 2022年6月5日 下午5:02:59
 *
 */
public enum FuturesTransactionTypeEnum {
	/**
	 * 1
	 */
	OPEN_LONG(1),
	/**
	 * 2
	 */
	OPEN_SHORT(2),
	/**
	 * 3
	 */
	CLOSE_LONG(3),
	/**
	 * 4
	 */
	CLOSE_SHORT(4),;

	private int code;

	FuturesTransactionTypeEnum(int code) {
		this.code = code;
	}

	public int code() {
		return code;
	}
}
