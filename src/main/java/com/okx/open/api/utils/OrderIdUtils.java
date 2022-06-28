package com.okx.open.api.utils;

import java.util.UUID;

import com.okx.open.api.constant.ApiConstants;

/**
 * 
 * @author spb512
 * @date 2022年6月5日 下午5:02:59
 *
 */
public class OrderIdUtils {

	/**
	 * The order ids, use uuid and remove the line dividing line. <br/>
	 * id length = 32
	 *
	 * @return String eg: 39360db0a45e41309511f4fba658b01c
	 */
	public static String generator() {
		return UUID.randomUUID().toString().toLowerCase().replace(ApiConstants.HLINE, ApiConstants.EMPTY);
	}

	public static void main(String[] args) {
		System.out.println(generator());
	}
}
