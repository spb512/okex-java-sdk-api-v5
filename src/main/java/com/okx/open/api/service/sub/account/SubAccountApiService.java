package com.okx.open.api.service.sub.account;

import com.alibaba.fastjson.JSONObject;
import com.okx.open.api.bean.sub.account.param.CreateSubAccountApikey;
import com.okx.open.api.bean.sub.account.param.DelSunAccountApikey;
import com.okx.open.api.bean.sub.account.param.ReSetSubAccountApikey;
import com.okx.open.api.bean.sub.account.param.SubAccountTransfer;

/**
 * 
 * @author spb512
 * @date 2022年6月5日 下午5:02:59
 *
 */
public interface SubAccountApiService {

	/**
	 * 母账户查询子账户的交易账户详细资产余额（适用于母账户） Query detailed balance info of Trading Account
	 * ofa sub-account via the master account (applies to master accounts only)
	 * 
	 * @param subAcct
	 * @return
	 */
	JSONObject getSubAccountBalances(String subAcct);

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
	JSONObject getSubAccountBills(String ccy, String type, String subAcct, String after, String before, String limit);

	/**
	 * 删除子账户的Apikey（仅适用于母账户） Delete the Apikey of sub-accounts (applies to
	 * masteraccounts only)
	 * 
	 * @param delSunAccountApikey
	 * @return
	 */
	JSONObject delSubAccountApiKey(DelSunAccountApikey delSunAccountApikey);

	/**
	 * 重置子账户的Apikey（仅适用于母账户） Reset the Apikey of a sub-account(applies to
	 * masteraccounts only)
	 * 
	 * @param reSetSubAccountApikey
	 * @return
	 */
	JSONObject reSetSubAccountApiKey(ReSetSubAccountApikey reSetSubAccountApikey);

	/**
	 * 创建子账户的Apikey（仅适用于母账户）Create an Apikey for a sub-account(applies to
	 * masteraccounts only)
	 * 
	 * @param createSubAccountApikey
	 * @return
	 */
	JSONObject createSubAccountApiKey(CreateSubAccountApikey createSubAccountApikey);

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
	JSONObject getSubAccountList(String enable, String subAcct, String after, String before, String limit);

	/**
	 * 母账户控制子账户与子账户之间划转（仅适用于母账户） Master accounts manage the transfers
	 * betweensub-accounts(applies to master accounts only)
	 * 
	 * @param subAccountTransfer
	 * @return
	 */
	JSONObject subAccountTransfer(SubAccountTransfer subAccountTransfer);

}
