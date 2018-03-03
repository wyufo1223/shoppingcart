package com.adaweng.shoppingcart.domain;

import com.adaweng.shoppingcart.domain.CouponView;
import com.adaweng.shoppingcart.domain.OrderView;

public class OrderRequest {
	OrderView orderView;
	CouponView couponView;

	public OrderView getOrder() {
		return orderView;
	}

	public void setOrder(OrderView order) {
		this.orderView = order;
	}

	public CouponView getCoupon() {
		return couponView;
	}

	public void setCoupon(CouponView coupon) {
		this.couponView = coupon;
	}	
	
}
