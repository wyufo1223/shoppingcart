package com.adaweng.shoppingcart.domain;

import java.math.BigDecimal;
import java.util.List;

import com.adaweng.shoppingcart.domain.CouponView;
import com.adaweng.shoppingcart.domain.OrderItemView;
import com.adaweng.shoppingcart.domain.OrderView;

public class OrderResponse {
	BigDecimal totalPrice;
	BigDecimal totalDiscount;
	OrderView orderView;
	List<OrderItemView> orderItemsView;
	CouponView couponView;
	
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
	public OrderView getOrderView() {
		return orderView;
	}
	public void setOrderView(OrderView orderView) {
		this.orderView = orderView;
	}
	public List<OrderItemView> getOrderItemsView() {
		return orderItemsView;
	}
	public void setOrderItemsView(List<OrderItemView> orderItemsView) {
		this.orderItemsView = orderItemsView;
	}
	public CouponView getCouponView() {
		return couponView;
	}
	public void setCouponView(CouponView couponView) {
		this.couponView = couponView;
	}
		
}
