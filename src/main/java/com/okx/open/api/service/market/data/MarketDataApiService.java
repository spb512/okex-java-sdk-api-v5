package com.okx.open.api.service.market.data;

import com.alibaba.fastjson2.JSONObject;

/**
 * 
 * @author spb512
 * @date 2022年6月5日 下午5:02:59
 *
 */
public interface MarketDataApiService {

	/**
	 * 获取所有产品行情信息 Get Tickers
	 * 
	 * @param instType
	 * @param uly
	 * @return
	 */
	JSONObject getTickers(String instType, String uly);

	/**
	 * 获取单个产品行情信息 Get Ticker
	 * 
	 * @param instId
	 * @return
	 */
	JSONObject getTicker(String instId);

	/**
	 * 获取指数行情数据 Get Index Tickers
	 * 
	 * @param quoteCcy
	 * @param instId
	 * @return
	 */
	JSONObject getIndexTickers(String quoteCcy, String instId);

	/**
	 * 获取产品深度 Get Order Book
	 * 
	 * @param instId
	 * @param sz
	 * @return
	 */
	JSONObject getOrderBook(String instId, String sz);

	/**
	 * 获取所有交易产品K线数据 Get Candlesticks
	 * 
	 * @param instId
	 * @param after
	 * @param before
	 * @param bar
	 * @param limit
	 * @return
	 */
	JSONObject getCandlesticks(String instId, String after, String before, String bar, String limit);

	/**
	 * 获取交易产品历史K线数据（仅主流币） Get Candlesticks History（top currencies only）
	 * 
	 * @param instId
	 * @param after
	 * @param before
	 * @param bar
	 * @param limit
	 * @return
	 */
	JSONObject getCandlesticksHistory(String instId, String after, String before, String bar, String limit);

	/**
	 * 获取指数K线数据 Get Index Candlesticks
	 * 
	 * @param instId
	 * @param after
	 * @param before
	 * @param bar
	 * @param limit
	 * @return
	 */
	JSONObject getIndexCandlesticks(String instId, String after, String before, String bar, String limit);

	/**
	 * 获取标记价格K线数据 Get Mark Price Candlesticks
	 * 
	 * @param instId
	 * @param after
	 * @param before
	 * @param bar
	 * @param limit
	 * @return
	 */
	JSONObject getMarkPriceCandlesticks(String instId, String after, String before, String bar, String limit);

	/**
	 * 获取交易产品公共成交数据 Get Trades
	 * 
	 * @param instId
	 * @param limit
	 * @return
	 */
	JSONObject getTrades(String instId, String limit);

	/**
	 * 获取平台24小时总成交量 Get total volume
	 * 
	 * @return
	 */
	JSONObject getTotalVolume();

}
