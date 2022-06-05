package com.okex.open.api.exception;

/**
 * 
 * @author spb512
 * @date 2022年6月5日 下午5:02:59
 *
 */
public class ApiException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private int code;

	public ApiException(String message) {
		super(message);
	}

	public ApiException(int code, String message) {
		super(message);
		this.code = code;
	}

	public ApiException(Throwable cause) {
		super(cause);
	}

	public ApiException(String message, Throwable cause) {
		super(message, cause);
	}

	@Override
	public String getMessage() {
		if (this.code != 0) {
			return this.code + " : " + super.getMessage();
		}
		return super.getMessage();
	}
}
