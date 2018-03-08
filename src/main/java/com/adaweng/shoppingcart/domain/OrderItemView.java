package com.adaweng.shoppingcart.domain;

import java.math.BigDecimal;
import java.sql.Date;

import com.adaweng.shoppingcart.discountstrategy.DiscountStrategy;
import com.adaweng.shoppingcart.discountstrategy.PercentageDiscountStrategy;
import com.adaweng.shoppingcart.entity.OrderItem;


public class OrderItemView {
	private Long id;
	private String name;	
	private Long quantity;	
	private BigDecimal subTotalPrice;
	private BigDecimal subTotalDiscount;
	
	private DiscountStrategy discountStrategy = new PercentageDiscountStrategy(this);
	
	private ProductView product;
	private Long prodId;
	private String prodName;
	private BigDecimal prodUnitPrice;
	private String prodType;
	
	private DiscountView discount;
	private Long discId;
	private Date discAvailableDate;
	private BigDecimal discRate;
	private BigDecimal discPriceReduced;
	
	private UserView userView;
	
	private Double prodStockAmount;
	private String prodStatus;

	public static OrderItemView convertOrderItemToOrderItemView(OrderItem oi){
		OrderItemView oiv = new OrderItemView();
		
		oiv.setId(oi.getId());	
		oiv.setName(oi.getName());		
		oiv.setQuantity(oi.getQuantity());		
		oiv.setSubTotalPrice(oi.getSubTotalPrice());
		oiv.setSubTotalDiscount(oi.getSubTotalDiscount());
		//oiv.setProduct(ProductView.convertProductToProductView(oi.getProduct()));
		//oiv.setDiscount(DiscountView.convertDiscountToDiscountView(oi.getDiscount()));
		oiv.setProdId(oi.getProdId());
		oiv.setDiscRate(oi.getDiscRate());
		oiv.setProdStatus(oi.getProdStatus());
		oiv.setProdStockAmount(oi.getProdStockAmount());
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

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
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

	public BigDecimal getProdUnitPrice() {
		return prodUnitPrice;
	}

	public void setProdUnitPrice(BigDecimal prodUnitPrice) {
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

	public BigDecimal getDiscRate() {
		return discRate;
	}

	public void setDiscRate(BigDecimal discRate) {
		this.discRate = discRate;
	}

	public BigDecimal getDiscPriceReduced() {
		return discPriceReduced;
	}

	public void setDiscPriceReduced(BigDecimal discPriceReduced) {
		this.discPriceReduced = discPriceReduced;
	}

	public UserView getUserView() {
		return userView;
	}

	public void setUserView(UserView userView) {
		this.userView = userView;
	}

	public Double getProdStockAmount() {
		return prodStockAmount;
	}

	public void setProdStockAmount(Double prodStockAmount) {
		this.prodStockAmount = prodStockAmount;
	}

	public String getProdStatus() {
		return prodStatus;
	}

	public void setProdStatus(String prodStatus) {
		this.prodStatus = prodStatus;
	}		
	
}
