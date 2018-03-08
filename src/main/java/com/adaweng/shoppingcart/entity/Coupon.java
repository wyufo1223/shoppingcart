package com.adaweng.shoppingcart.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Transient;


public class Coupon {
	private Long id;
	private String name;	
	private String code;
	private Date startDate;
	private Date endDate;
	private BigDecimal priceReached;
	private BigDecimal priceReduced;	
	private User user;
	@Transient
	private String userId;
	
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
	public BigDecimal getPriceReached() {
		return priceReached;
	}
	public void setPriceReached(BigDecimal priceReached) {
		this.priceReached = priceReached;
	}
	public BigDecimal getPriceReduced() {
		return priceReduced;
	}
	public void setPriceReduced(BigDecimal priceReduced) {
		this.priceReduced = priceReduced;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}	
		
}
