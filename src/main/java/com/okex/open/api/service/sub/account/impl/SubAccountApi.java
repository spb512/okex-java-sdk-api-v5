package com.okex.open.api.service.sub.account.impl;

import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.sub.account.param.CreateSubAccountApikey;
import com.okex.open.api.bean.sub.account.param.DelSunAccountApikey;
import com.okex.open.api.bean.sub.account.param.ReSetSubAccountApikey;
import com.okex.open.api.bean.sub.account.param.SubAccountTransfer;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 
 * @author spb512
 * @date 2022年6月5日 下午5:02:59
 *
 */
public interface SubAccountApi {

	/**
	 * 母账户查询子账户的交易账户详细资产余额（适用于母账户） Query detailed balance info of Trading Account
	 * ofa sub-account via the master account (applies to master accounts only)
	 * 
	 * @param subAcct
	 * @return
	 */
	@GET("/api/v5/account/subaccount/balances")
	Call<JSONObject> getSubAccountBalances(@Query("subAcct") String subAcct);

	/**
	 * 子账户转账记录（仅适用于母账户） View sub-account list(applies to master accounts only)
	 * 
	 * @param ccy
	 * @param type
	 * @param subAcct
	 * @param after
	 * @param before
	 * @param limit
	 * @return
	 */
	@GET("/api/v5/asset/subaccount/bills")
	Call<JSONObject> getSubAccountBills(@Query("ccy") String ccy, @Query("type") String type,
			@Query("subAcct") String subAcct, @Query("after") String after, @Query("before") String before,
			@Query("limit") String limit);

	/**
	 * 删除子账户的Apikey（仅适用于母账户） Delete the Apikey of sub-accounts (applies to
	 * masteraccounts only)
	 * 
	 * @param delSunAccountApikey
	 * @return
	 */
	@POST("/api/v5/users/subaccount/delete-apikey")
	Call<JSONObject> delSubAccountApiKey(@Body DelSunAccountApikey delSunAccountApikey);

	/**
	 * 重置子账户的Apikey（仅适用于母账户） Reset the Apikey of a sub-account(applies to
	 * masteraccounts only)
	 * 
	 * @param reSetSubAccountApikey
	 * @return
	 */
	@POST("/api/v5/users/subaccount/modify-apikey")
	Call<JSONObject> reSetSubAccountApiKey(@Body ReSetSubAccountApikey reSetSubAccountApikey);

	/**
	 * 创建子账户的Apikey（仅适用于母账户）Create an Apikey for a sub-account(applies to
	 * masteraccounts only)
	 * 
	 * @param createSubAccountApikey
	 * @return
	 */
	@POST("/api/v5/users/subaccount/apikey")
	Call<JSONObject> createSubAccountApiKey(@Body CreateSubAccountApikey createSubAccountApikey);

	/**
	 * 查看子账户列表（仅适用于母账户） View sub-account list(applies to master accounts only)
	 * 
	 * @param enable
	 * @param subAcct
	 * @param after
	 * @param before
	 * @param limit
	 * @return
	 */
	@GET("/api/v5/users/subaccount/list")
	Call<JSONObject> getSubAccountList(@Query("enable") String enable, @Query("subAcct") String subAcct,
			@Query("after") String after, @Query("before") String before, @Query("limit") String limit);

	/**
	 * 母账户控制子账户与子账户之间划转（仅适用于母账户） Master accounts manage the transfers
	 * betweensub-accounts(applies to master accounts only)
	 * 
	 * @param subAccountTransfer
	 * @return
	 */
	@POST("/api/v5/asset/subaccount/transfer")
	Call<JSONObject> subAccountTransfer(@Body SubAccountTransfer subAccountTransfer);

}
