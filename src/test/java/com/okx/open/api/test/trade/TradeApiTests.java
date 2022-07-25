package com.okx.open.api.test.trade;

import com.alibaba.fastjson.JSONObject;
import com.okx.open.api.bean.trade.param.*;
import com.okx.open.api.service.trade.TradeApiService;
import com.okx.open.api.service.trade.impl.TradeApiServiceImpl;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author spb512
 * @date 2022年6月5日 下午5:02:59
 *
 */
public class TradeApiTests extends TradeApiBaseTest {
	Logger logger = LoggerFactory.getLogger(getClass());
	private TradeApiService tradeApiService;

	@Before
	public void before() {
		config = config();
		tradeApiService = new TradeApiServiceImpl(config);
	}

	/**
	 * 下单 Place Order POST /api/v5/trade/order
	 */
	@Test
	public void placeOrder() {

		PlaceOrder placeOrder = new PlaceOrder();
		placeOrder.setInstId("LTC-USDT-SWAP");
		placeOrder.setTdMode("cross");
//        placeOrder.setCcy("USDT");
		placeOrder.setClOrdId("0423a3a06");
//        placeOrder.setTag("");
		placeOrder.setSide("sell");
		placeOrder.setPosSide("short");
		placeOrder.setOrdType("market");
		placeOrder.setSz("1");
//        placeOrder.setPx("60000");
//        placeOrder.setReduceOnly(false);
		JSONObject result = tradeApiService.placeOrder(placeOrder);

		toResultString(logger, "result", result);
	}

	/**
	 * 批量下单 Place Multiple Orders POST /api/v5/trade/batch-orders
	 */
	@Test
	public void placeMultipleOrders() {

		List<PlaceOrder> placeOrders = new ArrayList<>();

		PlaceOrder placeOrder1 = new PlaceOrder();
		placeOrder1.setInstId("TRX-USDT");
		placeOrder1.setTdMode("isolated");
		placeOrder1.setClOrdId("123testspot07");
		placeOrder1.setTag("");
		placeOrder1.setSide("sell");
		placeOrder1.setPosSide("");
		placeOrder1.setOrdType("limit");
		placeOrder1.setSz("10");
		placeOrder1.setPx("0.09");
		placeOrder1.setReduceOnly(null);

		PlaceOrder placeOrder2 = new PlaceOrder();
		placeOrder2.setInstId("BTC-USDT-210625");
		placeOrder2.setTdMode("cross");
		placeOrder2.setClOrdId("testfutures07");
		placeOrder2.setTag("");
		placeOrder2.setSide("buy");
		placeOrder2.setPosSide("long");
		placeOrder2.setOrdType("limit");
		placeOrder2.setSz("2");
		placeOrder2.setPx("24633");
		placeOrder2.setReduceOnly(null);

		placeOrders.add(placeOrder1);
		placeOrders.add(placeOrder2);

		JSONObject result = tradeApiService.placeMultipleOrders(placeOrders);

		toResultString(logger, "result", result);
	}

	/**
	 * 撤单 Cancel Order POST /api/v5/trade/cancel-order
	 */
	@Test
	public void cancelOrder() {
		CancelOrder cancelOrder = new CancelOrder();
		cancelOrder.setInstId("BTC-USDT-210625");
		cancelOrder.setOrdId("261896498091274242");
		cancelOrder.setClOrdId("");
		JSONObject result = tradeApiService.cancelOrder(cancelOrder);

		toResultString(logger, "result", result);
	}

	/**
	 * 批量撤单 Cancel Multiple Orders POST /api/v5/trade/cancel-batch-orders
	 */
	@Test
	public void cancelMultipleOrders() {
		List<CancelOrder> cancelOrders = new ArrayList<>();

		CancelOrder cancelOrder1 = new CancelOrder();
		cancelOrder1.setInstId("TRX-USDT");
		cancelOrder1.setClOrdId("");
		cancelOrder1.setOrdId("261904614430224384");

		CancelOrder cancelOrder2 = new CancelOrder();
		cancelOrder2.setInstId("BTC-USDT-210625");
		cancelOrder2.setClOrdId("");
		cancelOrder2.setOrdId("261904614430224386");

		cancelOrders.add(cancelOrder1);
		cancelOrders.add(cancelOrder2);

		JSONObject result = tradeApiService.cancelMultipleOrders(cancelOrders);

		toResultString(logger, "result", result);
	}

	/**
	 * 修改订单 Amend Order POST /api/v5/trade/amend-order
	 */
	@Test
	public void amendOrder() {

		AmendOrder amendOrder = new AmendOrder();
		amendOrder.setInstId("BTC-USD-210326");
		amendOrder.setCxlOnFail(true);
		amendOrder.setOrdId("294884456087826432");
//        amendOrder.setClOrdId("");
		amendOrder.setReqId("");
		amendOrder.setNewSz("12.5");
		amendOrder.setNewPx("52000");

		JSONObject result = tradeApiService.amendOrder(amendOrder);

		toResultString(logger, "result", result);
	}

	/**
	 * 批量修改订单 Amend Multiple Orders POST /api/v5/trade/amend-batch-orders
	 */
	@Test
	public void amendMultipleOrders() {

		List<AmendOrder> amendOrders = new ArrayList<>();

		AmendOrder amendOrder1 = new AmendOrder();
		amendOrder1.setInstId("TRX-USDT");
		amendOrder1.setCxlOnFail(false);
		amendOrder1.setOrdId("261905735181807620");
		amendOrder1.setClOrdId("");
		amendOrder1.setReqId("");
		amendOrder1.setNewSz("15");
		amendOrder1.setNewPx("0.0272");

		AmendOrder amendOrder2 = new AmendOrder();
		amendOrder2.setInstId("BTC-USDT-210625");
		amendOrder2.setCxlOnFail(false);
		amendOrder2.setOrdId("261905735181807623");
		amendOrder2.setClOrdId("");
		amendOrder2.setReqId("");
		amendOrder2.setNewSz("20");
		amendOrder2.setNewPx("");

		amendOrders.add(amendOrder1);
		amendOrders.add(amendOrder2);

		JSONObject result = tradeApiService.amendMultipleOrders(amendOrders);

		toResultString(logger, "result", result);
	}

	/**
	 * 市价仓位全平 Close Positions POST /api/v5/trade/close-position
	 */
	@Test
	public void closePositions() {

		ClosePositions closePositions = new ClosePositions();
		closePositions.setInstId("BTC-USD-SWAP");
		closePositions.setPosSide("long");
		closePositions.setMgnMode("cross");
		closePositions.setCcy("");
		JSONObject result = tradeApiService.closePositions(closePositions);

		toResultString(logger, "result", result);

	}

	/**
	 * 获取订单信息 Get Order Details GET /api/v5/trade/order
	 */
	@Test
	public void getOrderDetails() {
		JSONObject result = tradeApiService.getOrderDetails("EOS-USDT", null, "0420aaa");
		toResultString(logger, "result", result);
	}

	/**
	 * 获取未成交订单列表 Get Order List GET /api/v5/trade/orders-pending
	 */
	@Test
	public void getOrderList() {
		JSONObject result = tradeApiService.getOrderList("FUTURES", "", "EOS-USDT-210924", "", "", "", "", "");
		toResultString(logger, "result", result);
	}

	/**
	 * 获取历史订单记录（近七天） Get Order History (last 7 days） GET
	 * /api/v5/trade/orders-history
	 */
	@Test
	public void getOrderHistory7days() {
		JSONObject result = tradeApiService.getOrderHistory7days("FUTURES", "", "", "", "", "", "", "");
		toResultString(logger, "result", result);
	}

	/**
	 * 获取历史订单记录（近三个月） Get Order History (last 3 months) GET
	 * /api/v5/trade/orders-history-archive
	 */
	@Test
	public void getOrderHistory3months() {
		JSONObject result = tradeApiService.getOrderHistory3months("SWAP", "", "BTC-USDT-SWAP", "", "", "", "", "");
		toResultString(logger, "result", result);
	}

	/**
	 * 获取成交明细 Get Transaction Details GET /api/v5/trade/fills
	 */
	@Test
	public void getTransactionDetails() {

		JSONObject result = tradeApiService.getTransactionDetails(null, null, null, null, null, null, null);
		toResultString(logger, "result", result);

	}

	/**
	 * 委托策略下单 Place Algo Order POST /api/v5/trade/order-algo
	 */
	@Test
	public void placeAlgoOrder() {
		PlaceAlgoOrder placeAlgoOrder = new PlaceAlgoOrder();
		placeAlgoOrder.setInstId("ALGO-USDT-SWAP");
		placeAlgoOrder.setTdMode("isolated");
//        placeAlgoOrder.setCcy("");
		placeAlgoOrder.setSide("buy");
		placeAlgoOrder.setPosSide("long");
		placeAlgoOrder.setOrdType("trigger");
		placeAlgoOrder.setSz("1");
		placeAlgoOrder.setReduceOnly(false);

//        止盈止损 Stop Order
//        placeAlgoOrder.setTpTriggerPx("45000");
//        placeAlgoOrder.setTpOrdPx("44000");
//        placeAlgoOrder.setSlTriggerPx("60000");
//        placeAlgoOrder.setSlOrdPx("65000");

//        计划委托 Trigger Order
		placeAlgoOrder.setTriggerPx("1.1");
		placeAlgoOrder.setOrderPx("0.7");

		JSONObject result = tradeApiService.placeAlgoOrder(placeAlgoOrder);
		toResultString(logger, "result", result);

	}

	/**
	 * 撤销策略委托订单 Cancel Algo Order POST /api/v5/trade/cancel-algos
	 */
	@Test
	public void cancelAlgoOrder() {

		List<CancelAlgoOrder> list = new ArrayList<CancelAlgoOrder>();
		CancelAlgoOrder cancelAlgoOrder = new CancelAlgoOrder();

		cancelAlgoOrder.setAlgoId("300338778946826240");
		cancelAlgoOrder.setInstId("BTC-USDT");
		list.add(cancelAlgoOrder);

		JSONObject result = tradeApiService.cancelAlgoOrder(list);
		toResultString(logger, "result", result);
	}

	/**
	 * 获取未完成策略委托单列表 Get Algo Order List GET /api/v5/trade/orders-algo-pending
	 */
	@Test
	public void getAlgoOrderList() {
		JSONObject result = tradeApiService.getAlgoOrderList("300592229014450176", null, null, "trigger", null, null,
				"10");
		toResultString(logger, "result", result);
	}

	/**
	 * 获取历史策略委托单列表 Get Algo Order History GET /api/v5/trade/orders-algo-history
	 */
	@Test
	public void getAlgoOrderHistory() {
		JSONObject result = tradeApiService.getAlgoOrderHistory("effective", null, null, null, "trigger", null, null,
				"10");
		toResultString(logger, "result", result);
	}

}
