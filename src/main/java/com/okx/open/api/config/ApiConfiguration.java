package com.okx.open.api.config;

import com.okx.open.api.constant.ApiConstants;
import com.okx.open.api.enums.I18nEnum;

/**
 * 
 * @author spb512
 * @date 2022年6月5日 下午5:02:59
 *
 */
public class ApiConfiguration {

	/**
	 * The user's api key provided by OKx.
	 */
	private String apiKey;
	/**
	 * The user's secret key provided by OKx. The secret key used to sign your
	 * request data.
	 */
	private String secretKey;
	/**
	 * The Passphrase will be provided by you to further secure your Api access.
	 */
	private String passphrase;
	/**
	 * Rest api endpoint url.
	 */
	private String endpoint;

	/**
	 * Host connection timeout.
	 */
	private long connectTimeout;
	/**
	 * The host reads the information timeout.
	 */
	private long readTimeout;
	/**
	 * The host writes the information timeout.
	 */
	private long writeTimeout;
	/**
	 * Failure reconnection, default true.
	 */
	private boolean retryOnConnectionFailure;

	/**
	 * The print api information.
	 */
	private boolean print;

	/**
	 * internationalization {@link I18nEnum}
	 */
	private I18nEnum i18n;
	/**
	 * 模拟环境标识
	 */
	private int simulated;
	/**
	 * 代理服务器地址
	 */
	private String proxyServerAddress;
	/**
	 * 代理服务器端口
	 */
	private int proxyServerPort;

	public ApiConfiguration() {
		this(null);
	}

	public ApiConfiguration(String endpoint) {
		super();
		this.apiKey = null;
		this.secretKey = null;
		this.passphrase = null;
		this.endpoint = endpoint;
		this.connectTimeout = ApiConstants.TIMEOUT;
		this.readTimeout = ApiConstants.TIMEOUT;
		this.writeTimeout = ApiConstants.TIMEOUT;
		this.retryOnConnectionFailure = true;
		this.print = false;
		this.i18n = I18nEnum.ENGLISH;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public String getPassphrase() {
		return passphrase;
	}

	public void setPassphrase(String passphrase) {
		this.passphrase = passphrase;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public long getConnectTimeout() {
		return connectTimeout;
	}

	public void setConnectTimeout(long connectTimeout) {
		this.connectTimeout = connectTimeout;
	}

	public long getReadTimeout() {
		return readTimeout;
	}

	public void setReadTimeout(long readTimeout) {
		this.readTimeout = readTimeout;
	}

	public long getWriteTimeout() {
		return writeTimeout;
	}

	public void setWriteTimeout(long writeTimeout) {
		this.writeTimeout = writeTimeout;
	}

	public boolean isRetryOnConnectionFailure() {
		return retryOnConnectionFailure;
	}

	public void setRetryOnConnectionFailure(boolean retryOnConnectionFailure) {
		this.retryOnConnectionFailure = retryOnConnectionFailure;
	}

	public boolean isPrint() {
		return print;
	}

	public void setPrint(boolean print) {
		this.print = print;
	}

	public I18nEnum getI18n() {
		return i18n;
	}

	public void setI18n(I18nEnum i18n) {
		this.i18n = i18n;
	}

	public int getSimulated() {
		return simulated;
	}

	public void setSimulated(int simulated) {
		this.simulated = simulated;
	}

	public String getProxyServerAddress() {
		return proxyServerAddress;
	}

	public void setProxyServerAddress(String proxyServerAddress) {
		this.proxyServerAddress = proxyServerAddress;
	}

	public int getProxyServerPort() {
		return proxyServerPort;
	}

	public void setProxyServerPort(int proxyServerPort) {
		this.proxyServerPort = proxyServerPort;
	}

}
