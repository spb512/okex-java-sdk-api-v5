package com.okx.open.api.test.funding;

import com.alibaba.fastjson.JSONObject;
import com.okx.open.api.bean.funding.param.FundsTransfer;
import com.okx.open.api.bean.funding.param.PiggyBankPurchaseRedemption;
import com.okx.open.api.bean.funding.param.Withdrawal;
import com.okx.open.api.service.funding.FundingApiService;
import com.okx.open.api.service.funding.impl.FundingApiServiceImpl;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author spb512
 * @date 2022年6月5日 下午4:51:47
 *
 */
public class FundingApiTests extends FundingApiBaseTest {

	Logger logger = LoggerFactory.getLogger(getClass());

	private FundingApiService fundingApiService;

	@Before
	public void before() {
		config = config();
		fundingApiService = new FundingApiServiceImpl(config);
	}

	/**
	 * 获取充值地址信息 Get Deposit Address GET /api/v5/asset/deposit-address
	 */
	@Test
	public void getDepositAddress() {
		JSONObject result = fundingApiService.getDepositAddress("BTC");
		toResultString(logger, "result", result);
	}

	/**
	 * 获取资金账户余额信息 Get Balance GET /api/v5/asset/balances
	 */
	@Test
	public void getBalance() {
		JSONObject result = fundingApiService.getBalance("USDT");
		toResultString(logger, "result", result);
	}

	/**
	 * 资金划转 Funds Transfer POST /api/v5/asset/transfer
	 */
	@Test
	public void fundsTransfer() {
		FundsTransfer fundsTransfer = new FundsTransfer();
		fundsTransfer.setCcy("EOS");
		fundsTransfer.setAmt("2");
		fundsTransfer.setType("0");
		fundsTransfer.setFrom("9");
		fundsTransfer.setTo("3");
//        fundsTransfer.setSubAcct("");
		fundsTransfer.setInstId("EOS-USD");
		fundsTransfer.setToInstId("EOS-USD");
		JSONObject result = fundingApiService.fundsTransfer(fundsTransfer);
		toResultString(logger, "result", result);
	}

	/**
	 * 提币 withdrawal POST /api/v5/asset/withdrawal
	 */
	@Test
	public void withdrawal() {
		Withdrawal withdrawal = new Withdrawal();
		withdrawal.setCcy("USDT");
		withdrawal.setAmt("100");
		withdrawal.setDest("3");
		withdrawal.setToAddr("46674851");
		withdrawal.setPwd("888888");
		withdrawal.setFee("1");
		JSONObject result = fundingApiService.withdrawal(withdrawal);
		toResultString(logger, "result", result);
	}

	/**
	 * 充值记录 Get Deposit History GET /api/v5/asset/deposit-history
	 */
	@Test
	public void getDepositHistory() {
		JSONObject result = fundingApiService.getDepositHistory("BTC", "", "", "", "");
		toResultString(logger, "result", result);
	}

	/**
	 * 提币记录 Get Withdrawal History GET /api/v5/asset/withdrawal-history
	 */
	@Test
	public void getWithdrawalHistory() {
		JSONObject result = fundingApiService.getWithdrawalHistory("BTC", "", "", "", "");
		toResultString(logger, "result", result);
	}

	/**
	 * 获取币种列表 Get Currencies GET /api/v5/asset/currencies
	 */
	@Test
	public void getCurrencies() {
		JSONObject result = fundingApiService.getCurrencies();
		toResultString(logger, "result", result);
	}

	/**
	 * 余币宝申购/赎回 PiggyBank Purchase/Redemption POST /api/v5/asset/purchase_redempt
	 */
	@Test
	public void piggyBankPurchaseRedemption() {
		PiggyBankPurchaseRedemption piggyBankPurchaseRedemption = new PiggyBankPurchaseRedemption();
		piggyBankPurchaseRedemption.setCcy("USDT");
		piggyBankPurchaseRedemption.setAmt("1");
		piggyBankPurchaseRedemption.setSide("purchase");
		JSONObject result = fundingApiService.piggyBankPurchaseRedemption(piggyBankPurchaseRedemption);
		toResultString(logger, "result", result);
	}

	/**
	 * 资金流水查询 Asset Bills Details GET /api/v5/asset/bills
	 */
	@Test
	public void assetBillsDetails() {
		JSONObject result = fundingApiService.assetBillsDetails("BTC", null, null, null, null);
		toResultString(logger, "result", result);
	}

}
