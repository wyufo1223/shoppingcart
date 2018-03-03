package com.adaweng.shoppingcart.domain;

import java.util.Date;

import com.adaweng.shoppingcart.entity.Coupon;

public class CouponView {
	private Long id;
	private String name;
	private String code;
	private Date startDate;
	private Date endDate;
	private Double priceReached;
	private Double priceReduced;	
	private UserView user;
	private String userId;
	
	public static CouponView convertCouponToCouponView(Coupon coupon){
		CouponView couponView = new CouponView();
		
		couponView.setId(coupon.getId());	
		couponView.setName(coupon.getName());		
		couponView.setUserId(coupon.getUserId());
		couponView.setEndDate(coupon.getEndDate());
		couponView.setPriceReached(coupon.getPriceReached());
		couponView.setPriceReduced(coupon.getPriceReduced());
		
		return couponView;
	}

	
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
	public UserView getUser() {
		return user;
	}
	public void setUser(UserView user) {
		this.user = user;
	}
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}	
	
	
}
