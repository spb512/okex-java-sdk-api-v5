package com.okex.open.api.test.market.data;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.okex.open.api.service.market.data.MarketDataApiService;
import com.okex.open.api.service.market.data.impl.MarketDataApiServiceImpl;

/**
 * 
 * @author spb512
 * @date 2022年6月5日 下午5:02:59
 *
 */
public class MarketDataApiTest extends MarketDataApiBaseTest {

	private static final Logger LOG = LoggerFactory.getLogger(MarketDataApiTest.class);
	public MarketDataApiService marketDataApiService;

	@Before
	public void before() {
		config = config();
		marketDataApiService = new MarketDataApiServiceImpl(config);
	}

	/**
	 * 获取所有产品行情信息 Get Tickers GET /api/v5/market/tickers
	 */
	@Test
	public void getTickers() {
		JSONObject result = this.marketDataApiService.getTickers("FUTURES", "BTC-USDT");
		this.toResultString(MarketDataApiTest.LOG, "result", result);
	}

	/**
	 * 获取单个产品行情信息 Get Ticker GET /api/v5/market/ticker
	 */
	@Test
	public void getTicker() {
		JSONObject result = this.marketDataApiService.getTicker("BTC-USDT-SWAP");
		this.toResultString(MarketDataApiTest.LOG, "result", result);
	}

	/**
	 * 获取指数行情 Get Index Tickers GET /api/v5/market/index-tickers
	 */
	@Test
	public void getIndexTickers() {
		JSONObject result = this.marketDataApiService.getIndexTickers("USDT", "XRP-USDT");
		this.toResultString(MarketDataApiTest.LOG, "result", result);
	}

	/**
	 * 获取产品深度 Get Order Book GET /api/v5/market/books
	 */
	@Test
	public void getOrderBook() {
		JSONObject result = this.marketDataApiService.getOrderBook("BTC-USD-SWAP", "400");
		this.toResultString(MarketDataApiTest.LOG, "result", result);
	}

	/**
	 * 获取所有交易产品K线数据 Get Candlesticks GET /api/v5/market/candles
	 */
	@Test
	public void getCandlesticks() {

		JSONObject result = this.marketDataApiService.getCandlesticks("BTC-USD-SWAP", "1618468839819", null, "2H",
				"20");
		this.toResultString(MarketDataApiTest.LOG, "result", result);
	}

	/**
	 * 获取交易产品历史K线数据（仅主流币） Get Candlesticks History（top currencies only） GET
	 * /api/v5/market/history-candles
	 */
	@Test
	public void getCandlesticksHistory() {
		JSONObject result = this.marketDataApiService.getCandlesticksHistory("BTC-USDT-210625", null, null, "1m", "12");
		this.toResultString(MarketDataApiTest.LOG, "result", result);
	}

	/**
	 * 获取指数K线数据 Get Index Candlesticks GET /api/v5/market/index-candles
	 */
	@Test
	public void getIndexCandlesticks() {
		JSONObject result = this.marketDataApiService.getIndexCandlesticks("BTC-USDT", "", "", "1H", "5");
		this.toResultString(MarketDataApiTest.LOG, "result", result);
	}

	/**
	 * 获取标记价格K线数据 Get Mark Price Candlesticks /api/v5/market/mark-price-candles
	 */
	@Test
	public void getMarkPriceCandlesticks() {
		JSONObject result = this.marketDataApiService.getMarkPriceCandlesticks("EOS-USDT", null, null, "15m", "81");
		this.toResultString(MarketDataApiTest.LOG, "result", result);
	}

	/**
	 * 获取交易产品公共成交数据 Get Trades GET /api/v5/market/trades
	 */
	@Test
	public void getTrades() {
		JSONObject result = this.marketDataApiService.getTrades("BTC-USDT-SWAP", "");
		this.toResultString(MarketDataApiTest.LOG, "result", result);
	}

	/**
	 * 获取平台24小时总成交量 Get total volume GET /api/v5/market/platform-24-volume
	 */
	@Test
	public void getTotalVolume() {
		JSONObject result = this.marketDataApiService.getTotalVolume();
		this.toResultString(MarketDataApiTest.LOG, "result", result);
	}

}
