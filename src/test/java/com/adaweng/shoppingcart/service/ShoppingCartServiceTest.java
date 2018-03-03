package com.adaweng.shoppingcart.service;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.adaweng.shoppingcart.domain.CouponView;
import com.adaweng.shoppingcart.domain.DiscountView;
import com.adaweng.shoppingcart.domain.OrderItemView;
import com.adaweng.shoppingcart.domain.ProductType;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoppingCartServiceTest extends ShoppingCartService {
	/*@Autowired
	private ShoppingCartService shoppingCartService;	
	
	private Set<OrderItem> orderLines;	
	
	private OrderItem orderLine;	

	private List<Discount> discounts;	

	private Discount discount;	

	private Coupon coupon;
	
	private Date paymentDate;
	
	private BigDecimal totalPrice;

	@Before
	public void setUp() throws Exception {
//		MockitoAnnotations.initMocks( this );
//		discount = Mockito.mock(Discount.class);
//		discounts = Mockito.mock(List.class);
//		commodityItem = Mockito.mock(CommodityItem.class);
//		commodityItems = Mockito.mock(new HashSet<CommodityItem>().getClass());
//		coupon = Mockito.mock(Coupon.class);
		initcaseone();
	}
	
	public void initcaseone() throws ParseException{
		discount = new Discount();
		discounts = new ArrayList<Discount>();
		
		orderLines = new HashSet<OrderItem>();
		coupon = new Coupon();
		totalPrice = BigDecimal.valueOf(0d);
				
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		
		discount.setAvailableDate(sdf.parse("2013.11.11"));
		discount.setQuota(0.7d);
		discount.setCommodityType(ProductType.ELECTRONIC.name());		
		discounts.add(discount);		
		
		orderLine = new OrderItem();
		orderLine.setNumbers(1l);
		orderLine.setName("ipad");
		orderLine.getProduct().setUnitPrice(2399.00);
		orderLine.getProduct().setType(ProductType.ELECTRONIC.name());
		orderLines.add(orderLine);
		
		orderLine = new OrderItem();
		orderLine.setNumbers(1l);
		orderLine.setName("显示器");
		orderLine.getProduct().setUnitPrice(1799.00);
		orderLine.getProduct().setType(ProductType.ELECTRONIC.name());
		orderLines.add(orderLine);
		
		orderLine = new OrderItem();
		orderLine.setNumbers(12l);
		orderLine.setName("啤酒");
		orderLine.getProduct().setUnitPrice(25.00);
		orderLine.getProduct().setType(ProductType.LIQUOR.name());
		orderLines.add(orderLine);
		
		orderLine = new OrderItem();
		orderLine.setNumbers(5l);
		orderLine.setName("面包");
		orderLine.getProduct().setUnitPrice(9.00);
		orderLine.getProduct().setType(ProductType.FOOD.name());
		orderLines.add(orderLine);
		
		paymentDate = sdf.parse("2013.11.11");
		
		coupon = new Coupon();
		coupon.setEndDate(sdf.parse("2014.3.2"));
		coupon.setPriceReached(1000d);
		coupon.setPriceReduced(200d);
	}
	
	public void initcasetwo() throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		
		orderLines = new HashSet<OrderItem>();
		orderLine = new OrderItem();
		orderLine.setNumbers(3l);
		orderLine.setName("蔬菜");
		orderLine.getProduct().setUnitPrice(5.98);
		orderLine.getProduct().setType(ProductType.FOOD.name());
		orderLines.add(orderLine);
		
		orderLine = new OrderItem();
		orderLine.setNumbers(8l);
		orderLine.setName("餐巾纸");
		orderLine.getProduct().setUnitPrice(3.20);
		orderLine.getProduct().setType(ProductType.NECESSITIES.name());
		orderLines.add(orderLine);
		
		discounts = null;
		paymentDate = sdf.parse("2014.01.01");
		
	}

	@Test
	public void testCountTotalPriceWithDiscounts() throws ParseException {
		initcaseone();
		totalPrice = shoppingCartService.countTotalPriceWithDiscounts(orderLines, discounts, paymentDate);
		assertEquals(BigDecimal.valueOf(3283.6).setScale(2, BigDecimal.ROUND_HALF_UP), totalPrice);
		
		initcasetwo();
		totalPrice = shoppingCartService.countTotalPriceWithDiscounts(orderLines, discounts, paymentDate);
		assertEquals(BigDecimal.valueOf(43.54).setScale(2, BigDecimal.ROUND_HALF_UP), totalPrice);	
		
	}

	@Test
	public void testCountTotalPriceWithCoupon() throws ParseException {
		totalPrice = BigDecimal.valueOf(0d);
		totalPrice = shoppingCartService.countTotalPriceWithCoupon(totalPrice, coupon, paymentDate);
		assertEquals(BigDecimal.valueOf(0d).setScale(2, BigDecimal.ROUND_HALF_UP), totalPrice);
		
		totalPrice = BigDecimal.valueOf(1000d);
		totalPrice = shoppingCartService.countTotalPriceWithCoupon(totalPrice, coupon, paymentDate);
		assertEquals(BigDecimal.valueOf(800d).setScale(2, BigDecimal.ROUND_HALF_UP), totalPrice);
		
		totalPrice = BigDecimal.valueOf(43.54d);
		totalPrice = shoppingCartService.countTotalPriceWithCoupon(totalPrice, coupon, paymentDate);
		assertEquals(BigDecimal.valueOf(43.54).setScale(2, BigDecimal.ROUND_HALF_UP), totalPrice);
		
		totalPrice = BigDecimal.valueOf(1434d);
		totalPrice = shoppingCartService.countTotalPriceWithCoupon(totalPrice, coupon, paymentDate);
		assertEquals(BigDecimal.valueOf(1234d).setScale(2, BigDecimal.ROUND_HALF_UP), totalPrice);
	}
*/
}
