package com.okx.open.api.service.status.impl;

import com.alibaba.fastjson.JSONObject;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 
 * @author spb512
 * @date 2022年6月5日 下午5:02:59
 *
 */
public interface StatusDataApi {

	/**
	 * Status
	 * 
	 * @param state
	 * @return
	 */
	@GET("/api/v5/system/status")
	Call<JSONObject> getStatus(@Query("state") String state);
}
