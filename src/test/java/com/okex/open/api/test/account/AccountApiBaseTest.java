package com.okex.open.api.test.account;

import com.okex.open.api.config.ApiConfiguration;
import com.okex.open.api.enums.I18nEnum;
import com.okex.open.api.test.BaseTests;

/**
 * Account api basetests
 *
 * @author hucj
 * @version 1.0.0
 * @date 2018/7/04 18:23
 */
public class AccountApiBaseTest extends BaseTests {

	public ApiConfiguration config() {
		ApiConfiguration config = new ApiConfiguration();

		config.setEndpoint("https://www.okex.com/");
		// apiKey，api注册成功后页面上有

		config.setApiKey("****");
		config.setSecretKey("***");
		config.setPassphrase("***");

		config.setPrint(true);
		config.setI18n(I18nEnum.ENGLISH);

		return config;
	}

}
