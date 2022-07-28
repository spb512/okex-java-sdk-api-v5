package com.okx.open.api.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.okx.open.api.constant.ApiConstants;
import com.okx.open.api.exception.ApiException;

/**
 * 
 * @author spb512
 * @date 2022年6月5日 下午5:02:59
 *
 */
public class JsonUtils {

	/**
	 * The java object is converted to a JSONObject，ensure precision (as strings).
	 * <br/>
	 *
	 * @param t   java object
	 * @param tC  generic class
	 * @param <T> generic flag
	 * @return If null, return {} ，Otherwise the normal
	 */
	public static <T> JSONObject convertObject(T t, Class<T> tC) {
		if (t == null) {
			return ApiConstants.NOTHING;
		}
		Field[] fields = tC.getDeclaredFields();
		JSONObject object = new JSONObject();
		try {
			for (Field field : fields) {
				String name = field.getName();
				String type = field.getType().toString();
				String methodName = getMethodName(type, name);
				Method[] methods = tC.getMethods();
				for (Method method : methods) {
					if (methodName.equals(method.getName())) {
						Object result = method.invoke(t);
						if (ApiConstants.TO_STRING_TYPE_ARRAY.contains(type)) {
							object.put(field.getName(), toString(result));
						} else if (ApiConstants.TO_STRING_TYPE_DOUBLE_ARRAY.contains(type) && result != null) {
							object.put(field.getName(), NumberUtils.doubleToString((Double) result));
						} else {
							object.put(field.getName(), result);
						}
					}
				}
			}
		} catch (Exception e) {
			throw new ApiException("Java biz bean change JSONObject is exception.", e);
		}
		return object;
	}

	/**
	 * The java object list is converted to a JSONArray，ensure precision (as
	 * strings)
	 *
	 * @param list java object list
	 * @param tC   generic class
	 * @param <T>  generic flag
	 * @return If null, return [] ，Otherwise the normal
	 */
	public static final <T> JSONArray convertList(List<T> list, Class<T> tC) {
		JSONArray array = new JSONArray();
		if (list == null || list.isEmpty()) {
			return array;
		}

		for (T t : list) {
			array.add(convertObject(t, tC));
		}
		return array;
	}

	public static final String getMethodName(String type, String field) {
		StringBuilder methodName = new StringBuilder();
		if (type.equals(ApiConstants.BOOLEAN)) {
			methodName.append(ApiConstants.IS);
		} else {
			methodName.append(ApiConstants.GET);
		}
		return methodName.append(startUpperCase(field)).toString();
	}

	public static final String startUpperCase(String name) {
		char[] cs = name.toCharArray();
		if (cs[0] >= ApiConstants.A && cs[0] <= ApiConstants.Z) {
			cs[0] -= 32;
		}
		return String.valueOf(cs);
	}

	public static final String toString(Object object) {
		return object == null ? ApiConstants.ZERO_STRING : object.toString();
	}

}
