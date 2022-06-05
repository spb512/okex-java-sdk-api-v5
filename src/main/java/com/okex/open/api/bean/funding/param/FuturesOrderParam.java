package com.okex.open.api.bean.funding.param;

/**
 * 
 * @author spb512
 * @date 2022年6月5日 下午4:43:49
 *
 */
public class FuturesOrderParam {
	/**
	 * 公共参数
	 */
	private String instrumentId;
	private String type;
	private String orderType;
	private String size;
	/**
	 * 计划委托
	 */
	private String triggerPrice;
	private String algoPrice;

	private String algoType;
	private String callbackRate;
	private String algoVariance;
	private String avgAmount;
	private String priceLimit;
	private String sweepRange;
	private String sweepRatio;
	private String singleLimit;
	private String timeInterval;
	/**
	 * 止盈止损
	 */
	private String tpTriggerPrice;
	private String tpPrice;
	private String tpTriggerType;
	private String slTriggerType;
	private String slTriggerPrice;
	private String slPrice;

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

	public String getInstrumentId() {
		return instrumentId;
	}

	public void setInstrumentId(String instrumentId) {
		this.instrumentId = instrumentId;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getTriggerPrice() {
		return triggerPrice;
	}

	public void setTriggerPrice(String triggerPrice) {
		this.triggerPrice = triggerPrice;
	}

	public String getAlgoPrice() {
		return algoPrice;
	}

	public void setAlgoPrice(String algoPrice) {
		this.algoPrice = algoPrice;
	}

	public String getAlgoType() {
		return algoType;
	}

	public void setAlgoType(String algoType) {
		this.algoType = algoType;
	}

	public String getCallbackRate() {
		return callbackRate;
	}

	public void setCallbackRate(String callbackRate) {
		this.callbackRate = callbackRate;
	}

	public String getAlgoVariance() {
		return algoVariance;
	}

	public void setAlgoVariance(String algoVariance) {
		this.algoVariance = algoVariance;
	}

	public String getAvgAmount() {
		return avgAmount;
	}

	public void setAvgAmount(String avgAmount) {
		this.avgAmount = avgAmount;
	}

	public String getPriceLimit() {
		return priceLimit;
	}

	public void setPriceLimit(String priceLimit) {
		this.priceLimit = priceLimit;
	}

	public String getSweepRange() {
		return sweepRange;
	}

	public void setSweepRange(String sweepRange) {
		this.sweepRange = sweepRange;
	}

	public String getSweepRatio() {
		return sweepRatio;
	}

	public void setSweepRatio(String sweepRatio) {
		this.sweepRatio = sweepRatio;
	}

	public String getSingleLimit() {
		return singleLimit;
	}

	public void setSingleLimit(String singleLimit) {
		this.singleLimit = singleLimit;
	}

	public String getTimeInterval() {
		return timeInterval;
	}

	public void setTimeInterval(String timeInterval) {
		this.timeInterval = timeInterval;
	}

	public String getTpTriggerPrice() {
		return tpTriggerPrice;
	}

	public void setTpTriggerPrice(String tpTriggerPrice) {
		this.tpTriggerPrice = tpTriggerPrice;
	}

	public String getTpPrice() {
		return tpPrice;
	}

	public void setTpPrice(String tpPrice) {
		this.tpPrice = tpPrice;
	}

	public String getTpTriggerType() {
		return tpTriggerType;
	}

	public void setTpTriggerType(String tpTriggerType) {
		this.tpTriggerType = tpTriggerType;
	}

	public String getSlTriggerType() {
		return slTriggerType;
	}

	public void setSlTriggerType(String slTriggerType) {
		this.slTriggerType = slTriggerType;
	}

	public String getSlTriggerPrice() {
		return slTriggerPrice;
	}

	public void setSlTriggerPrice(String slTriggerPrice) {
		this.slTriggerPrice = slTriggerPrice;
	}

	public String getSlPrice() {
		return slPrice;
	}

	public void setSlPrice(String slPrice) {
		this.slPrice = slPrice;
	}

}
