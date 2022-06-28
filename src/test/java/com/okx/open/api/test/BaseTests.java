package com.okx.open.api.test;

import com.alibaba.fastjson.JSON;
import com.okx.open.api.config.ApiConfiguration;

import org.slf4j.Logger;

/**
 * 
 * @author spb512
 * @date 2022年6月5日 下午4:46:24
 *
 */
public class BaseTests {

	public ApiConfiguration config;

	public void toResultString(Logger log, String flag, Object object) {
		StringBuilder su = new StringBuilder();
		su.append("\n").append("=====>").append(flag).append(":\n").append(JSON.toJSONString(object));
		log.info(su.toString());
	}
}
