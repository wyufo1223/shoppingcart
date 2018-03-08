package com.adaweng.shoppingcart.discountstrategy;

import java.math.BigDecimal;

import com.adaweng.shoppingcart.domain.OrderItemView;

public class PercentageDiscountStrategy implements DiscountStrategy {
	private BigDecimal rate;
	
	public PercentageDiscountStrategy(OrderItemView orderItemView){
		this.rate = orderItemView.getDiscRate();
	}
	
	@Override
	public BigDecimal calculateSubtotalDiscount(OrderItemView orderItemView, BigDecimal price) {
		// TODO totalPrice - (totalPrice * rate)	
		if(null == orderItemView.getDiscRate()){
			return BigDecimal.valueOf(0);
		}
		BigDecimal rateBD = orderItemView.getDiscRate();	
		return price.subtract(price.multiply(rateBD)).setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	@Override
	public BigDecimal calculateSubtotalPrice(OrderItemView orderItemView, BigDecimal price) {
		// TODO totalPrice * rate
		if(null == orderItemView.getDiscRate()){
			return price;
		}
		
		BigDecimal rateBD = orderItemView.getDiscRate();
		return price.multiply(rateBD).setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	
	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
	
}
