package com.okex.open.api.enums;

/**
 * 
 * @author spb512
 * @date 2022年6月5日 下午5:02:59
 *
 */
public enum CharsetEnum {
	/**
	 * UTF-8
	 */
	UTF_8("UTF-8"),
	/**
	 * ISO-8859-1
	 */
	ISO_8859_1("ISO-8859-1"),;

	private String charset;

	CharsetEnum(String charset) {
		this.charset = charset;
	}

	public String charset() {
		return charset;
	}
}
