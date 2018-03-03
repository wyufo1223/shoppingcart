package com.adaweng.shoppingcart.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrderView {
	private List<OrderItemView> orderItems;	
	private CouponView couponView;	
	private Date paymentDate;	
	private BigDecimal totalPrice;
	private UserView userView;
	
	public void addOrderItem(OrderItemView orderItem){
		orderItems.add(orderItem);
	}
	
	public void deleteOrderItem(OrderItemView orderItem){
		orderItems.remove(orderItem);
	}

	public List<OrderItemView> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItemView> orderItems) {
		this.orderItems = orderItems;
	}

	public CouponView getCoupon() {
		return couponView;
	}

	public void setCoupon(CouponView coupon) {
		this.couponView = coupon;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public CouponView getCouponView() {
		return couponView;
	}

	public void setCouponView(CouponView couponView) {
		this.couponView = couponView;
	}

	public UserView getUserView() {
		return userView;
	}

	public void setUserView(UserView userView) {
		this.userView = userView;
	}
		
}
