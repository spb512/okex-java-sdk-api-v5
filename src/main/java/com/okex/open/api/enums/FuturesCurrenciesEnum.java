package com.okex.open.api.enums;

/**
 * 
 * @author spb512
 * @date 2022年6月5日 下午5:02:59
 *
 */
public enum FuturesCurrenciesEnum {
	/**
	 * BTC
	 */
	BTC(0),
	/**
	 * LTC
	 */
	LTC(1),
	/**
	 * ETH
	 */
	ETH(2),
	/**
	 * ETC
	 */
	ETC(4),
	/**
	 * XRP
	 */
	XRP(15),
	/**
	 * EOS
	 */
	EOS(20),
	/**
	 * BHC
	 */
	BCH(301),
	/**
	 * BSV
	 */
	BSV(302);

	private int symbol;

	FuturesCurrenciesEnum(int symbol) {
		this.symbol = symbol;
	}

	public int getSymbol() {
		return symbol;
	}
}
