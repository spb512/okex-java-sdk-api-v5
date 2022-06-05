package com.okex.open.api.service.account.impl;

import com.alibaba.fastjson.JSONObject;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * 
 * @author spb512
 * @date 2022年6月5日 下午5:02:59
 *
 */
public interface AccountApi {

	/**
	 * 查看账户持仓风险 Get account and position risk
	 * 
	 * @param instType
	 * @return
	 */
	@GET("/api/v5/account/account-position-risk")
	Call<JSONObject> getAccountAndPosition(@Query("instType") String instType);

	/**
	 * 查看账户余额 Get Balance
	 * 
	 * @param ccy
	 * @return
	 */
	@GET("/api/v5/account/balance")
	Call<JSONObject> getBalance(@Query("ccy") String ccy);

	/**
	 * 查看持仓信息 Get Positions
	 * 
	 * @param instType
	 * @param instId
	 * @param posId
	 * @return
	 */
	@GET("/api/v5/account/positions")
	Call<JSONObject> getPositions(@Query("instType") String instType, @Query("instId") String instId,
			@Query("posId") String posId);

	/**
	 * 账单流水查询（近七天） Get Bills Details (last 7 days)
	 * 
	 * @param instType
	 * @param ccy
	 * @param mgnMode
	 * @param ctType
	 * @param type
	 * @param subType
	 * @param after
	 * @param before
	 * @param limit
	 * @return
	 */
	@GET("/api/v5/account/bills")
	Call<JSONObject> getBillsDetails7Days(@Query("instType") String instType, @Query("ccy") String ccy,
			@Query("mgnMode") String mgnMode, @Query("ctType") String ctType, @Query("type") String type,
			@Query("subType") String subType, @Query("after") String after, @Query("before") String before,
			@Query("limit") String limit);

	/**
	 * 账单流水查询（近七天） Get Bills Details (last 3 months)
	 * 
	 * @param instType
	 * @param ccy
	 * @param mgnMode
	 * @param ctType
	 * @param type
	 * @param subType
	 * @param after
	 * @param before
	 * @param limit
	 * @return
	 */
	@GET("/api/v5/account/bills-archive")
	Call<JSONObject> getBillsDetails3Months(@Query("instType") String instType, @Query("ccy") String ccy,
			@Query("mgnMode") String mgnMode, @Query("ctType") String ctType, @Query("type") String type,
			@Query("subType") String subType, @Query("after") String after, @Query("before") String before,
			@Query("limit") String limit);

	/**
	 * 查看账户配置 Get Account Configuration
	 * 
	 * @return
	 */
	@GET("/api/v5/account/config")
	Call<JSONObject> getAccountConfiguration();

	/**
	 * 设置持仓模式 Set Position mode
	 * 
	 * @param jsonObject
	 * @return
	 */
	@POST("/api/v5/account/set-position-mode")
	Call<JSONObject> setPositionMode(@Body JSONObject jsonObject);

	/**
	 * 设置杠杆倍数 Set Leverage
	 * 
	 * @param jsonObject
	 * @return
	 */
	@POST("/api/v5/account/set-leverage")
	Call<JSONObject> setLeverage(@Body JSONObject jsonObject);

	/**
	 * 获取最大可买卖/开仓数量 Get maximum buy/sell amount or open amount
	 * 
	 * @param instId
	 * @param tdMode
	 * @param ccy
	 * @param px
	 * @return
	 */
	@GET("/api/v5/account/max-size")
	Call<JSONObject> getMaximumTradableSizeForInstrument(@Query("instId") String instId, @Query("tdMode") String tdMode,
			@Query("ccy") String ccy, @Query("px") String px);

	/**
	 * 获取最大可用数量 Get Maximum Tradable Size For Instrument
	 * 
	 * @param instId
	 * @param tdMode
	 * @param ccy
	 * @param reduceOnly
	 * @return
	 */
	@GET("/api/v5/account/max-avail-size")
	Call<JSONObject> getMaximumAvailableTradableAmount(@Query("instId") String instId, @Query("tdMode") String tdMode,
			@Query("ccy") String ccy, @Query("reduceOnly") String reduceOnly);

	/**
	 * 调整保证金 Increase/Decrease margin
	 * 
	 * @param jsonObject
	 * @return
	 */
	@POST("/api/v5/account/position/margin-balance")
	Call<JSONObject> increaseDecreaseMargin(@Body JSONObject jsonObject);

	/**
	 * 获取杠杆倍数 Get Leverage
	 * 
	 * @param instId
	 * @param mgnMode
	 * @return
	 */
	@GET("/api/v5/account/leverage-info")
	Call<JSONObject> getLeverage(@Query("instId") String instId, @Query("mgnMode") String mgnMode);

	/**
	 * 获取交易产品最大可借 Get the maximum loan of instrument
	 * 
	 * @param instId
	 * @param mgnMode
	 * @param mgnCcy
	 * @return
	 */
	@GET("/api/v5/account/max-loan")
	Call<JSONObject> getTheMaximumLoanOfIsolatedMargin(@Query("instId") String instId, @Query("mgnMode") String mgnMode,
			@Query("mgnCcy") String mgnCcy);

	/**
	 * 获取当前账户交易手续费费率 Get Fee Rates
	 * 
	 * @param instType
	 * @param instId
	 * @param uly
	 * @param category
	 * @return
	 */
	@GET("/api/v5/account/trade-fee")
	Call<JSONObject> getFeeRates(@Query("instType") String instType, @Query("instId") String instId,
			@Query("uly") String uly, @Query("category") String category);

	/**
	 * 获取计息记录 Get interest-accrued
	 * 
	 * @param instId
	 * @param ccy
	 * @param mgnMode
	 * @param after
	 * @param before
	 * @param limit
	 * @return
	 */
	@GET("/api/v5/account/interest-accrued")
	Call<JSONObject> getInterestAccrued(@Query("instId") String instId, @Query("ccy") String ccy,
			@Query("mgnMode") String mgnMode, @Query("after") String after, @Query("before") String before,
			@Query("limit") String limit);

	/**
	 * 获取用户当前杠杆借币利率 Get interest rate
	 * 
	 * @param ccy
	 * @return
	 */
	@GET("/api/v5/account/interest-rate")
	Call<JSONObject> getInterestRate(@Query("ccy") String ccy);

	/**
	 * 期权希腊字母PA/BS切换 Set the display type of Greeks
	 * 
	 * @param jsonObject
	 * @return
	 */
	@POST("/api/v5/account/set-greeks")
	Call<JSONObject> setTheDisplayTypeOfGreeks(@Body JSONObject jsonObject);

	/**
	 * 查看账户最大可转余额 Get Maximum Withdrawals
	 * 
	 * @param ccy
	 * @return
	 */
	@GET("/api/v5/account/max-withdrawal")
	Call<JSONObject> getMaximumWithdrawals(@Query("ccy") String ccy);
}
