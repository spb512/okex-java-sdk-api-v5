package com.okex.open.api.bean.account.param;

/**
 * 
 * @author spb512
 * @date 2022年6月5日 下午4:42:05
 *
 */
public class SetPositionMode {

	@Override
	public String toString() {
		return "SetPositionMode{" + "posMode='" + posMode + '\'' + '}';
	}

	public String getPosMode() {
		return posMode;
	}

	public void setPosMode(String posMode) {
		this.posMode = posMode;
	}

	private String posMode;

}
