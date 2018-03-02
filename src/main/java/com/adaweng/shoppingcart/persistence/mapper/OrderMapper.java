package com.adaweng.shoppingcart.persistence.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.adaweng.shoppingcart.dto.Order;

@Mapper
public interface OrderMapper {
  @Select("SELECT * FROM Order")
	  List<Order> getAllOrders();

	  Order getOrderById(Long id);

	  List<Order> getOrderByName(String name);

	  Long save(Order Order);
	  
	  Long update(Order Order);

	  @Delete("DELETE FROM Order WHERE id =#{id}")
	  Long delete(Long id);
}
