package com.adaweng.shoppingcart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaweng.shoppingcart.domain.OrderItemView;
import com.adaweng.shoppingcart.entity.OrderItem;
import com.adaweng.shoppingcart.mapper.OrderItemMapper;

@Service
public class ShoppingCartService {	

	@Autowired
	OrderItemMapper orderItemMapper;
	
	public List<OrderItemView> getMyOrderItems(){
		List<OrderItemView> orderItemViewList = new ArrayList<OrderItemView>();
		List<OrderItem> orderItemList = orderItemMapper.getAllOrderItems();
		for(OrderItem oi : orderItemList){
			OrderItemView orderItemView = OrderItemView.convertOrderItemToOrderItemView(oi);
			orderItemView.setName(oi.getProduct().getName());
			orderItemView.setProdUnitPrice(oi.getProduct().getUnitPrice());
			orderItemViewList.add(orderItemView);
		}
		return orderItemViewList;	
	}
	
	public Long create(OrderItem orderItem){
		return orderItemMapper.save(orderItem);	
	}
	
	public Long update(OrderItem orderItem){
		return orderItemMapper.update(orderItem);	
	}
	
	public Long delete(OrderItem orderItem){
		return orderItemMapper.delete(orderItem.getId());	
	}

}
