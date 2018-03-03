package com.adaweng.shoppingcart.domain;

import java.math.BigDecimal;
import java.sql.Date;

import com.adaweng.shoppingcart.discountstrategy.DiscountStrategy;
import com.adaweng.shoppingcart.discountstrategy.PercentageDiscountStrategy;
import com.adaweng.shoppingcart.entity.OrderItem;


public class OrderItemView {
	private Long id;
	private String name;	
	private Long numbers;	
	private BigDecimal subTotalPrice;
	private BigDecimal subTotalDiscount;
	
	private DiscountStrategy discountStrategy = new PercentageDiscountStrategy();
	
	private ProductView product;
	private Long prodId;
	private String prodName;
	private Double prodUnitPrice;
	private String prodType;
	
	private DiscountView discount;
	private Long discId;
	private Date discAvailableDate;
	private Double discRate;
	private Double discPriceReduced;
	
	
	public BigDecimal calculateSubtotalPrice() {
		BigDecimal totalPrice = BigDecimal.valueOf(0d);
		if(null == this.getProduct()) return totalPrice;		
		BigDecimal numsBD = BigDecimal.valueOf(this.getNumbers());
		BigDecimal unitPriceBD = BigDecimal.valueOf(this.getProduct().getUnitPrice());
		
		subTotalPrice = discountStrategy.calculateSubtotalPrice(numsBD.multiply(unitPriceBD));
		this.setSubTotalPrice(subTotalPrice);
		return subTotalPrice;
	}
	
	public BigDecimal calculateSubtotalDiscount() {
		BigDecimal totalPrice = BigDecimal.valueOf(0d);
		if(null == this.getProduct()) return totalPrice;		
		BigDecimal numsBD = BigDecimal.valueOf(this.getNumbers());
		BigDecimal unitPriceBD = BigDecimal.valueOf(this.getProduct().getUnitPrice());
		
		subTotalDiscount = discountStrategy.calculateSubtotalDiscount(numsBD.multiply(unitPriceBD));
		this.setSubTotalDiscount(subTotalDiscount);
		return subTotalDiscount;
	}
	
	public static OrderItemView convertOrderItemToOrderItemView(OrderItem oi){
		OrderItemView oiv = new OrderItemView();
		
		oiv.setId(oi.getId());	
		oiv.setName(oi.getName());		
		oiv.setNumbers(oi.getNumbers());		
		oiv.setSubTotalPrice(oi.getSubTotalPrice());
		oiv.setSubTotalDiscount(oi.getSubTotalDiscount());
		//oiv.setProduct(ProductView.convertProductToProductView(oi.getProduct()));
		//oiv.setDiscount(DiscountView.convertDiscountToDiscountView(oi.getDiscount()));
		oiv.setProdId(oi.getProdId());
		oiv.setDiscRate(oi.getDiscRate());
		//oiv.setSubTotalDiscount(calculateSubtotalDiscount());
		return oiv;
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
//		this.subTotalPrice = calculateSubtotalPrice();
	}

	public BigDecimal getSubTotalDiscount() {
		return subTotalDiscount;
	}

	public void setSubTotalDiscount(BigDecimal subTotalDiscount) {
		this.subTotalDiscount = subTotalDiscount;
//		this.subTotalDiscount = calculateSubtotalDiscount();
	}

	public DiscountStrategy getDiscountStrategy() {
		return discountStrategy;
	}

	public void setDiscountStrategy(DiscountStrategy discountStrategy) {
		this.discountStrategy = discountStrategy;
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

	public Date getDiscAvailableDate() {
		return discAvailableDate;
	}

	public void setDiscAvailableDate(Date discAvailableDate) {
		this.discAvailableDate = discAvailableDate;
	}

	public ProductView getProduct() {
		return product;
	}

	public void setProduct(ProductView product) {
		this.product = product;
	}

	public DiscountView getDiscount() {
		return discount;
	}

	public void setDiscount(DiscountView discount) {
		this.discount = discount;
	}

	public Double getDiscRate() {
		return discRate;
	}

	public void setDiscRate(Double discRate) {
		this.discRate = discRate;
	}

	public Double getDiscPriceReduced() {
		return discPriceReduced;
	}

	public void setDiscPriceReduced(Double discPriceReduced) {
		this.discPriceReduced = discPriceReduced;
	}	
		
}
