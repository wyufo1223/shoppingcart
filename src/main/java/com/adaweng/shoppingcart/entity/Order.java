package com.adaweng.shoppingcart.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import com.adaweng.shoppingcart.domain.UserView;

public class Order {
	private Long id;
	private String orderCode;
	private Set<OrderItem> orderItems;	
	private Coupon coupon;	
	private Date paymentDate;	
	private BigDecimal totalPrice;
	private User user;
	
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
