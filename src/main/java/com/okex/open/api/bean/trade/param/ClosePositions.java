package com.okex.open.api.bean.trade.param;

/**
 * 
 * @author spb512
 * @date 2022年6月5日 下午5:02:59
 *
 */
public class ClosePositions {
	private String instId;
	private String posSide;
	private String mgnMode;
	private String ccy;

	public String getInstId() {
		return instId;
	}

	public void setInstId(String instId) {
		this.instId = instId;
	}

	public String getPosSide() {
		return posSide;
	}

	public void setPosSide(String posSide) {
		this.posSide = posSide;
	}

	public String getMgnMode() {
		return mgnMode;
	}

	public void setMgnMode(String mgnMode) {
		this.mgnMode = mgnMode;
	}

	public String getCcy() {
		return ccy;
	}

	public void setCcy(String ccy) {
		this.ccy = ccy;
	}

	@Override
	public String toString() {
		return "ClosePositions{" + "instId='" + instId + '\'' + ", posSide='" + posSide + '\'' + ", mgnMode='" + mgnMode
				+ '\'' + ", ccy='" + ccy + '\'' + '}';
	}
}
