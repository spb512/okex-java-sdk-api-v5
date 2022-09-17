package com.okx.open.api.service.publics.data;

import com.alibaba.fastjson2.JSONObject;

/**
 * 
 * @author spb512
 * @date 2022年6月5日 下午5:02:59
 *
 */
public interface PublicDataApiService {

	/**
	 * 获取交易产品基础信息 Get Instruments
	 * 
	 * @param instType
	 * @param uly
	 * @return
	 */
	JSONObject getInstruments(String instType, String uly, String instId);

	/**
	 * 获取交割和行权记录 Get Delivery/Exercise History
	 * 
	 * @param instType
	 * @param uly
	 * @param after
	 * @param before
	 * @param limit
	 * @return
	 */
	JSONObject getDeliveryExerciseHistory(String instType, String uly, String after, String before, String limit);

	/**
	 * 获取持仓总量 Get Open Interest
	 * 
	 * @param instType
	 * @param uly
	 * @param instId
	 * @return
	 */
	JSONObject getOpenInterest(String instType, String uly, String instId);

	/**
	 * 获取永续合约当前资金费率 Get Funding Rate
	 * 
	 * @param instId
	 * @return
	 */
	JSONObject getFundingRate(String instId);

	/**
	 * 获取永续合约历史资金费率 Get Funding Rate History
	 * 
	 * @param instId
	 * @param after
	 * @param before
	 * @param limit
	 * @return
	 */
	JSONObject getFundingRateHistory(String instId, String after, String before, String limit);

	/**
	 * 获取限价 Get Limit Price
	 * 
	 * @param instId
	 * @return
	 */
	JSONObject getLimitPrice(String instId);

	/**
	 * 获取期权定价 Get Option Market Data
	 * 
	 * @param uly
	 * @param expTime
	 * @return
	 */
	JSONObject getOptionMarketData(String uly, String expTime);

	/**
	 * 获取预估交割/行权价格 Get Estimated Delivery/Excercise Price
	 * 
	 * @param instId
	 * @return
	 */
	JSONObject getEstimatedDeliveryExcercisePrice(String instId);

	/**
	 * 获取免息额度和币种折算率 Get Discount Rate And Interest-Free Quota
	 * 
	 * @param ccy
	 * @return
	 */
	JSONObject getDiscountRateAndInterestFreeQuota(String ccy);

	/**
	 * 获取系统时间 Get System Time
	 * 
	 * @return
	 */
	JSONObject getSystemTime();

	/**
	 * 获取平台公共爆仓单信息 Get Liquidation Orders
	 * 
	 * @param instType
	 * @param mgnMode
	 * @param instId
	 * @param ccy
	 * @param uly
	 * @param alias
	 * @param state
	 * @param before
	 * @param after
	 * @param limit
	 * @return
	 */
	JSONObject getLiquidationOrders(String instType, String mgnMode, String instId, String ccy, String uly,
			String alias, String state, String before, String after, String limit);

	/**
	 * 获取标记价格 Get Mark Price
	 * 
	 * @param instType
	 * @param uly
	 * @param instId
	 * @return
	 */
	JSONObject getMarkPrice(String instType, String uly, String instId);

	/**
	 * 获取合约衍生品仓位档位
	 * 
	 * @param instType
	 * @param uly
	 * @param instId
	 * @param tdMode
	 * @param ccy
	 * @param tier
	 * @return
	 */
	JSONObject getTier(String instType, String uly, String instId, String tdMode, String ccy, String tier);
}
