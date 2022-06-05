package com.okex.open.api.test.status;

import com.okex.open.api.config.ApiConfiguration;
import com.okex.open.api.enums.I18nEnum;
import com.okex.open.api.test.BaseTests;

/**
 * 
 * @author spb512
 * @date 2022年6月5日 下午5:02:59
 *
 */
public class StatusDataApiBaseTest extends BaseTests {

	public ApiConfiguration config() {
		ApiConfiguration config = new ApiConfiguration();

		config.setEndpoint("https://www.okex.com/");

		config.setApiKey("");
		config.setSecretKey("");
		config.setPassphrase("");

		config.setPrint(true);
		/* config.setI18n(I18nEnum.SIMPLIFIED_CHINESE); */
		config.setI18n(I18nEnum.ENGLISH);
		return config;
	}

}
