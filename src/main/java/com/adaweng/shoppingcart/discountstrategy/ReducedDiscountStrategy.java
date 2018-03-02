package com.adaweng.shoppingcart.discountstrategy;

import java.math.BigDecimal;

public class ReducedDiscountStrategy implements DiscountStrategy {
	private Double priceReduced;
	
	@Override
	public BigDecimal calculateSubtotalDiscount(BigDecimal price) {
		// TODO
		return BigDecimal.valueOf(this.getPriceReduced());
	}

	@Override
	public BigDecimal calculateSubtotalPrice(BigDecimal price) {
		// TODO totalPrice - priceReduced
		BigDecimal priceReducedBD = BigDecimal.valueOf(this.getPriceReduced());
		return price.subtract(priceReducedBD);
	}

	public Double getPriceReduced() {
		return priceReduced;
	}

	public void setPriceReduced(Double priceReduced) {
		this.priceReduced = priceReduced;
	}	
	
}
