package com.okx.open.api.enums;

/**
 * 
 * @author spb512
 * @date 2022年6月5日 下午5:02:59
 *
 */
public enum HttpHeadersEnum {

	/**
	 * OK-ACCESS-KEY
	 */
	OK_ACCESS_KEY("OK-ACCESS-KEY"),
	/**
	 * OK-ACCESS-SIGN
	 */
	OK_ACCESS_SIGN("OK-ACCESS-SIGN"),
	/**
	 * OK-ACCESS-TIMESTAMP
	 */
	OK_ACCESS_TIMESTAMP("OK-ACCESS-TIMESTAMP"),
	/**
	 * OK-ACCESS-PASSPHRASE
	 */
	OK_ACCESS_PASSPHRASE("OK-ACCESS-PASSPHRASE"),
	/**
	 * x-simulated-trading
	 */
	x_simulated_trading("x-simulated-trading"),
	/**
	 * OK-BEFORE
	 */
	OK_BEFORE("OK-BEFORE"),
	/**
	 * OK-AFTER
	 */
	OK_AFTER("OK-AFTER"),
	/**
	 * OK-LIMIT
	 */
	OK_LIMIT("OK-LIMIT"),
	/**
	 * OK-FROM
	 */
	OK_FROM("OK-FROM"),
	/**
	 * OK-TO
	 */
	OK_TO("OK-TO");

	private final String header;

	HttpHeadersEnum(final String header) {
		this.header = header;
	}

	public String header() {
		return this.header;
	}
}
