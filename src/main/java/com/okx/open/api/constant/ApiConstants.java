package com.okx.open.api.constant;

import com.alibaba.fastjson.JSONObject;
import com.okx.open.api.enums.CharsetEnum;
import com.okx.open.api.enums.ContentTypeEnum;

import okhttp3.MediaType;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author spb512
 * @date 2022年6月5日 下午5:02:59
 *
 */
public class ApiConstants {

	/**
	 * The default timeout is 30 seconds.
	 */
	public static final long TIMEOUT = 1000 * 30;
	/**
	 * All requests and responses are application/json content type and follow
	 * typical HTTP response status codes for success and failure.
	 */
	public static final String CONTENT_TYPE = "Content-Type";

	public static final String ACCEPT = "Accept";

	public static final String COOKIE = "Cookie";

	public static final String LOCALE = "locale=";

	public static final MediaType JSON = MediaType.parse(ContentTypeEnum.APPLICATION_JSON.contentType());

	public static final Charset UTF_8 = Charset.forName(CharsetEnum.UTF_8.charset());

	public static final String QUESTION = "?";

	public static final String EMPTY = "";

	public static final JSONObject NOTHING = new JSONObject();

	public static final List<String> TO_STRING_TYPE_ARRAY = Arrays.asList("class java.lang.Long",
			"class java.lang.Integer", "long", "int");
	public static final List<String> TO_STRING_TYPE_DOUBLE_ARRAY = Arrays.asList("class java.lang.Double", "double");

	public static final List<Integer> RESULT_STATUS_ARRAY = Arrays.asList(400, 401, 429, 500);

	public static final String BOOLEAN = "boolean";
	public static final String IS = "is";
	public static final String GET = "get";
	public static final char A = 'a';
	public static final char Z = 'z';
	public static final String ZERO_STRING = "0";
	public static final String DOUBLE_ZERO_STRING = "0.00";

	public static final String DOT1 = ".";
	public static final String DOT2 = "\\.";
	public static final String CAP_E = "E";
	public static final String LOW_E = "e";
	public static final int DEFAULT_SCALE = 2;
	/**
	 * 8900000000.000000000
	 */
	public static final String DOUBLE_END1 = "0+?$";
	/**
	 * 8900000000.
	 */
	public static final String DOUBLE_END2 = "[.]$";

	/**
	 * default cursor id
	 */
	public static final int ONE = 1;
	/**
	 * max limit: 100
	 */
	public static final int HUNDRED = 100;

	public static final String HLINE = "-";

	public static final String SLASH = "/";
}
