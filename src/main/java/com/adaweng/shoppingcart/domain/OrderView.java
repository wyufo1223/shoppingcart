package com.adaweng.shoppingcart.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

public class OrderView {
	private Set<OrderItemView> orderItems;	
	private CouponView couponView;	
	private Date paymentDate;	
	private BigDecimal totalPrice;
	
	public void addOrderItem(OrderItemView orderItem){
		orderItems.add(orderItem);
	}
	
	public void deleteOrderItem(OrderItemView orderItem){
		orderItems.remove(orderItem);
	}

	public Set<OrderItemView> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItemView> orderItems) {
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
	
}
