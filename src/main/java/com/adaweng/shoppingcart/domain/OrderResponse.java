package com.adaweng.shoppingcart.domain;

import java.math.BigDecimal;

public class OrderResponse {
	BigDecimal totalPrice;
	BigDecimal totalDiscount;
	
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	public BigDecimal getTotalDiscount() {
		return totalDiscount;
	}
	public void setTotalDiscount(BigDecimal totalDiscount) {
		this.totalDiscount = totalDiscount;
	}
	
}
