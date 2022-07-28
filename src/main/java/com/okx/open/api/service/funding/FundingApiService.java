package com.okx.open.api.service.funding;

import com.alibaba.fastjson2.JSONObject;
import com.okx.open.api.bean.funding.param.FundsTransfer;
import com.okx.open.api.bean.funding.param.PiggyBankPurchaseRedemption;
import com.okx.open.api.bean.funding.param.Withdrawal;

/**
 * 
 * @author spb512
 * @date 2022年6月5日 下午5:02:59
 *
 */
public interface FundingApiService {

	/**
	 * 获取充值地址信息 Get Deposit Address
	 * 
	 * @param ccy
	 * @return
	 */
	JSONObject getDepositAddress(String ccy);

	/**
	 * 获取资金账户余额信息
	 * 
	 * @param ccy
	 * @return
	 */
	JSONObject getBalance(String ccy);

	/**
	 * 资金划转 Funds Transfer
	 * 
	 * @param fundsTransfer
	 * @return
	 */
	JSONObject fundsTransfer(FundsTransfer fundsTransfer);

	/**
	 * 提币 Withdrawal
	 * 
	 * @param withdrawal
	 * @return
	 */
	JSONObject withdrawal(Withdrawal withdrawal);

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
	JSONObject getDepositHistory(String ccy, String state, String after, String before, String limit);

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
	JSONObject getWithdrawalHistory(String ccy, String state, String after, String before, String limit);

	/**
	 * 获取币种列表 Get Currencies
	 * 
	 * @return
	 */
	JSONObject getCurrencies();

	/**
	 * 余币宝申购/赎回 PiggyBank Purchase/Redemption
	 * 
	 * @param piggyBankPurchaseRedemption
	 * @return
	 */
	JSONObject piggyBankPurchaseRedemption(PiggyBankPurchaseRedemption piggyBankPurchaseRedemption);

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
	JSONObject assetBillsDetails(String ccy, String type, String after, String before, String limit);
}
