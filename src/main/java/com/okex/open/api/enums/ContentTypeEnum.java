package com.okex.open.api.enums;

/**
 * 
 * @author spb512
 * @date 2022年6月5日 下午5:02:59
 *
 */
public enum ContentTypeEnum {
	/**
	 * application/json
	 */
	APPLICATION_JSON("application/json"),
	/**
	 * application/json; charset=UTF-8
	 */
	APPLICATION_JSON_UTF8("application/json; charset=UTF-8"),
	/**
	 * The server does not support types application/x-www-form-urlencoded;
	 * charset=UTF-8
	 */
	APPLICATION_FORM("application/x-www-form-urlencoded; charset=UTF-8"),;

	private String contentType;

	ContentTypeEnum(String contentType) {
		this.contentType = contentType;
	}

	public String contentType() {
		return contentType;
	}
}
