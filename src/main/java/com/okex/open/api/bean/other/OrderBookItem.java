package com.okex.open.api.bean.other;

/**
 * 
 * @author spb512
 * @date 2022年6月5日 下午4:45:24
 * 
 * @param <T>
 */
public interface OrderBookItem<T> {
	/**
	 * 获取价格
	 * 
	 * @return
	 */
	String getPrice();

	/**
	 * 获取数量
	 * 
	 * @return
	 */
	T getSize();
}
