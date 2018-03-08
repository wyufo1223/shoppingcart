package com.adaweng.shoppingcart.processor;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.adaweng.shoppingcart.domain.OrderItemView;
import com.adaweng.shoppingcart.domain.ProductType;

public class DiscountProcessorTest {
	
	private DiscountProcessor discountProcessor;
	private OrderItemView orderItemView;
	private BigDecimal totalPrice;

	@Before
	public void setUp() throws Exception {
		discountProcessor = new DiscountProcessor();
		orderItemView = new OrderItemView();
		orderItemView.setProdId(1l);
		orderItemView.setName("ipad");
		orderItemView.setQuantity(1l);		
		orderItemView.setProdUnitPrice(BigDecimal.valueOf(2399.00d));
		orderItemView.setDiscRate(BigDecimal.valueOf(0.5d));
		orderItemView.setProdType(ProductType.ELECTRONIC.name());
	}
	
	public void initcase1() {
		orderItemView.setQuantity(4l);		
		orderItemView.setProdUnitPrice(BigDecimal.valueOf(300.00d));
		orderItemView.setDiscRate(BigDecimal.valueOf(0.8d));
	}
	
	public void initcase2() {
		orderItemView.setQuantity(6l);		
		orderItemView.setProdUnitPrice(BigDecimal.valueOf(900.00d));
		orderItemView.setDiscRate(BigDecimal.valueOf(0.3d));
	}
	
	public void initcase3() {
		orderItemView.setQuantity(6l);		
		orderItemView.setProdUnitPrice(BigDecimal.valueOf(900.00d));
		orderItemView.setDiscRate(BigDecimal.valueOf(0.3d));
		orderItemView.setProdId(null);
	}
	
	public void initcase4() {
		orderItemView.setQuantity(6l);		
		orderItemView.setProdUnitPrice(BigDecimal.valueOf(900.00d));
		orderItemView.setDiscRate(BigDecimal.valueOf(0.3d));
		orderItemView.setProdId(1l);
		orderItemView.setDiscRate(null);
	}
	

	@Test
	public void testCalculateSubtotalDiscount() {
		totalPrice = discountProcessor.calculateSubtotalDiscount(orderItemView);
		assertEquals(BigDecimal.valueOf(1199.5).setScale(2, BigDecimal.ROUND_HALF_UP), totalPrice);
		
		initcase1();
		totalPrice = discountProcessor.calculateSubtotalDiscount(orderItemView);
		assertEquals(BigDecimal.valueOf(240).setScale(2, BigDecimal.ROUND_HALF_UP), totalPrice);
		
		initcase2();
		totalPrice = discountProcessor.calculateSubtotalDiscount(orderItemView);
		assertEquals(BigDecimal.valueOf(3780).setScale(2, BigDecimal.ROUND_HALF_UP), totalPrice);
		
		initcase3();
		totalPrice = discountProcessor.calculateSubtotalDiscount(orderItemView);
		assertEquals(BigDecimal.valueOf(0).setScale(2, BigDecimal.ROUND_HALF_UP), 
				totalPrice.setScale(2, BigDecimal.ROUND_HALF_UP));
		
		initcase4();
		totalPrice = discountProcessor.calculateSubtotalDiscount(orderItemView);
		assertEquals(BigDecimal.valueOf(0).setScale(2, BigDecimal.ROUND_HALF_UP), 
				totalPrice.setScale(2, BigDecimal.ROUND_HALF_UP));
		
	}

}
