package com.okx.open.api.bean.trade.param;

/**
 * 
 * @author spb512
 * @date 2022年6月5日 下午5:02:59
 *
 */
public class CancelAlgoOrder {

	private String algoId;
	private String instId;

	public String getAlgoId() {
		return algoId;
	}

	public void setAlgoId(String algoId) {
		this.algoId = algoId;
	}

	public String getInstId() {
		return instId;
	}

	public void setInstId(String instId) {
		this.instId = instId;
	}
}
