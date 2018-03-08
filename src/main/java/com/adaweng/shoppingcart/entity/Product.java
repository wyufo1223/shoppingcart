package com.adaweng.shoppingcart.entity;

import java.math.BigDecimal;

public class Product {
	private Long id;
	private String name;
	private String type;
	private BigDecimal unitPrice;
	private String description;
	private Long stockAmount;
	private String status;
	
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Long getStockAmount() {
		return stockAmount;
	}
	public void setStockAmount(Long stockAmount) {
		this.stockAmount = stockAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
