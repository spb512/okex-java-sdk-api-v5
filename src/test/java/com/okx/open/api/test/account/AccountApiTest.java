package com.okx.open.api.test.account;

import com.alibaba.fastjson.JSONObject;
import com.okx.open.api.bean.account.param.*;
import com.okx.open.api.service.account.AccountApiService;
import com.okx.open.api.service.account.impl.AccountApiServiceImpl;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author spb512
 * @date 2022年6月5日 下午4:46:04
 *
 */
public class AccountApiTest extends AccountApiBaseTest {

	private static final Logger LOG = LoggerFactory.getLogger(AccountApiTest.class);

	private AccountApiService accountApiService;

	@Before
	public void before() {
		this.config = this.config();
		this.accountApiService = new AccountApiServiceImpl(this.config);
	}

	/**
	 * 查看账户持仓风险 Get account and position risk GET
	 * /api/v5/account/account-position-risk
	 */
	@Test
	public void getAccountAndPosition() {
		JSONObject result = this.accountApiService.getAccountAndPosition("SWAP");
		toResultString(LOG, "result", result);
	}

	/**
	 * 查看账户余额 Get Balance GET /api/v5/account/balance
	 */
	@Test
	public void getBalance() {
		JSONObject result = this.accountApiService.getBalance("USDT");
		toResultString(LOG, "result", result);
	}

	/**
	 * 查看持仓信息 Get Positions GET /api/v5/account/positions
	 */
	@Test
	public void getPositions() {
		JSONObject result = this.accountApiService.getPositions("SWAP", null, null);
		toResultString(LOG, "result", result);
	}

	/**
	 * 账单流水查询（近七天） Get Bills Details (last 7 days) GET /api/v5/account/bills
	 */
	@Test
	public void getBillsDetails7Days() {
		JSONObject result = this.accountApiService.getBillsDetails7Days("FUTERES", "", "", "", "", "", "", "", "");
		toResultString(LOG, "result", result);
	}

	/**
	 * 账单流水查询（近三个月） Get Bills Details (last 3 months) GET
	 * /api/v5/account/bills-archive
	 */
	@Test
	public void getBillsDetails3Months() {
		JSONObject result = this.accountApiService.getBillsDetails3Months("SWAP", null, null, null, "8", null, null,
				null, null);
		toResultString(LOG, "result", result);
	}

	/**
	 * 查看账户配置 Get Account Configuration GET /api/v5/account/config
	 */
	@Test
	public void getAccountConfiguration() {
		JSONObject result = this.accountApiService.getAccountConfiguration();
		toResultString(LOG, "result", result);
	}

	/**
	 * 设置持仓模式 Set Position mode POST /api/v5/account/set-position-mode
	 */
	@Test
	public void setPositionMode() {
		SetPositionMode setPositionMode = new SetPositionMode();
		setPositionMode.setPosMode("long_short_mode");
		JSONObject result = this.accountApiService.setPositionMode(setPositionMode);
		toResultString(LOG, "result", result);
	}

	/**
	 * 设置杠杆倍数 Set Leverage POST /api/v5/account/set-leverage
	 */
	@Test
	public void setLeverage() {
		SetLeverage setLeverage = new SetLeverage();
		setLeverage.setInstId("BTC-USDT-SWAP");
//        setLeverage.setCcy("");
		setLeverage.setLever("13.3");
		setLeverage.setMgnMode("cross");
		setLeverage.setPosSide("net");

		JSONObject result = this.accountApiService.setLeverage(setLeverage);
		toResultString(LOG, "result", result);
	}

	/**
	 * 获取最大可买卖/开仓数量 Get maximum buy/sell amount or open amount GET
	 * /api/v5/account/max-size
	 */
	@Test
	public void getMaximumTradableSizeForInstrument() {
		JSONObject result = this.accountApiService.getMaximumTradableSizeForInstrument("BTC-USDT", "cross", "BTC", "");
		toResultString(LOG, "result", result);
	}

	/**
	 * 获取最大可用数量 Get Maximum Available Tradable Amount GET
	 * /api/v5/account/max-avail-size
	 */
	@Test
	public void getMaximumAvailableTradableAmount() {
		JSONObject result = this.accountApiService.getMaximumAvailableTradableAmount("BTC-USDT-210924", "isolated", "",
				"");
		toResultString(LOG, "result", result);
	}

	/**
	 * 调整保证金 Increase/Decrease margin POST /api/v5/account/position/margin-balance
	 */
	@Test
	public void increaseDecreaseMargin() {
		IncreaseDecreaseMargin increaseDecreaseMargin = new IncreaseDecreaseMargin();

		increaseDecreaseMargin.setInstId("BTC-USDT-210924");
		increaseDecreaseMargin.setPosSide("long");
		increaseDecreaseMargin.setType("add");
		increaseDecreaseMargin.setAmt("100");

		JSONObject result = this.accountApiService.increaseDecreaseMargin(increaseDecreaseMargin);
		toResultString(LOG, "result", result);
	}

	/**
	 * 获取杠杆倍数 Get Leverage GET /api/v5/account/leverage-info
	 */
	@Test
	public void getLeverage() {
		JSONObject result = this.accountApiService.getLeverage("ETH-USDT-SWAP", "isolated");
		toResultString(LOG, "result", result);
	}

	/**
	 * 获取交易产品最大可借 Get the maximum loan of instrument GET /api/v5/account/max-loan
	 */
	@Test
	public void getTheMaximumLoanOfIsolatedMargin() {
		JSONObject result = this.accountApiService.getTheMaximumLoanOfIsolatedMargin("BTC-USDT", "cross", "BTC");
		toResultString(LOG, "result", result);
	}

	/**
	 * 获取当前账户交易手续费费率 Get Fee Rates GET /api/v5/account/trade-fee
	 */
	@Test
	public void getFeeRates() {
		JSONObject result = this.accountApiService.getFeeRates("SWAP", null, "BTC-USDT", null);
		toResultString(LOG, "result", result);
	}

	/**
	 * 获取计息记录 Get interest-accrued GET /api/v5/account/interest-accrued
	 */
	@Test
	public void getInterestAccrued() {
		JSONObject result = this.accountApiService.getInterestAccrued("BTC-USDT", "USDT", "", "", "", "");
		toResultString(LOG, "result", result);
	}

	/**
	 * 获取用户当前杠杆借币利率 Get interest rate GET /api/v5/account/interest-rate
	 */
	@Test
	public void getInterestRate() {
		JSONObject result = this.accountApiService.getInterestRate("USDT");
		toResultString(LOG, "result", result);
	}

	/**
	 * 期权希腊字母PA/BS切换 Set Greeks (PA/BS) POST /api/v5/account/set-greeks
	 */
	@Test
	public void setTheDisplayTypeOfGreeks() {
		SetTheDisplayTypeOfGreeks setTheDisplayTypeOfGreeks = new SetTheDisplayTypeOfGreeks();
		setTheDisplayTypeOfGreeks.setGreeksType("PA");
		JSONObject result = this.accountApiService.setTheDisplayTypeOfGreeks(setTheDisplayTypeOfGreeks);
		toResultString(LOG, "result", result);
	}

	/**
	 * 查看账户最大可转余额 Get Maximum Withdrawals GET /api/v5/account/max-withdrawal
	 */
	@Test
	public void getMaximumWithdrawals() {
		JSONObject result = this.accountApiService.getMaximumWithdrawals("USDT");
		toResultString(LOG, "result", result);
	}

}
