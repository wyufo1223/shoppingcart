package com.adaweng.shoppingcart.processor;

import com.adaweng.shoppingcart.domain.OrderRequest;
import com.adaweng.shoppingcart.domain.OrderResponse;

public interface Processor {
	OrderResponse process(OrderRequest request);
}
