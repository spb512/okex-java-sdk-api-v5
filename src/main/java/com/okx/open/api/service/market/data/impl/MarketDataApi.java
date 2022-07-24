package com.okx.open.api.service.market.data.impl;

import com.alibaba.fastjson.JSONObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 
 * @author spb512
 * @date 2022年7月24日
 */
public interface MarketDataApi {

	/**
	 * 获取所有产品行情信息 Get Tickers
	 * 
	 * @param instType
	 * @param uly
	 * @return
	 */
	@GET("/api/v5/market/tickers")
	Call<JSONObject> getTickers(@Query("instType") String instType, @Query("uly") String uly);

	/**
	 * 获取单个产品行情信息 Get Ticker
	 * 
	 * @param instId
	 * @return
	 */
	@GET("/api/v5/market/ticker")
	Call<JSONObject> getTicker(@Query("instId") String instId);

	/**
	 * 获取指数行情数据 Get Index Tickers
	 * 
	 * @param quoteCcy
	 * @param instId
	 * @return
	 */
	@GET("/api/v5/market/index-tickers")
	Call<JSONObject> getIndexTickers(@Query("quoteCcy") String quoteCcy, @Query("instId") String instId);

	/**
	 * 获取产品深度 Get Order Book
	 * 
	 * @param instId
	 * @param sz
	 * @return
	 */
	@GET("/api/v5/market/books")
	Call<JSONObject> getOrderBook(@Query("instId") String instId, @Query("sz") String sz);

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
	@GET("/api/v5/market/candles")
	Call<JSONObject> getCandlesticks(@Query("instId") String instId, @Query("after") String after,
			@Query("before") String before, @Query("bar") String bar, @Query("limit") String limit);

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
	@GET("/api/v5/market/history-candles")
	Call<JSONObject> getCandlesticksHistory(@Query("instId") String instId, @Query("after") String after,
			@Query("before") String before, @Query("bar") String bar, @Query("limit") String limit);

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
	@GET("/api/v5/market/index-candles")
	Call<JSONObject> getIndexCandlesticks(@Query("instId") String instId, @Query("after") String after,
			@Query("before") String before, @Query("bar") String bar, @Query("limit") String limit);

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
	@GET("/api/v5/market/mark-price-candles")
	Call<JSONObject> getMarkPriceCandlesticks(@Query("instId") String instId, @Query("after") String after,
			@Query("before") String before, @Query("bar") String bar, @Query("limit") String limit);

	/**
	 * 获取交易产品公共成交数据 Get Trades
	 * 
	 * @param instId
	 * @param limit
	 * @return
	 */
	@GET("/api/v5/market/trades")
	Call<JSONObject> getTrades(@Query("instId") String instId, @Query("limit") String limit);

	/**
	 * 获取平台24小时总成交量 Get total volume
	 * 
	 * @return
	 */
	@GET("/api/v5/market/platform-24-volume")
	Call<JSONObject> getTotalVolume();

}
