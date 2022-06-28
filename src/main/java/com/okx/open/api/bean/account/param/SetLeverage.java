package com.okx.open.api.bean.account.param;

/**
 * 
 * @author spb512
 * @date 2022年6月5日 下午4:42:31
 *
 */
public class SetLeverage {
	private String instId;
	private String ccy;
	private String lever;
	private String mgnMode;
	private String posSide;

	public String getInstId() {
		return instId;
	}

	public void setInstId(String instId) {
		this.instId = instId;
	}

	public String getCcy() {
		return ccy;
	}

	public void setCcy(String ccy) {
		this.ccy = ccy;
	}

	public String getLever() {
		return lever;
	}

	public void setLever(String lever) {
		this.lever = lever;
	}

	public String getMgnMode() {
		return mgnMode;
	}

	public void setMgnMode(String mgnMode) {
		this.mgnMode = mgnMode;
	}

	public String getPosSide() {
		return posSide;
	}

	public void setPosSide(String posSide) {
		this.posSide = posSide;
	}

	@Override
	public String toString() {
		return "SetLeverage{" + "instId='" + instId + '\'' + ", ccy='" + ccy + '\'' + ", lever='" + lever + '\''
				+ ", mgnMode='" + mgnMode + '\'' + ", posSide='" + posSide + '\'' + '}';
	}
}
