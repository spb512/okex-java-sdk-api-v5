package com.okex.open.api.service.sub.account.impl;

import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.bean.sub.account.param.CreateSubAccountApikey;
import com.okex.open.api.bean.sub.account.param.DelSunAccountApikey;
import com.okex.open.api.bean.sub.account.param.ReSetSubAccountApikey;
import com.okex.open.api.bean.sub.account.param.SubAccountTransfer;
import com.okex.open.api.client.ApiClient;
import com.okex.open.api.config.ApiConfiguration;
import com.okex.open.api.service.sub.account.SubAccountApiService;

/**
 * 
 * @author spb512
 * @date 2022年6月5日 下午5:02:59
 *
 */
public class SubAccountApiServiceImpl implements SubAccountApiService {

	private ApiClient client;
	private SubAccountApi api;

	public SubAccountApiServiceImpl(ApiConfiguration config) {
		this.client = new ApiClient(config);
		this.api = client.createService(SubAccountApi.class);
	}

	/**
	 * 母账户查询子账户的交易账户详细资产余额（适用于母账户） Query detailed balance info of Trading Account
	 * ofa sub-account via the master account (applies to master accounts only)
	 */
	@Override
	public JSONObject getSubAccountBalances(String subAcct) {
		return this.client.executeSync(this.api.getSubAccountBalances(subAcct));
	}

	/**
	 * 子账户转账记录（仅适用于母账户） View sub-account list(applies to master accounts only)
	 */
	@Override
	public JSONObject getSubAccountBills(String ccy, String type, String subAcct, String after, String before,
			String limit) {
		return this.client.executeSync(this.api.getSubAccountBills(ccy, type, subAcct, after, before, limit));
	}

	/**
	 * 删除子账户的Apikey（仅适用于母账户） Delete the Apikey of sub-accounts (applies to master
	 * accounts only)
	 */
	@Override
	public JSONObject delSubAccountApiKey(DelSunAccountApikey delSunAccountApikey) {
		return this.client.executeSync(this.api.delSubAccountApiKey(delSunAccountApikey));
	}

	/**
	 * 重置子账户的Apikey（仅适用于母账户） Reset the Apikey of a sub-account(applies to master
	 * accounts only)
	 */
	@Override
	public JSONObject reSetSubAccountApiKey(ReSetSubAccountApikey reSetSubAccountApikey) {
		return this.client.executeSync(this.api.reSetSubAccountApiKey(reSetSubAccountApikey));
	}

	/**
	 * 创建子账户的Apikey（仅适用于母账户）Create an Apikey for a sub-account(applies to master
	 * accounts only)
	 */
	@Override
	public JSONObject createSubAccountApiKey(CreateSubAccountApikey createSubAccountApikey) {
		return this.client.executeSync(this.api.createSubAccountApiKey(createSubAccountApikey));
	}

	/**
	 * 查看子账户列表（仅适用于母账户） View sub-account list(applies to master accounts only)
	 */
	@Override
	public JSONObject getSubAccountList(String enable, String subAcct, String after, String before, String limit) {
		return this.client.executeSync(this.api.getSubAccountList(enable, subAcct, after, before, limit));
	}

	/**
	 * 母账户控制子账户与子账户之间划转（仅适用于母账户） Master accounts manage the transfers
	 * betweensub-accounts(applies to master accounts only)
	 */
	@Override
	public JSONObject subAccountTransfer(SubAccountTransfer subAccountTransfer) {
		return this.client.executeSync(this.api.subAccountTransfer(subAccountTransfer));
	}
}
