package com.okex.open.api.service.status;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @author spb512
 * @date 2022年6月5日 下午5:02:59
 *
 */
public interface StatusDataApiService {

	/**
	 * Status
	 * 
	 * @param state
	 * @return
	 */
	JSONObject getStatus(String state);
}
