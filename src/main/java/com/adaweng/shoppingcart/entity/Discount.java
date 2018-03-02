package com.adaweng.shoppingcart.entity;

import java.util.Date;

public class Discount {	
	private Long id;
	private String name;
	private Date availableDate;	
	private String productType;
	private String discountType;
	private Double rate;
	private Double priceReduced;
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDiscountType() {
		return discountType;
	}
	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}
	public Double getRate() {
		return rate;
	}
	public void setRate(Double rate) {
		this.rate = rate;
	}
	public Double getPriceReduced() {
		return priceReduced;
	}
	public void setPriceReduced(Double priceReduced) {
		this.priceReduced = priceReduced;
	}
	
}
