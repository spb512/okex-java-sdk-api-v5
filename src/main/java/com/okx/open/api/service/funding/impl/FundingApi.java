package com.okx.open.api.service.funding.impl;

import com.alibaba.fastjson.JSONObject;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * 
 * @author spb512
 * @date 2022年7月24日
 */
public interface FundingApi {

	/**
	 * 获取充值地址信息 Get Deposit Address
	 * 
	 * @param ccy
	 * @return
	 */
	@GET("/api/v5/asset/deposit-address")
	Call<JSONObject> getDepositAddress(@Query("ccy") String ccy);

	/**
	 * 获取资金账户余额信息
	 * 
	 * @param ccy
	 * @return
	 */
	@GET("/api/v5/asset/balances")
	Call<JSONObject> getBalance(@Query("ccy") String ccy);

	/**
	 * 资金划转 Funds Transfer
	 * 
	 * @param jsonObject
	 * @return
	 */
	@POST("/api/v5/asset/transfer")
	Call<JSONObject> fundsTransfer(@Body JSONObject jsonObject);

	/**
	 * 提币 Withdrawal
	 * 
	 * @param jsonObject
	 * @return
	 */
	@POST("/api/v5/asset/withdrawal")
	Call<JSONObject> withdrawal(@Body JSONObject jsonObject);

	/**
	 * 充值记录 Get Deposit History
	 * 
	 * @param ccy
	 * @param state
	 * @param after
	 * @param before
	 * @param limit
	 * @return
	 */
	@GET("/api/v5/asset/deposit-history")
	Call<JSONObject> getDepositHistory(@Query("ccy") String ccy, @Query("state") String state,
			@Query("after") String after, @Query("before") String before, @Query("limit") String limit);

	/**
	 * 提币记录 Get Withdrawal History
	 * 
	 * @param ccy
	 * @param state
	 * @param after
	 * @param before
	 * @param limit
	 * @return
	 */
	@GET("/api/v5/asset/withdrawal-history")
	Call<JSONObject> getWithdrawalHistory(@Query("ccy") String ccy, @Query("state") String state,
			@Query("after") String after, @Query("before") String before, @Query("limit") String limit);

	/**
	 * 获取币种列表 Get Currencies
	 * 
	 * @return
	 */
	@GET("/api/v5/asset/currencies")
	Call<JSONObject> getCurrencies();

	/**
	 * 余币宝申购/赎回 PiggyBank Purchase/Redemption
	 * 
	 * @param jsonObject
	 * @return
	 */
	@POST("/api/v5/asset/purchase_redempt")
	Call<JSONObject> piggyBankPurchaseRedemption(@Body JSONObject jsonObject);

	/**
	 * 资金流水查询 Asset Bills Details
	 * 
	 * @param ccy
	 * @param type
	 * @param after
	 * @param before
	 * @param limit
	 * @return
	 */
	@GET("/api/v5/asset/bills")
	Call<JSONObject> assetBillsDetails(@Query("ccy") String ccy, @Query("type") String type,
			@Query("after") String after, @Query("before") String before, @Query("limit") String limit);

}