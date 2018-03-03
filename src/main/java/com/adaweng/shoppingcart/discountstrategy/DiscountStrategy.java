package com.adaweng.shoppingcart.discountstrategy;

import java.math.BigDecimal;

public interface DiscountStrategy {	
	public BigDecimal calculateSubtotalDiscount(BigDecimal price);
	public BigDecimal calculateSubtotalPrice(BigDecimal price); 
}
