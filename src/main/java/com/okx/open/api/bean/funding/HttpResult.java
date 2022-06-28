package com.okx.open.api.bean.funding;

/**
 * 
 * @author spb512
 * @date 2022年6月5日 下午4:44:49
 *
 */
public class HttpResult {

	private int code;
	private String message;
	private String msg;
	private int errorCode;
	private String errorMessage;
	private String orderId;
	private Boolean result;

	public int getErrorCode() {
		return errorCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Boolean getResult() {
		return result;
	}

	public void setResult(Boolean result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "HttpResult{" + "code=" + code + ", message='" + message + '\'' + ", msg='" + msg + '\'' + ", errorCode="
				+ errorCode + ", errorMessage='" + errorMessage + '\'' + ", orderId='" + orderId + '\'' + ", result="
				+ result + '}';
	}
}