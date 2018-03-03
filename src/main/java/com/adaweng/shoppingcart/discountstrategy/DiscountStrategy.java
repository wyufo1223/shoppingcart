package com.adaweng.shoppingcart.discountstrategy;

import java.math.BigDecimal;

import com.adaweng.shoppingcart.domain.OrderItemView;

public interface DiscountStrategy {	
	public BigDecimal calculateSubtotalDiscount(OrderItemView orderItemView,BigDecimal price);
	public BigDecimal calculateSubtotalPrice(OrderItemView orderItemView, BigDecimal price); 
}
