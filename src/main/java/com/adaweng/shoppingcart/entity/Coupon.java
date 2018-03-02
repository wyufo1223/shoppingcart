package com.adaweng.shoppingcart.entity;

import java.util.Date;

public class Coupon {
	private Long id;
	private String name;
	private String code;
	private Date startDate;
	private Date endDate;
	private Double priceReached;
	private Double priceReduced;	
	private User user;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Double getPriceReached() {
		return priceReached;
	}
	public void setPriceReached(Double priceReached) {
		this.priceReached = priceReached;
	}
	public Double getPriceReduced() {
		return priceReduced;
	}
	public void setPriceReduced(Double priceReduced) {
		this.priceReduced = priceReduced;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}	
	
}
