package com.okx.open.api.enums;

/**
 * 
 * @author spb512
 * @date 2022年6月5日 下午5:02:59
 *
 */
public enum HttpStatusEnum {

	/**
	 * 200
	 */
	OK(200, "OK", "The request is Successful."),
	/**
	 * 400
	 */
	BAD_REQUEST(400, "Bad Request", "Invalid request format."),
	/**
	 * 401
	 */
	UNAUTHORIZED(401, "Unauthorized", "Invalid authorization."),
	/**
	 * 403
	 */
	FORBIDDEN(403, "Forbidden", "You do not have access to the requested resource."),
	/**
	 * 404
	 */
	NOT_FOUND(404, "Not Found", "Request resource path error."),
	/**
	 * 429
	 */
	TOO_MANY_REQUESTS(429, "Too Many Requests", "When a rate limit is exceeded."),
	/**
	 * 500
	 */
	INTERNAL_SERVER_ERROR(500, "Internal Server Error", "We had a problem with our server."),;

	private int status;
	private String message;
	private String comment;

	HttpStatusEnum(int status, String message, String comment) {
		this.status = status;
		this.message = message;
		this.comment = comment;
	}

	public int status() {
		return status;
	}

	public String message() {
		return message;
	}

	public String comment() {
		return comment;
	}
}
