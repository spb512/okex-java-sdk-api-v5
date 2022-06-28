package com.okx.open.api.test.publics.data;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.okx.open.api.service.publics.data.PublicDataApiService;
import com.okx.open.api.service.publics.data.impl.PublicDataApiServiceImpl;

/**
 * 
 * @author spb512
 * @date 2022年6月5日 下午5:02:59
 *
 */
public class PublicDataApiTest extends PublicDataApiBaseTest {
	private static final Logger LOG = LoggerFactory.getLogger(PublicDataApiTest.class);

	private PublicDataApiService publicDataApiService;

	@Before
	public void before() {
		config = config();
		publicDataApiService = new PublicDataApiServiceImpl(config);
	}

	/**
	 * 获取交易产品基础信息 Get Instruments GET /api/v5/public/instruments
	 */
	@Test
	public void getInstruments() {
		JSONObject result = publicDataApiService.getInstruments("SWAP", null);
		toResultString(LOG, "result", result);

	}

	/**
	 * 获取交割和行权记录 Get Delivery/Exercise History GET
	 * /api/v5/public/delivery-exercise-history
	 */
	@Test
	public void getDeliveryExerciseHistory() {
		JSONObject result = publicDataApiService.getDeliveryExerciseHistory("OPTION", "BTC-USD", "", "", "");
		toResultString(LOG, "result", result);
	}

	/**
	 * 获取持仓总量 Get Open Interest GET /api/v5/public/open-interest
	 */
	@Test
	public void getOpenInterest() {
		JSONObject result = publicDataApiService.getOpenInterest("FUTURES", "LTC-USDT", "LTC-USDT-210416");
		toResultString(LOG, "result", result);
	}

	/**
	 * 获取永续合约当前资金费率 Get Funding Rate GET /api/v5/public/funding-rate
	 */
	@Test
	public void getFundingRate() {
		JSONObject result = publicDataApiService.getFundingRate("BTC-USDT-SWAP");
		toResultString(LOG, "result", result);
	}

	/**
	 * 获取永续合约历史资金费率 Get Funding Rate History GET /api/v5/public/funding-rate-history
	 */
	@Test
	public void getFundingRateHistory() {
		JSONObject result = publicDataApiService.getFundingRateHistory("ETH-USD-SWAP", "", "", "");
		toResultString(LOG, "result", result);
	}

	/**
	 * 获取限价 Get Limit Price GET /api/v5/public/price-limit
	 */
	@Test
	public void getLimitPrice() {
		JSONObject result = publicDataApiService.getLimitPrice("BTC-USD-210326");
		toResultString(LOG, "result", result);
	}

	/**
	 * 获取期权定价 Get Option Market Data GET /api/v5/public/opt-summary
	 */
	@Test
	public void getOptionMarketData() {
		JSONObject result = publicDataApiService.getOptionMarketData("BTC-USD", "");
		toResultString(LOG, "result", result);
	}

	/**
	 * 获取预估交割/行权价格 Get Estimated Delivery/Excercise Price GET
	 * /api/v5/public/estimated-price
	 */
	@Test
	public void getEstimatedDeliveryExcercisePrice() {
		JSONObject result = publicDataApiService.getEstimatedDeliveryExcercisePrice("BTC-USD-210326");
		toResultString(LOG, "result", result);
	}

	/**
	 * 获取免息额度和币种折算率 Get Discount Rate And Interest-Free Quota GET
	 * /api/v5/public/discount-rate-interest-free-quota
	 */
	@Test
	public void getDiscountRateAndInterestFreeQuota() {
		JSONObject result = publicDataApiService.getDiscountRateAndInterestFreeQuota(null);
		toResultString(LOG, "result", result);
	}

	/**
	 * 获取系统时间 Get System Time GET /api/v5/public/time
	 */
	@Test
	public void getSystemTime() {
		JSONObject result = publicDataApiService.getSystemTime();
		toResultString(LOG, "result", result);
	}

	/**
	 * 获取平台公共爆仓单信息 Get Liquidation Orders GET /api/v5/public/liquidation-orders
	 */
	@Test
	public void getLiquidationOrders() {
		JSONObject result = publicDataApiService.getLiquidationOrders("FUTURES", null, null, null, "BTC-USDT",
				"quarter", "filled", null, null, null);
		toResultString(LOG, "result", result);
	}

	/**
	 * 获取标记价格 Get Mark Price GET /api/v5/public/mark-price
	 */
	@Test
	public void getMarkPrice() {
		JSONObject result = publicDataApiService.getMarkPrice("FUTURES", "", "");
		toResultString(LOG, "result", result);
	}

	/**
	 * 获取合约衍生品仓位档位 Get Mark Price GET /api/v5/public/tier
	 */
	@Test
	public void getTier() {
		JSONObject result = publicDataApiService.getTier("FUTURES", "BTC-USDT", null, "isolated", null, null);
		toResultString(LOG, "result", result);
	}

}
