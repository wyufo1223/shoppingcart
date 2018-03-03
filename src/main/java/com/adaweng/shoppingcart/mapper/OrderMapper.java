package com.adaweng.shoppingcart.mapper;

import java.util.List;

import com.adaweng.shoppingcart.entity.Order;

public interface OrderMapper {
	  List<Order> getAllOrders();

	  Order getOrderById(Long id);

	  List<Order> getOrderByName(String name);

	  Long save(Order order);
	  
	  Long update(Order order);

	  Long delete(Long id);
}
