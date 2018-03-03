package com.adaweng.shoppingcart.domain;

import java.util.Date;

import com.adaweng.shoppingcart.entity.Discount;

public class DiscountView {	
	private Long id;
	private Date availableDate;	
	private String productType;
	
	public static DiscountView convertDiscountToDiscountView(Discount discount) {
		DiscountView dv = new DiscountView();
		dv.setAvailableDate(discount.getAvailableDate());
		dv.setProductType(discount.getProductType());
		return null;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getAvailableDate() {
		return availableDate;
	}
	public void setAvailableDate(Date availableDate) {
		this.availableDate = availableDate;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	
	
}
