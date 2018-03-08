package com.adaweng.shoppingcart.processor;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.adaweng.shoppingcart.domain.CouponView;
import com.adaweng.shoppingcart.domain.DiscountView;
import com.adaweng.shoppingcart.domain.OrderItemView;
import com.adaweng.shoppingcart.domain.OrderView;
import com.adaweng.shoppingcart.domain.ProductType;
import com.adaweng.shoppingcart.service.common.OrderRequest;

public class PriceProcessorTest {

	private OrderRequest request;	
	private PriceProcessor priceProcessor;
	private BigDecimal totalPrice;
	private CouponView couponView;
	private OrderView orderView;
	
	private List<DiscountView> discountViews;	
	private DiscountView discountView;
	private Date paymentDate;
	private List<OrderItemView> orderItemViews;	
	private OrderItemView orderItemView;	
	
	@Before
	public void setUp() throws Exception {
		priceProcessor = new PriceProcessor();
		request = new OrderRequest();
		orderView = new OrderView();
		couponView = new CouponView();
		
		orderView.setTotalPrice(BigDecimal.valueOf(200));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		orderView.setPaymentDate(sdf.parse("2013.11.11"));
		
		couponView.setEndDate(sdf.parse("2014.11.11"));
		couponView.setPriceReached(1000d);
		couponView.setPriceReduced(200d);
		
		request.setCoupon(couponView);
		request.setOrder(orderView);
	}
	
	public void initcaseForCoupon1() throws ParseException {
		orderView.setTotalPrice(BigDecimal.valueOf(1000d));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		orderView.setPaymentDate(sdf.parse("2013.11.11"));
		
		couponView.setEndDate(sdf.parse("2014.11.11"));
		couponView.setPriceReached(1000d);
		couponView.setPriceReduced(200d);
	}
	
	public void initcaseCoupon2() throws ParseException {
		orderView.setTotalPrice(BigDecimal.valueOf(43.54d));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		orderView.setPaymentDate(sdf.parse("2013.11.11"));
		
		couponView.setEndDate(sdf.parse("2014.11.11"));
		couponView.setPriceReached(1000d);
		couponView.setPriceReduced(200d);
	}
	
	public void initcaseCoupon3() throws ParseException {
		orderView.setTotalPrice(BigDecimal.valueOf(1434d));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		orderView.setPaymentDate(sdf.parse("2013.11.11"));
		
		couponView.setEndDate(sdf.parse("2014.11.11"));
		couponView.setPriceReached(1000d);
		couponView.setPriceReduced(200d);
	}
	
	public void initcaseDiscount1() throws ParseException {
		orderView.setTotalPrice(BigDecimal.valueOf(1434d));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		orderView.setPaymentDate(sdf.parse("2013.11.11"));
		
		couponView.setEndDate(sdf.parse("2014.11.11"));
		couponView.setPriceReached(1000d);
		couponView.setPriceReduced(200d);
		
		discountView = new DiscountView();
		discountViews = new ArrayList<DiscountView>();
		
		orderItemViews = new ArrayList<OrderItemView>();
		couponView = new CouponView();
		totalPrice = BigDecimal.valueOf(0d);
				
		discountView.setAvailableDate(sdf.parse("2013.11.11"));
		discountView.setProductType(ProductType.ELECTRONIC.name());		
		discountViews.add(discountView);		
		
		orderItemView = new OrderItemView();
		orderItemView.setProdId(1l);
		orderItemView.setQuantity(1l);
		orderItemView.setName("ipad");
		orderItemView.setDiscRate(0.7d);
		orderItemView.setProdUnitPrice(2399.00);
		orderItemView.setProdType(ProductType.ELECTRONIC.name());
		orderItemViews.add(orderItemView);
		
		orderItemView = new OrderItemView();
		orderItemView.setProdId(2l);
		orderItemView.setQuantity(1l);
		orderItemView.setName("显示器");
		orderItemView.setDiscRate(0.7d);
		orderItemView.setProdUnitPrice(1799.00);
		orderItemView.setProdType(ProductType.ELECTRONIC.name());
		orderItemViews.add(orderItemView);
		
		orderItemView = new OrderItemView();
		orderItemView.setProdId(3l);
		orderItemView.setQuantity(12l);
		orderItemView.setName("啤酒");
		orderItemView.setProdUnitPrice(25.00);
		orderItemView.setProdType(ProductType.LIQUOR.name());
		orderItemViews.add(orderItemView);
		
		orderItemView = new OrderItemView();
		orderItemView.setProdId(4l);
		orderItemView.setQuantity(5l);
		orderItemView.setName("面包");
		orderItemView.setProdUnitPrice(9.00);
		orderItemView.setProdType(ProductType.FOOD.name());
		orderItemViews.add(orderItemView);
		
		paymentDate = sdf.parse("2013.11.11");
		
		couponView = new CouponView();
		couponView.setEndDate(sdf.parse("2014.3.2"));
		couponView.setPriceReached(1000d);
		couponView.setPriceReduced(200d);
		
		orderView.setOrderItems(orderItemViews);
	}
	
	public void initcaseDiscount2() throws ParseException {
		orderItemViews = new ArrayList<OrderItemView>();
		orderView.setTotalPrice(BigDecimal.valueOf(1434d));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		orderView.setPaymentDate(sdf.parse("2013.11.11"));
		
		couponView.setEndDate(sdf.parse("2014.11.11"));
		couponView.setPriceReached(1000d);
		couponView.setPriceReduced(200d);
		
		orderItemView = new OrderItemView();
		orderItemView.setProdId(1l);
		orderItemView.setQuantity(3l);
		orderItemView.setName("蔬菜");
		orderItemView.setProdUnitPrice(5.98);
		orderItemView.setProdType(ProductType.FOOD.name());
		orderItemViews.add(orderItemView);
		
		orderItemView = new OrderItemView();
		orderItemView.setProdId(2l);
		orderItemView.setQuantity(8l);
		orderItemView.setName("餐巾");
		orderItemView.setProdUnitPrice(3.20);
		orderItemView.setProdType(ProductType.NECESSITIES.name());
		orderItemViews.add(orderItemView);
		
		discountViews = null;
		paymentDate = sdf.parse("2014.01.01");
		
		orderView.setOrderItems(orderItemViews);
	}
	
	public void initcaseDiscount3() throws ParseException {
		orderView.setOrderItems(null);
	}
	

	@Test
	public void testCalculateSubtotalPrice() {
		
	}
	
	@Test
	public void testCalculateTotalPriceWithDiscounts() throws ParseException {
		initcaseDiscount1();
		totalPrice = priceProcessor.calculateTotalPriceWithDiscounts(request);
		assertEquals(BigDecimal.valueOf(3283.6).setScale(2, BigDecimal.ROUND_HALF_UP), totalPrice);
		
		initcaseDiscount2();
		totalPrice = priceProcessor.calculateTotalPriceWithDiscounts(request);
		assertEquals(BigDecimal.valueOf(43.54).setScale(2, BigDecimal.ROUND_HALF_UP), 
				totalPrice.setScale(2, BigDecimal.ROUND_HALF_UP));	
		
		initcaseDiscount3();
		totalPrice = priceProcessor.calculateTotalPriceWithDiscounts(request);
		assertEquals(BigDecimal.valueOf(0).setScale(2, BigDecimal.ROUND_HALF_UP), 
				totalPrice.setScale(2, BigDecimal.ROUND_HALF_UP));	
	}
	
	@Test
	public void testCalculateTotalPriceWithCoupon() throws ParseException {
		totalPrice = priceProcessor.calculateTotalPriceWithCoupon(request);
		assertEquals(BigDecimal.valueOf(200d).setScale(2, BigDecimal.ROUND_HALF_UP), 
				totalPrice.setScale(2, BigDecimal.ROUND_HALF_UP));
		
		initcaseForCoupon1();
		totalPrice = priceProcessor.calculateTotalPriceWithCoupon(request);
		assertEquals(BigDecimal.valueOf(800d).setScale(2, BigDecimal.ROUND_HALF_UP), 
				totalPrice.setScale(2, BigDecimal.ROUND_HALF_UP));
		
		initcaseCoupon2();
		totalPrice = priceProcessor.calculateTotalPriceWithCoupon(request);
		assertEquals(BigDecimal.valueOf(43.54).setScale(2, BigDecimal.ROUND_HALF_UP), 
				totalPrice.setScale(2, BigDecimal.ROUND_HALF_UP));
		
		initcaseCoupon3();
		totalPrice = priceProcessor.calculateTotalPriceWithCoupon(request);
		assertEquals(BigDecimal.valueOf(1234d).setScale(2, BigDecimal.ROUND_HALF_UP), 
				totalPrice.setScale(2, BigDecimal.ROUND_HALF_UP));
	}

}
