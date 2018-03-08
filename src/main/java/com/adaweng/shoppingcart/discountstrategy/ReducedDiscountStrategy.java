package com.adaweng.shoppingcart.discountstrategy;

import java.math.BigDecimal;

import com.adaweng.shoppingcart.domain.OrderItemView;

public class ReducedDiscountStrategy implements DiscountStrategy {
	private BigDecimal priceReduced;
	
	@Override
	public BigDecimal calculateSubtotalDiscount(OrderItemView orderItemView, BigDecimal price) {
		// TODO
		return this.getPriceReduced().setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	@Override
	public BigDecimal calculateSubtotalPrice(OrderItemView orderItemView, BigDecimal price) {
		// TODO totalPrice - priceReduced
		BigDecimal priceReducedBD = this.getPriceReduced();
		return price.subtract(priceReducedBD).setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	public BigDecimal getPriceReduced() {
		return priceReduced;
	}

	public void setPriceReduced(BigDecimal priceReduced) {
		this.priceReduced = priceReduced;
	}	
	
}
