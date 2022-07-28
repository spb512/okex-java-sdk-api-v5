package com.okx.open.api.service.status.impl;

import com.alibaba.fastjson2.JSONObject;
import com.okx.open.api.client.ApiClient;
import com.okx.open.api.config.ApiConfiguration;
import com.okx.open.api.service.status.StatusDataApiService;

/**
 * 
 * @author spb512
 * @date 2022年6月5日 下午5:02:59
 *
 */
public class StatusDataApiServiceImpl implements StatusDataApiService {

	private final ApiClient client;
	private final StatusDataApi statusDataApi;

	public StatusDataApiServiceImpl(final ApiConfiguration config) {
		this.client = new ApiClient(config);
		this.statusDataApi = this.client.createService(StatusDataApi.class);
	}

	/**
	 * status
	 */
	@Override
	public JSONObject getStatus(String state) {
		return this.client.executeSync(this.statusDataApi.getStatus(state));
	}
}
