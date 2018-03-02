package com.adaweng.shoppingcart.entity;

public class OrderRequest {
	Order order;
	Coupon coupon;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Coupon getCoupon() {
		return coupon;
	}

	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}	
	
}
