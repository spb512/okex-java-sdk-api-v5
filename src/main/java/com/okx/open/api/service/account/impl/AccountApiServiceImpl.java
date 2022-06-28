package com.okx.open.api.service.account.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.okx.open.api.bean.account.param.IncreaseDecreaseMargin;
import com.okx.open.api.bean.account.param.SetLeverage;
import com.okx.open.api.bean.account.param.SetPositionMode;
import com.okx.open.api.bean.account.param.SetTheDisplayTypeOfGreeks;
import com.okx.open.api.client.ApiClient;
import com.okx.open.api.config.ApiConfiguration;
import com.okx.open.api.service.account.AccountApiService;

/**
 * 
 * @author spb512
 * @date 2022年6月5日 下午5:02:59
 *
 */
public class AccountApiServiceImpl implements AccountApiService {

	private ApiClient client;
	private AccountApi api;

	public AccountApiServiceImpl(ApiConfiguration config) {
		this.client = new ApiClient(config);
		this.api = client.createService(AccountApi.class);
	}

	/**
	 * 查看账户持仓风险 Get account and position risk
	 */
	@Override
	public JSONObject getAccountAndPosition(String instType) {
		return this.client.executeSync(this.api.getAccountAndPosition(instType));
	}

	/**
	 * 查看账户余额 Get Balance
	 */
	@Override
	public JSONObject getBalance(String ccy) {
		return this.client.executeSync(this.api.getBalance(ccy));
	}

	/**
	 * 查看持仓信息 Get Positions
	 */
	@Override
	public JSONObject getPositions(String instType, String instId, String posId) {
		return this.client.executeSync(this.api.getPositions(instType, instId, posId));
	}

	/**
	 * 账单流水查询（近七天） Get Bills Details (last 7 days)
	 */
	@Override
	public JSONObject getBillsDetails7Days(String instType, String ccy, String mgnMode, String ctType, String type,
			String subType, String after, String before, String limit) {
		return this.client.executeSync(
				this.api.getBillsDetails7Days(instType, ccy, mgnMode, ctType, type, subType, after, before, limit));
	}

	/**
	 * 账单流水查询（近七天） Get Bills Details (last 3 months)
	 */
	@Override
	public JSONObject getBillsDetails3Months(String instType, String ccy, String mgnMode, String ctType, String type,
			String subType, String after, String before, String limit) {
		return this.client.executeSync(
				this.api.getBillsDetails3Months(instType, ccy, mgnMode, ctType, type, subType, after, before, limit));
	}

	/**
	 * 查看账户配置 Get Account Configuration
	 */
	@Override
	public JSONObject getAccountConfiguration() {
		return this.client.executeSync(this.api.getAccountConfiguration());
	}

	/**
	 * 设置持仓模式 Set Position mode
	 */
	@Override
	public JSONObject setPositionMode(SetPositionMode setPositionMode) {
		return this.client
				.executeSync(this.api.setPositionMode(JSONObject.parseObject(JSON.toJSONString(setPositionMode))));
	}

	/**
	 * 设置杠杆倍数 Set Leverage
	 */
	@Override
	public JSONObject setLeverage(SetLeverage setLeverage) {
		return this.client.executeSync(this.api.setLeverage(JSONObject.parseObject(JSON.toJSONString(setLeverage))));
	}

	/**
	 * 获取最大可买卖/开仓数量 Get maximum buy/sell amount or open amount
	 */
	@Override
	public JSONObject getMaximumTradableSizeForInstrument(String instId, String tdMode, String ccy, String px) {
		return this.client.executeSync(this.api.getMaximumTradableSizeForInstrument(instId, tdMode, ccy, px));
	}

	/**
	 * 获取最大可用数量 Get Maximum Available Tradable Amount
	 */
	@Override
	public JSONObject getMaximumAvailableTradableAmount(String instId, String tdMode, String ccy, String reduceOnly) {
		return this.client.executeSync(this.api.getMaximumAvailableTradableAmount(instId, tdMode, ccy, reduceOnly));
	}

	/**
	 * 调整保证金 Increase/Decrease margin
	 */
	@Override
	public JSONObject increaseDecreaseMargin(IncreaseDecreaseMargin increaseDecreaseMargin) {
		return this.client.executeSync(
				this.api.increaseDecreaseMargin(JSONObject.parseObject(JSON.toJSONString(increaseDecreaseMargin))));
	}

	/**
	 * 获取杠杆倍数 Get Leverage
	 */
	@Override
	public JSONObject getLeverage(String instId, String mgnMode) {
		return this.client.executeSync(this.api.getLeverage(instId, mgnMode));
	}

	/**
	 * 获取币币逐仓杠杆最大可借 Get the maximum loan of instrument
	 */
	@Override
	public JSONObject getTheMaximumLoanOfIsolatedMargin(String instId, String mgnMode, String mgnCcy) {
		return this.client.executeSync(this.api.getTheMaximumLoanOfIsolatedMargin(instId, mgnMode, mgnCcy));
	}

	/**
	 * 获取当前账户交易手续费费率 Get Fee Rates
	 */
	@Override
	public JSONObject getFeeRates(String instType, String instId, String uly, String category) {
		return this.client.executeSync(this.api.getFeeRates(instType, instId, uly, category));
	}

	/**
	 * 获取计息记录 Get interest-accrued
	 */
	@Override
	public JSONObject getInterestAccrued(String instId, String ccy, String mgnMode, String after, String before,
			String limit) {
		return this.client.executeSync(this.api.getInterestAccrued(instId, ccy, mgnMode, after, before, limit));
	}

	/**
	 * 获取用户当前杠杆借币利率 Get interest rate
	 */
	@Override
	public JSONObject getInterestRate(String ccy) {
		return this.client.executeSync(this.api.getInterestRate(ccy));
	}

	/**
	 * 期权希腊字母PA/BS切换 Set the display type of Greeks
	 */
	@Override
	public JSONObject setTheDisplayTypeOfGreeks(SetTheDisplayTypeOfGreeks setTheDisplayTypeOfGreeks) {
		return this.client.executeSync(this.api
				.setTheDisplayTypeOfGreeks(JSONObject.parseObject(JSON.toJSONString(setTheDisplayTypeOfGreeks))));
	}

	/**
	 * 查看账户最大可转余额 Get Maximum Withdrawals
	 */
	@Override
	public JSONObject getMaximumWithdrawals(String ccy) {
		return this.client.executeSync(this.api.getMaximumWithdrawals(ccy));
	}
}
