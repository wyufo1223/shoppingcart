package com.adaweng.shoppingcart.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.adaweng.shoppingcart.dto.Coupon;
import com.adaweng.shoppingcart.dto.Discount;
import com.adaweng.shoppingcart.dto.OrderItem;
import com.adaweng.shoppingcart.dto.OrderRequest;
import com.adaweng.shoppingcart.dto.ProductStatus;
import com.adaweng.shoppingcart.util.DateUtil;

@Service
public class ShoppingCartService {	

	public BigDecimal calculateTotalPriceWithDiscounts(OrderRequest request){
		BigDecimal totalPrice = BigDecimal.valueOf(0d);
		Set<OrderItem> 	orderItems = request.getOrder().getOrderItems();
		
		if(null == orderItems) {
			System.out.println("There is no product in your order.");
			return totalPrice;
		}
		
		for(OrderItem oi : orderItems){
			BigDecimal numsBD = BigDecimal.valueOf(oi.getNumbers());
			BigDecimal unitPriceBD = BigDecimal.valueOf(oi.getProduct().getUnitPrice());
			
			if(null != oi.getProduct().getStatus() && 
					ProductStatus.REMOVED.name().equals(oi.getProduct().getStatus())) continue;
			
			if(null != oi.getProduct().getStockAmount() && 
					oi.getNumbers() > oi.getProduct().getStockAmount()){
				System.out.println("The amount of stock is not enough.");
				continue;
			}
			
			totalPrice = totalPrice.add(oi.calculateSubtotalPrice());	
			
//			if(null == request.getOrder().getDateUtil){
//				totalPrice = totalPrice.add(oi.calculateSubtotalPrice());				
//			}else{
//				for(Discount discount : discounts){
//					if(DateUtil.getDateUtil().getDifferDateDay(paymentDate, discount.getAvailableDate()) == 0){
//						if(oi.getProduct().getType().equals(discount.getProductType())){
//							BigDecimal discountBD = BigDecimal.valueOf(discount.getQuota());
//							totalPrice = totalPrice.add(numsBD.multiply(unitPriceBD).multiply(discountBD));
//						}else{
//							totalPrice = totalPrice.add(numsBD.multiply(unitPriceBD));
//						}
//					}
//				}
//			}
		}
		
		return totalPrice;
	}
	
	public BigDecimal calculateTotalPriceWithCoupon(OrderRequest request){
		BigDecimal totalPrice = request.getOrder().getTotalPrice();
		if(null == request.getCoupon()){
			return totalPrice;
		}
		
		if(DateUtil.getDateUtil().getDifferDateDay(request.getOrder().getPaymentDate(), 
				request.getCoupon().getEndDate()) <= 0){
			if(null != totalPrice && totalPrice.compareTo(BigDecimal.valueOf(request.getCoupon().getPriceReached())) >= 0){
				totalPrice = totalPrice.subtract(BigDecimal.valueOf(request.getCoupon().getPriceReduced()));
			}
		}
		
		return totalPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	
	public BigDecimal calculateTotalPriceWithCoupon(BigDecimal totalPrice, Coupon coupon, Date paymentDate){
		if(null == coupon){
			return totalPrice;
		}
		
		if(DateUtil.getDateUtil().getDifferDateDay(paymentDate, coupon.getEndDate()) <= 0){
			if(null != totalPrice && totalPrice.compareTo(BigDecimal.valueOf(coupon.getPriceReached())) >= 0){
				totalPrice = totalPrice.subtract(BigDecimal.valueOf(coupon.getPriceReduced()));
			}
		}
		
		return totalPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
	}	
	
	public static void main(String[] args){
		String re = "\\|";
		Pattern p = Pattern.compile(re);
		
		System.out.println("Please input your shoppingcart data:");
		String input = null;
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()){
			input = sc.nextLine();
			if(Pattern.compile(re).matcher(input).matches()){
				String[] discountArr = p.split(re);
				Discount discount = new Discount();
				//discount.setAvailableDate(Date.parse(discountArr[0]));
			}
		}
		
		System.out.println("The input are: " + input);
	}

}
