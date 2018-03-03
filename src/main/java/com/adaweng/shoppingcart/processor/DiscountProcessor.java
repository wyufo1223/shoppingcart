package com.adaweng.shoppingcart.processor;

import java.math.BigDecimal;

import com.adaweng.shoppingcart.domain.OrderItemView;
import com.adaweng.shoppingcart.service.common.OrderRequest;
import com.adaweng.shoppingcart.service.common.OrderResponse;

public class DiscountProcessor implements Processor {

	@Override
	public OrderResponse process(OrderRequest request) {
		for(OrderItemView orderItemView : request.getOrder().getOrderItems()){
			calculateSubtotalDiscount(orderItemView);
		}
		return null;
	}
	
	public BigDecimal calculateSubtotalDiscount(OrderItemView orderItemView) {
		BigDecimal totalPrice = BigDecimal.valueOf(0d);
		if(null == orderItemView.getProdId()) return totalPrice;		
		BigDecimal numsBD = BigDecimal.valueOf(orderItemView.getNumbers());
		BigDecimal unitPriceBD = BigDecimal.valueOf(orderItemView.getProdUnitPrice());
		
		BigDecimal subTotalDiscount = orderItemView.getDiscountStrategy().calculateSubtotalDiscount(
				orderItemView, numsBD.multiply(unitPriceBD));
		orderItemView.setSubTotalDiscount(subTotalDiscount);
		return subTotalDiscount;
	}

}
