package com.okx.open.api.service.trade.impl;

import java.util.List;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.okx.open.api.bean.trade.param.AmendOrder;
import com.okx.open.api.bean.trade.param.CancelAlgoOrder;
import com.okx.open.api.bean.trade.param.CancelOrder;
import com.okx.open.api.bean.trade.param.ClosePositions;
import com.okx.open.api.bean.trade.param.PlaceAlgoOrder;
import com.okx.open.api.bean.trade.param.PlaceOrder;
import com.okx.open.api.client.ApiClient;
import com.okx.open.api.config.ApiConfiguration;
import com.okx.open.api.service.trade.TradeApiService;

/**
 * 
 * @author spb512
 * @date 2022年6月5日 下午5:02:59
 *
 */
public class TradeApiServiceImpl implements TradeApiService {
	private final ApiClient client;
	private final TradeApi tradeApi;

	public TradeApiServiceImpl(final ApiConfiguration config) {
		this.client = new ApiClient(config);
		this.tradeApi = this.client.createService(TradeApi.class);
	}

	/**
	 * 下单 Place Order
	 */
	@Override
	public JSONObject placeOrder(PlaceOrder placeOrder) {
		return this.client.executeSync(this.tradeApi.placeOrder(JSONObject.parseObject(JSON.toJSONString(placeOrder))));
	}

	/**
	 * 批量下单 Place Multiple Orders
	 */
	@Override
	public JSONObject placeMultipleOrders(List<PlaceOrder> placeOrders) {
		return this.client.executeSync(this.tradeApi.placeMultipleOrders(placeOrders));
	}

	/**
	 * 撤单 Cancel Order
	 */
	@Override
	public JSONObject cancelOrder(CancelOrder cancelOrder) {
		return this.client.executeSync(this.tradeApi.cancelOrder(cancelOrder));
	}

	/**
	 * 批量撤单 Cancel Multiple Orders
	 */
	@Override
	public JSONObject cancelMultipleOrders(List<CancelOrder> cancelOrders) {
		return this.client.executeSync(this.tradeApi.cancelMultipleOrders(cancelOrders));
	}

	/**
	 * 修改订单 Amend Order
	 */
	@Override
	public JSONObject amendOrder(AmendOrder amendOrder) {
		return this.client.executeSync(this.tradeApi.amendOrder(amendOrder));
	}

	/**
	 * 批量修改订单 Amend Multiple Orders
	 */
	@Override
	public JSONObject amendMultipleOrders(List<AmendOrder> amendOrders) {
		return this.client.executeSync(this.tradeApi.amendMultipleOrders(amendOrders));
	}

	/**
	 * 市价仓位全平 Close Positions
	 */
	@Override
	public JSONObject closePositions(ClosePositions closePositions) {
		return this.client.executeSync(this.tradeApi.closePositions(closePositions));
	}

	/**
	 * 获取订单信息 Get Order Details
	 */
	@Override
	public JSONObject getOrderDetails(String instId, String ordId, String clOrdId) {
		return this.client.executeSync(this.tradeApi.getOrderDetails(instId, ordId, clOrdId));
	}

	/**
	 * 获取未成交订单列表 Get Order List
	 */
	@Override
	public JSONObject getOrderList(String instType, String uly, String instId, String ordType, String state,
			String after, String before, String limit) {
		return this.client
				.executeSync(this.tradeApi.getOrderList(instType, uly, instId, ordType, state, after, before, limit));
	}

	/**
	 * 获取历史订单记录（近七天） Get Order History (last 7 days）
	 */
	@Override
	public JSONObject getOrderHistory7days(String instType, String uly, String instId, String ordType, String state,
			String after, String before, String limit) {
		return this.client.executeSync(
				this.tradeApi.getOrderHistory7days(instType, uly, instId, ordType, state, after, before, limit));
	}

	/**
	 * 获取历史订单记录（近三个月） Get Order History (last 3 months)
	 */
	@Override
	public JSONObject getOrderHistory3months(String instType, String uly, String instId, String ordType, String state,
			String after, String before, String limit) {
		return this.client.executeSync(
				this.tradeApi.getOrderHistory3months(instType, uly, instId, ordType, state, after, before, limit));
	}

	/**
	 * 获取成交明细 Get Transaction Details
	 */
	@Override
	public JSONObject getTransactionDetails(String instType, String uly, String instId, String ordId, String after,
			String before, String limit) {
		return this.client
				.executeSync(this.tradeApi.getTransactionDetails(instType, uly, instId, ordId, after, before, limit));
	}

	/**
	 * 委托策略下单 Place Algo Order
	 */
	@Override
	public JSONObject placeAlgoOrder(PlaceAlgoOrder placeAlgoOrder) {
		return this.client
				.executeSync(this.tradeApi.placeAlgoOrder(JSONObject.parseObject(JSON.toJSONString(placeAlgoOrder))));
	}

	/**
	 * 撤销策略委托订单 Cancel Algo Order
	 */
	@Override
	public JSONObject cancelAlgoOrder(List<CancelAlgoOrder> cancelAlgoOrder) {
		return this.client.executeSync(this.tradeApi.cancelAlgoOrders(cancelAlgoOrder));
	}

	/**
	 * 获取未完成策略委托单列表 Get Algo Order List
	 */
	@Override
	public JSONObject getAlgoOrderList(String algoId, String instType, String instId, String ordType, String after,
			String before, String limit) {
		return this.client
				.executeSync(this.tradeApi.getAlgoOrderList(algoId, instType, instId, ordType, after, before, limit));
	}

	/**
	 * 获取历史策略委托单列表 Get Algo Order History
	 */
	@Override
	public JSONObject getAlgoOrderHistory(String state, String algoId, String instType, String instId, String ordType,
			String after, String before, String limit) {
		return this.client.executeSync(
				this.tradeApi.getAlgoOrderHistory(state, algoId, instType, instId, ordType, after, before, limit));
	}
}
