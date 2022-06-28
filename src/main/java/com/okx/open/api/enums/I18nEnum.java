package com.okx.open.api.enums;

/**
 * 
 * @author spb512
 * @date 2022年6月5日 下午5:02:59
 *
 */
public enum I18nEnum {
	/**
	 * 英文en_US
	 */
	ENGLISH("en_US"),
	/**
	 * 中文zh_CN
	 */
	SIMPLIFIED_CHINESE("zh_CN"),
	/**
	 * 香港或者台湾zh_TW || zh_HK
	 */
	TRADITIONAL_CHINESE("zh_HK"),;

	private String i18n;

	I18nEnum(String i18n) {
		this.i18n = i18n;
	}

	public String i18n() {
		return i18n;
	}
}
