package com.adaweng.shoppingcart.processor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import com.adaweng.shoppingcart.domain.CouponView;
import com.adaweng.shoppingcart.domain.OrderItemView;
import com.adaweng.shoppingcart.domain.OrderRequest;
import com.adaweng.shoppingcart.domain.OrderResponse;
import com.adaweng.shoppingcart.domain.ProductStatus;
import com.adaweng.shoppingcart.entity.OrderItem;
import com.adaweng.shoppingcart.util.DateUtil;

public class PriceProcessor implements Processor {

	@Override
	public OrderResponse process(OrderRequest request) {
		for(OrderItemView orderItemView : request.getOrder().getOrderItems()){
			calculateSubtotalPrice(orderItemView);
		}
		return null;
	}
	
	public BigDecimal calculateSubtotalPrice(OrderItemView orderItemView) {
		BigDecimal totalPrice = BigDecimal.valueOf(0d);
		if(null == orderItemView.getProdId()) return totalPrice;		
		BigDecimal numsBD = BigDecimal.valueOf(orderItemView.getNumbers());
		BigDecimal unitPriceBD = BigDecimal.valueOf(orderItemView.getProdUnitPrice());
		
		BigDecimal subTotalPrice = orderItemView.getDiscountStrategy().calculateSubtotalPrice(
				orderItemView, numsBD.multiply(unitPriceBD));
		orderItemView.setSubTotalPrice(subTotalPrice);
		return subTotalPrice;
	}
	
	public BigDecimal calculateTotalPriceWithDiscounts(OrderRequest request){
		BigDecimal totalPrice = BigDecimal.valueOf(0d);
		Set<OrderItemView> 	orderItems = request.getOrder().getOrderItems();
		
		if(null == orderItems) {
			System.out.println("There is no product in your order.");
			return totalPrice;
		}
		
		for(OrderItemView oi : orderItems){
			BigDecimal numsBD = BigDecimal.valueOf(oi.getNumbers());
			BigDecimal unitPriceBD = BigDecimal.valueOf(oi.getProduct().getUnitPrice());
			
			if(null != oi.getProduct().getStatus() && 
					ProductStatus.REMOVED.name().equals(oi.getProduct().getStatus())) continue;
			
			if(null != oi.getProduct().getStockAmount() && 
					oi.getNumbers() > oi.getProduct().getStockAmount()){
				System.out.println("The amount of stock is not enough.");
				continue;
			}
			
			totalPrice = totalPrice.add(calculateSubtotalPrice(oi));	
			
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
	
	public BigDecimal calculateTotalPriceWithCoupon(BigDecimal totalPrice, CouponView coupon, Date paymentDate){
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

}
