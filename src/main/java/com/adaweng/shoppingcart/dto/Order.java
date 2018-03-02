package com.adaweng.shoppingcart.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

public class Order {
	private Set<OrderItem> orderItems;	
	private Coupon coupon;	
	private Date paymentDate;	
	private BigDecimal totalPrice;
	
	public void addOrderItem(OrderItem orderItem){
		orderItems.add(orderItem);
	}
	
	public void deleteOrderItem(OrderItem orderItem){
		orderItems.remove(orderItem);
	}

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public Coupon getCoupon() {
		return coupon;
	}

	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
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
