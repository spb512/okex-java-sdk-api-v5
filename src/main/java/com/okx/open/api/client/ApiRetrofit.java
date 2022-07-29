package com.okx.open.api.client;

import com.okx.open.api.config.ApiConfiguration;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 
 * @author spb512
 * @date 2022年6月5日 下午5:02:59
 *
 */
public class ApiRetrofit {

	private ApiConfiguration config;
	private OkHttpClient client;

	public ApiRetrofit(ApiConfiguration config, OkHttpClient client) {
		this.config = config;
		this.client = client;
	}

	/**
	 * Get a retrofit 2 object.
	 */
	public Retrofit retrofit() {
		Retrofit.Builder builder = new Retrofit.Builder();
		builder.client(this.client);
		builder.addConverterFactory(GsonConverterFactory.create());
		builder.baseUrl(this.config.getEndpoint());
		return builder.build();
	}
}
