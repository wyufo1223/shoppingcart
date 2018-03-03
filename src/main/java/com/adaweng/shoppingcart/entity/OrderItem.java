package com.adaweng.shoppingcart.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Transient;

import com.adaweng.shoppingcart.discountstrategy.DiscountStrategy;
import com.adaweng.shoppingcart.discountstrategy.PercentageDiscountStrategy;
import com.adaweng.shoppingcart.domain.OrderItemView;

public class OrderItem {
	private Long id;
	private String name;
	private Long numbers;
	private String description;
	private BigDecimal subTotalPrice;
	private BigDecimal subTotalDiscount;
	private Product product;
	private Discount discount;	
	private User user;
	
	@Transient
	private Long prodId;
	@Transient
	private String prodName;
	@Transient
	private String prodType;
	@Transient
	private Double prodUnitPrice;
	
	@Transient
	private Long discId;
	@Transient
	private String discName;
	@Transient
	private Date discAvailableDate;
	@Transient
	private String discType;
	@Transient
	private Double discRate;
	
	@Transient
	private DiscountStrategy discountStrategy = new PercentageDiscountStrategy(
			OrderItemView.convertOrderItemToOrderItemView(this));
	
	public BigDecimal calculateSubtotalPrice() {
		BigDecimal totalPrice = BigDecimal.valueOf(0d);
		if(null == this.product) return totalPrice;		
		BigDecimal numsBD = BigDecimal.valueOf(this.getNumbers());
		BigDecimal unitPriceBD = BigDecimal.valueOf(this.getProduct().getUnitPrice());
		
		subTotalPrice = discountStrategy.calculateSubtotalPrice(
				OrderItemView.convertOrderItemToOrderItemView(this), numsBD.multiply(unitPriceBD));
		return subTotalPrice;
	}
	
	public BigDecimal calculateSubtotalDiscount() {
		BigDecimal totalPrice = BigDecimal.valueOf(0d);
		if(null == this.product) return totalPrice;		
		BigDecimal numsBD = BigDecimal.valueOf(this.getNumbers());
		BigDecimal unitPriceBD = BigDecimal.valueOf(this.getProduct().getUnitPrice());
		
		subTotalDiscount = discountStrategy.calculateSubtotalDiscount(
				OrderItemView.convertOrderItemToOrderItemView(this), numsBD.multiply(unitPriceBD));
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

	public Double getProdUnitPrice() {
		return prodUnitPrice;
	}

	public void setProdUnitPrice(Double prodUnitPrice) {
		this.prodUnitPrice = prodUnitPrice;
	}

	public Long getProdId() {
		return prodId;
	}

	public void setProdId(Long prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdType() {
		return prodType;
	}

	public void setProdType(String prodType) {
		this.prodType = prodType;
	}

	public Long getDiscId() {
		return discId;
	}

	public void setDiscId(Long discId) {
		this.discId = discId;
	}

	public String getDiscName() {
		return discName;
	}

	public void setDiscName(String discName) {
		this.discName = discName;
	}

	public Date getDiscAvailableDate() {
		return discAvailableDate;
	}

	public void setDiscAvailableDate(Date discAvailableDate) {
		this.discAvailableDate = discAvailableDate;
	}

	public String getDiscType() {
		return discType;
	}

	public void setDiscType(String discType) {
		this.discType = discType;
	}

	public Double getDiscRate() {
		return discRate;
	}

	public void setDiscRate(Double discRate) {
		this.discRate = discRate;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
