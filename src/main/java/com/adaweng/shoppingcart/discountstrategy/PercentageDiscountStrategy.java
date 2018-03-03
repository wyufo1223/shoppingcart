package com.adaweng.shoppingcart.discountstrategy;

import java.math.BigDecimal;

import com.adaweng.shoppingcart.domain.OrderItemView;

public class PercentageDiscountStrategy implements DiscountStrategy {
	private Double rate;
	public PercentageDiscountStrategy(OrderItemView orderItemView){
		this.rate = orderItemView.getDiscRate();
	}
	
	@Override
	public BigDecimal calculateSubtotalDiscount(OrderItemView orderItemView, BigDecimal price) {
		// TODO totalPrice - (totalPrice * rate)	
		if(null == orderItemView.getDiscRate()){
			return BigDecimal.valueOf(0);
		}
		BigDecimal rateBD = BigDecimal.valueOf(orderItemView.getDiscRate());	
		return price.subtract(price.multiply(rateBD));
	}

	@Override
	public BigDecimal calculateSubtotalPrice(OrderItemView orderItemView, BigDecimal price) {
		// TODO totalPrice * rate
		if(null == orderItemView.getDiscRate()){
			return price;
		}
		
		BigDecimal rateBD = BigDecimal.valueOf(orderItemView.getDiscRate());
		return price.multiply(rateBD);
	}
	
	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}
	
}
