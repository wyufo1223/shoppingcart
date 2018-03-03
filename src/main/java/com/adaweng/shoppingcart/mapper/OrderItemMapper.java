package com.adaweng.shoppingcart.mapper;

import java.util.List;

import com.adaweng.shoppingcart.entity.OrderItem;

public interface OrderItemMapper {
	  List<OrderItem> getAllOrderItems();
	  
	  OrderItem getOrderItemById(Long id);

	  List<OrderItem> getOrderItemByName(String name);

	  Long save(OrderItem orderItem);
	  
	  Long update(OrderItem orderItem);

	  Long delete(Long id);
}
