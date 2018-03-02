package com.adaweng.shoppingcart.processor;

import com.adaweng.shoppingcart.dto.OrderRequest;
import com.adaweng.shoppingcart.dto.OrderResponse;

public interface Processor {
	OrderResponse process(OrderRequest request);
}
