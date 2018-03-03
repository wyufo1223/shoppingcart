package com.adaweng.shoppingcart.entity;

import java.math.BigDecimal;

import javax.persistence.Transient;

import com.adaweng.shoppingcart.discountstrategy.DiscountStrategy;
import com.adaweng.shoppingcart.discountstrategy.PercentageDiscountStrategy;

public class OrderItem {
	private Long id;
	private String name;
	private Long numbers;
	private String description;
	private BigDecimal subTotalPrice;
	private BigDecimal subTotalDiscount;
	private Product product;
	private Discount discount;
	
	@Transient
	private DiscountStrategy discountStrategy = new PercentageDiscountStrategy();
	
	public BigDecimal calculateSubtotalPrice() {
		BigDecimal totalPrice = BigDecimal.valueOf(0d);
		if(null == this.product) return totalPrice;		
		BigDecimal numsBD = BigDecimal.valueOf(this.getNumbers());
		BigDecimal unitPriceBD = BigDecimal.valueOf(this.getProduct().getUnitPrice());
		
		subTotalPrice = discountStrategy.calculateSubtotalPrice(numsBD.multiply(unitPriceBD));
		return subTotalPrice;
	}
	
	public BigDecimal calculateSubtotalDiscount() {
		BigDecimal totalPrice = BigDecimal.valueOf(0d);
		if(null == this.product) return totalPrice;		
		BigDecimal numsBD = BigDecimal.valueOf(this.getNumbers());
		BigDecimal unitPriceBD = BigDecimal.valueOf(this.getProduct().getUnitPrice());
		
		subTotalDiscount = discountStrategy.calculateSubtotalDiscount(numsBD.multiply(unitPriceBD));
		return subTotalDiscount;
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Long getNumbers() {
		return numbers;
	}

	public void setNumbers(Long numbers) {
		this.numbers = numbers;
	}

	public BigDecimal getSubTotalPrice() {
		return subTotalPrice;
	}

	public void setSubTotalPrice(BigDecimal subTotalPrice) {
		this.subTotalPrice = subTotalPrice;
	}

	public BigDecimal getSubTotalDiscount() {
		return subTotalDiscount;
	}

	public void setSubTotalDiscount(BigDecimal subTotalDiscount) {
		this.subTotalDiscount = subTotalDiscount;
	}

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	public DiscountStrategy getDiscountStrategy() {
		return discountStrategy;
	}

	public void setDiscountStrategy(DiscountStrategy discountStrategy) {
		this.discountStrategy = discountStrategy;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
