package com.okx.open.api.service.funding.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.okx.open.api.bean.funding.param.FundsTransfer;
import com.okx.open.api.bean.funding.param.PiggyBankPurchaseRedemption;
import com.okx.open.api.bean.funding.param.Withdrawal;
import com.okx.open.api.client.ApiClient;
import com.okx.open.api.config.ApiConfiguration;
import com.okx.open.api.service.funding.FundingApiService;

/**
 * 
 * @author spb512
 * @date 2022年6月5日 下午5:02:59
 *
 */
public class FundingApiServiceImpl implements FundingApiService {

	private ApiClient client;
	private FundingApi api;

	public FundingApiServiceImpl(ApiConfiguration config) {
		this.client = new ApiClient(config);
		this.api = client.createService(FundingApi.class);
	}

	/**
	 * 获取充值地址信息 Get Deposit Address
	 */
	@Override
	public JSONObject getDepositAddress(String ccy) {
		return this.client.executeSync(this.api.getDepositAddress(ccy));
	}

	/**
	 * 获取资金账户余额信息 Get Balance
	 */
	@Override
	public JSONObject getBalance(String ccy) {
		return this.client.executeSync(this.api.getBalance(ccy));
	}

	/**
	 * 资金划转 Funds Transfer
	 */
	@Override
	public JSONObject fundsTransfer(FundsTransfer fundsTransfer) {
		return this.client
				.executeSync(this.api.fundsTransfer(JSONObject.parseObject(JSON.toJSONString(fundsTransfer))));
	}

	/**
	 * 提币 Withdrawal
	 */
	@Override
	public JSONObject withdrawal(Withdrawal withdrawal) {
		return this.client.executeSync(this.api.withdrawal(JSONObject.parseObject(JSON.toJSONString(withdrawal))));
	}

	/**
	 * 充值记录 Get Deposit History
	 */
	@Override
	public JSONObject getDepositHistory(String ccy, String state, String after, String before, String limit) {
		return this.client.executeSync(this.api.getDepositHistory(ccy, state, after, before, limit));
	}

	/**
	 * 提币记录 Get Withdrawal History
	 */

	@Override
	public JSONObject getWithdrawalHistory(String ccy, String state, String after, String before, String limit) {
		return this.client.executeSync(this.api.getWithdrawalHistory(ccy, state, after, before, limit));
	}

	/**
	 * 获取币种列表 Get Currencies
	 */
	@Override
	public JSONObject getCurrencies() {
		return this.client.executeSync(this.api.getCurrencies());
	}

	/**
	 * 余币宝申购/赎回 PiggyBank Purchase/Redemption
	 */
	@Override
	public JSONObject piggyBankPurchaseRedemption(PiggyBankPurchaseRedemption piggyBankPurchaseRedemption) {
		return this.client.executeSync(this.api
				.piggyBankPurchaseRedemption(JSONObject.parseObject(JSON.toJSONString(piggyBankPurchaseRedemption))));
	}

	/**
	 * 资金流水查询 Asset Bills Details
	 */
	@Override
	public JSONObject assetBillsDetails(String ccy, String type, String after, String before, String limit) {
		return this.client.executeSync(this.api.assetBillsDetails(ccy, type, after, before, limit));
	}
}
