package com.okex.open.api.bean.funding.param;

import com.okex.open.api.enums.FuturesTransactionTypeEnum;

/**
 * 
 * @author spb512
 * @date 2022年6月5日 下午4:44:01
 *
 */
public class OrdersItem {

	/**
	 * You setting orderId. (optional)
	 */
	private String orderType;
	private String price;

	private String clientOid;
	/**
	 * The execution type {@link FuturesTransactionTypeEnum}
	 */
	private String type;
	/**
	 * The order price: Maximum 1 million
	 */
	private String size;
	/**
	 * Match best counter party price (BBO)? 0: No 1: Yes If yes, the 'price' field
	 * is ignored
	 */
	private String matchPrice;

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getClientOid() {
		return clientOid;
	}

	public void setClientOid(String clientOid) {
		this.clientOid = clientOid;
	}

	public String getMatchPrice() {
		return matchPrice;
	}

	public void setMatchPrice(String matchPrice) {
		this.matchPrice = matchPrice;
	}

}
