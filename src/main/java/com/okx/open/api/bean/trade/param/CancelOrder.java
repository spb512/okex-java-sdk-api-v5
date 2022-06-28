package com.okx.open.api.bean.trade.param;

/**
 * 
 * @author spb512
 * @date 2022年6月5日 下午5:02:59
 *
 */
public class CancelOrder {
	private String instId;
	private String ordId;
	private String clOrdId;

	public String getInstId() {
		return instId;
	}

	public void setInstId(String instId) {
		this.instId = instId;
	}

	public String getOrdId() {
		return ordId;
	}

	public void setOrdId(String ordId) {
		this.ordId = ordId;
	}

	public String getClOrdId() {
		return clOrdId;
	}

	public void setClOrdId(String clOrdId) {
		this.clOrdId = clOrdId;
	}

	@Override
	public String toString() {
		return "CancelOrder{" + "instId='" + instId + '\'' + ", ordId='" + ordId + '\'' + ", clOrdId='" + clOrdId + '\''
				+ '}';
	}
}
