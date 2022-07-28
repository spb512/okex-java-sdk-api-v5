package com.okx.open.api.service.publics.data.impl;

import com.alibaba.fastjson2.JSONObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 
 * @author spb512
 * @date 2022年6月5日 下午4:45:55
 *
 */
public interface PublicDataApi {

	/**
	 * 获取交易产品基础信息 Get Instruments
	 * 
	 * @param instType
	 * @param uly
	 * @return
	 */
	@GET("/api/v5/public/instruments")
	Call<JSONObject> getInstruments(@Query("instType") String instType, @Query("uly") String uly);

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
	@GET("/api/v5/public/delivery-exercise-history")
	Call<JSONObject> getDeliveryExerciseHistory(@Query("instType") String instType, @Query("uly") String uly,
			@Query("after") String after, @Query("before") String before, @Query("limit") String limit);

	/**
	 * 获取持仓总量 Get Open Interest
	 * 
	 * @param instType
	 * @param uly
	 * @param instId
	 * @return
	 */
	@GET("/api/v5/public/open-interest")
	Call<JSONObject> getOpenInterest(@Query("instType") String instType, @Query("uly") String uly,
			@Query("instId") String instId);

	/**
	 * 获取永续合约当前资金费率 Get Funding Rate
	 * 
	 * @param instId
	 * @return
	 */
	@GET("/api/v5/public/funding-rate")
	Call<JSONObject> getFundingRate(@Query("instId") String instId);

	/**
	 * 获取永续合约历史资金费率 Get Funding Rate History
	 * 
	 * @param instId
	 * @param after
	 * @param before
	 * @param limit
	 * @return
	 */
	@GET("/api/v5/public/funding-rate-history")
	Call<JSONObject> getFundingRateHistory(@Query("instId") String instId, @Query("after") String after,
			@Query("before") String before, @Query("limit") String limit);

	/**
	 * 获取限价 Get Limit Price
	 * 
	 * @param instId
	 * @return
	 */
	@GET("/api/v5/public/price-limit")
	Call<JSONObject> getLimitPrice(@Query("instId") String instId);

	/**
	 * 获取期权定价 Get Option Market Data
	 * 
	 * @param uly
	 * @param expTime
	 * @return
	 */
	@GET("/api/v5/public/opt-summary")
	Call<JSONObject> getOptionMarketData(@Query("uly") String uly, @Query("expTime") String expTime);

	/**
	 * 获取预估交割/行权价格 Get Estimated Delivery/Excercise Price
	 * 
	 * @param instId
	 * @return
	 */
	@GET("/api/v5/public/estimated-price")
	Call<JSONObject> getEstimatedDeliveryExcercisePrice(@Query("instId") String instId);

	/**
	 * 获取免息额度和币种折算率 Get Discount Rate And Interest-Free Quota
	 * 
	 * @param ccy
	 * @return
	 */
	@GET("/api/v5/public/discount-rate-interest-free-quota")
	Call<JSONObject> getDiscountRateAndInterestFreeQuota(@Query("ccy") String ccy);

	/**
	 * 获取系统时间 Get System Time
	 * 
	 * @return
	 */
	@GET("/api/v5/public/time")
	Call<JSONObject> getSystemTime();

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
	@GET("/api/v5/public/liquidation-orders")
	Call<JSONObject> getLiquidationOrders(@Query("instType") String instType, @Query("mgnMode") String mgnMode,
			@Query("instId") String instId, @Query("ccy") String ccy, @Query("uly") String uly,
			@Query("alias") String alias, @Query("state") String state, @Query("before") String before,
			@Query("after") String after, @Query("limit") String limit);

	/**
	 * 获取标记价格 Get Mark Price
	 * 
	 * @param instType
	 * @param uly
	 * @param instId
	 * @return
	 */
	@GET("/api/v5/public/mark-price")
	Call<JSONObject> getMarkPrice(@Query("instType") String instType, @Query("uly") String uly,
			@Query("instId") String instId);

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
	@GET("/api/v5/public/tier")
	Call<JSONObject> getTier(@Query("instType") String instType, @Query("uly") String uly,
			@Query("instId") String instId, @Query("tdMode") String tdMode, @Query("ccy") String ccy,
			@Query("tier") String tier);

}
