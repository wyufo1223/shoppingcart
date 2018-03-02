package com.adaweng.shoppingcart.discountstrategy;

import java.math.BigDecimal;

import com.adaweng.shoppingcart.dto.OrderItem;

public interface DiscountStrategy {	
	public BigDecimal calculateSubtotalDiscount(BigDecimal price);
	public BigDecimal calculateSubtotalPrice(BigDecimal price); 
}
