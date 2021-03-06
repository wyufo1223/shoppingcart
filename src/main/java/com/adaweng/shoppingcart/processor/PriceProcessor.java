package com.adaweng.shoppingcart.processor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.adaweng.shoppingcart.domain.CouponView;
import com.adaweng.shoppingcart.domain.OrderItemView;
import com.adaweng.shoppingcart.domain.ProductStatus;
import com.adaweng.shoppingcart.entity.OrderItem;
import com.adaweng.shoppingcart.service.common.OrderRequest;
import com.adaweng.shoppingcart.service.common.OrderResponse;
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
		BigDecimal numsBD = BigDecimal.valueOf(orderItemView.getQuantity());
		BigDecimal unitPriceBD = orderItemView.getProdUnitPrice();
		
		BigDecimal subTotalPrice = orderItemView.getDiscountStrategy().calculateSubtotalPrice(
				orderItemView, numsBD.multiply(unitPriceBD));
		orderItemView.setSubTotalPrice(subTotalPrice);
		return subTotalPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	
	public BigDecimal calculateTotalPriceWithDiscounts(OrderRequest request){
		BigDecimal totalPrice = BigDecimal.valueOf(0d);
		List<OrderItemView> orderItems = request.getOrder().getOrderItems();
		
		if(null == orderItems) {
			System.out.println("There is no product in your order.");
			return totalPrice;
		}
		
		for(OrderItemView oi : orderItems){
			BigDecimal numsBD = BigDecimal.valueOf(oi.getQuantity());
			BigDecimal unitPriceBD = oi.getProdUnitPrice();
			
			if(null != oi.getProdStatus() && 
					ProductStatus.REMOVED.name().equals(oi.getProdStatus())) continue;
			
			if(null != oi.getProdStockAmount() && 
					oi.getQuantity() > oi.getProdStockAmount()){
				System.out.println("The amount of stock is not enough.");
				continue;
			}
			
			totalPrice = totalPrice.add(calculateSubtotalPrice(oi));	
			request.getOrder().setTotalPrice(totalPrice.setScale(2, BigDecimal.ROUND_HALF_UP));
		}
		
		return totalPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	
	public BigDecimal calculateTotalPriceWithCoupon(OrderRequest request){
		BigDecimal totalPrice = request.getOrder().getTotalPrice();
		if(null == request.getCoupon()){
			return totalPrice;
		}		
		if(DateUtil.getDateUtil().getDifferDateDay(request.getOrder().getPaymentDate(), 
				request.getCoupon().getEndDate()) <= 0){
			if(null != totalPrice && totalPrice.compareTo(request.getCoupon().getPriceReached()) >= 0){
				totalPrice = totalPrice.subtract(request.getCoupon().getPriceReduced());
			}
		}
		request.getOrder().setTotalPrice(totalPrice.setScale(2, BigDecimal.ROUND_HALF_UP));
		return totalPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	
	public BigDecimal calculateTotalPriceWithCoupon(BigDecimal totalPrice, CouponView coupon, Date paymentDate){
		if(null == coupon){
			return totalPrice;
		}
		
		if(DateUtil.getDateUtil().getDifferDateDay(paymentDate, coupon.getEndDate()) <= 0){
			if(null != totalPrice && totalPrice.compareTo(coupon.getPriceReached()) >= 0){
				totalPrice = totalPrice.subtract(coupon.getPriceReduced());
			}
		}
		
		return totalPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
	}

}
