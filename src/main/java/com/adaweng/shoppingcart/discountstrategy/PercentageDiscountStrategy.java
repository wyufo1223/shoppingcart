package com.adaweng.shoppingcart.discountstrategy;

import java.math.BigDecimal;

public class PercentageDiscountStrategy implements DiscountStrategy {
	private Double rate;
	
	@Override
	public BigDecimal calculateSubtotalDiscount(BigDecimal price) {
		// TODO totalPrice - (totalPrice * rate)	
		BigDecimal rateBD = BigDecimal.valueOf(this.getRate());	
		return price.subtract(price.multiply(rateBD));
	}

	@Override
	public BigDecimal calculateSubtotalPrice(BigDecimal price) {
		// TODO totalPrice * rate
		BigDecimal rateBD = BigDecimal.valueOf(this.getRate());
		return price.multiply(rateBD);
	}
	
	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}
	
}
