package com.adaweng.shoppingcart.processor;

import com.adaweng.shoppingcart.service.common.OrderRequest;
import com.adaweng.shoppingcart.service.common.OrderResponse;

public interface Processor {
	OrderResponse process(OrderRequest request);
}
