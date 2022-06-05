package com.okex.open.api.bean.account.param;

/**
 * 
 * @author spb512
 * @date 2022年6月5日 下午4:42:52
 *
 */
public class SetTheDisplayTypeOfGreeks {
	private String greeksType;

	public String getGreeksType() {
		return greeksType;
	}

	public void setGreeksType(String greeksType) {
		this.greeksType = greeksType;
	}

	@Override
	public String toString() {
		return "SetTheDisplayTypeOfGreeks{" + "greeksType='" + greeksType + '\'' + '}';
	}
}
