package com.okx.open.api.service.trade;

import java.util.List;

import com.alibaba.fastjson2.JSONObject;
import com.okx.open.api.bean.trade.param.AmendOrder;
import com.okx.open.api.bean.trade.param.CancelAlgoOrder;
import com.okx.open.api.bean.trade.param.CancelOrder;
import com.okx.open.api.bean.trade.param.ClosePositions;
import com.okx.open.api.bean.trade.param.PlaceAlgoOrder;
import com.okx.open.api.bean.trade.param.PlaceOrder;

/**
 * 
 * @author spb512
 * @date 2022年6月5日 下午5:02:59
 *
 */
public interface TradeApiService {

	/**
	 * 下单 Place Order
	 * 
	 * @param placeOrder
	 * @return
	 */
	JSONObject placeOrder(PlaceOrder placeOrder);

	/**
	 * 批量下单 Place Multiple Orders
	 * 
	 * @param placeOrders
	 * @return
	 */
	JSONObject placeMultipleOrders(List<PlaceOrder> placeOrders);

	/**
	 * 撤单 Cancel Order
	 * 
	 * @param cancelOrder
	 * @return
	 */
	JSONObject cancelOrder(CancelOrder cancelOrder);

	/**
	 * 批量撤单 Cancel Multiple Orders
	 * 
	 * @param cancelOrders
	 * @return
	 */
	JSONObject cancelMultipleOrders(List<CancelOrder> cancelOrders);

	/**
	 * 修改订单 Amend Order
	 * 
	 * @param amendOrder
	 * @return
	 */
	JSONObject amendOrder(AmendOrder amendOrder);

	/**
	 * 批量修改订单 Amend Multiple Orders
	 * 
	 * @param amendOrders
	 * @return
	 */
	JSONObject amendMultipleOrders(List<AmendOrder> amendOrders);

	/**
	 * 市价仓位全平 Close Positions
	 * 
	 * @param closePositions
	 * @return
	 */
	JSONObject closePositions(ClosePositions closePositions);

	/**
	 * 获取订单信息 Get Order Details
	 * 
	 * @param instId
	 * @param ordId
	 * @param clOrdId
	 * @return
	 */
	JSONObject getOrderDetails(String instId, String ordId, String clOrdId);

	/**
	 * 获取未成交订单列表 Get Order List
	 * 
	 * @param instType
	 * @param uly
	 * @param instId
	 * @param ordType
	 * @param state
	 * @param after
	 * @param before
	 * @param limit
	 * @return
	 */
	JSONObject getOrderList(String instType, String uly, String instId, String ordType, String state, String after,
			String before, String limit);

	/**
	 * 获取历史订单记录（近七天） Get Order History (last 7 days）
	 * 
	 * @param instType
	 * @param uly
	 * @param instId
	 * @param ordType
	 * @param state
	 * @param after
	 * @param before
	 * @param limit
	 * @return
	 */
	JSONObject getOrderHistory7days(String instType, String uly, String instId, String ordType, String state,
			String after, String before, String limit);

	/**
	 * 获取历史订单记录（近三个月） Get Order History (last 3 months)
	 * 
	 * @param instType
	 * @param uly
	 * @param instId
	 * @param ordType
	 * @param state
	 * @param after
	 * @param before
	 * @param limit
	 * @return
	 */
	JSONObject getOrderHistory3months(String instType, String uly, String instId, String ordType, String state,
			String after, String before, String limit);

	/**
	 * 获取成交明细 Get Transaction Details
	 * 
	 * @param instType
	 * @param uly
	 * @param instId
	 * @param ordId
	 * @param after
	 * @param before
	 * @param limit
	 * @return
	 */
	JSONObject getTransactionDetails(String instType, String uly, String instId, String ordId, String after,
			String before, String limit);

	/**
	 * 委托策略下单 Place Algo Order
	 * 
	 * @param placeAlgoOrder
	 * @return
	 */
	JSONObject placeAlgoOrder(PlaceAlgoOrder placeAlgoOrder);

	/**
	 * 撤销策略委托订单 Cancel Algo Order
	 * 
	 * @param cancelAlgoOrder
	 * @return
	 */
	JSONObject cancelAlgoOrder(List<CancelAlgoOrder> cancelAlgoOrder);

	/**
	 * 获取未完成策略委托单列表 Get Algo Order List
	 * 
	 * @param algoId
	 * @param instType
	 * @param instId
	 * @param ordType
	 * @param after
	 * @param before
	 * @param limit
	 * @return
	 */
	JSONObject getAlgoOrderList(String algoId, String instType, String instId, String ordType, String after,
			String before, String limit);

	/**
	 * 获取历史策略委托单列表 Get Algo Order History
	 * 
	 * @param state
	 * @param algoId
	 * @param instType
	 * @param instId
	 * @param ordType
	 * @param after
	 * @param before
	 * @param limit
	 * @return
	 */
	JSONObject getAlgoOrderHistory(String state, String algoId, String instType, String instId, String ordType,
			String after, String before, String limit);

}
