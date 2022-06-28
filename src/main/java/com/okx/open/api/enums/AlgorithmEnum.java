package com.okx.open.api.enums;

/**
 * 
 * @author spb512
 * @date 2022年6月5日 下午5:02:59
 *
 */
public enum AlgorithmEnum {
	/**
	 * HmacSHA256
	 */
	HMAC_SHA256("HmacSHA256"),
	/**
	 * MD5
	 */
	MD5("MD5"),;

	private String algorithm;

	AlgorithmEnum(String algorithm) {
		this.algorithm = algorithm;
	}

	public String algorithm() {
		return algorithm;
	}
}
