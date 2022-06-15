package com.okex.open.api.test.status;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.service.status.StatusDataApiService;
import com.okex.open.api.service.status.impl.StatusDataApiServiceImpl;

/**
 * 
 * @author spb512
 * @date 2022年6月5日 下午5:02:59
 *
 */
public class StatusDataApiTest extends StatusDataApiBaseTest {

	private static final Logger LOG = LoggerFactory.getLogger(StatusDataApiTest.class);
	private StatusDataApiService statusDataApiService;

	@Before
	public void before() {
		config = config();
		statusDataApiService = new StatusDataApiServiceImpl(config);
	}

	/**
	 * status GET /api/v5/system/status
	 */
	@Test
	public void testGetStatus() {
		JSONObject result = statusDataApiService.getStatus("completed");
		this.toResultString(StatusDataApiTest.LOG, "result", result);

	}

}
