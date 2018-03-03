package com.adaweng.shoppingcart.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adaweng.shoppingcart.domain.OrderItemView;
import com.adaweng.shoppingcart.entity.Discount;
import com.adaweng.shoppingcart.entity.OrderItem;
import com.adaweng.shoppingcart.entity.Product;
import com.adaweng.shoppingcart.mapper.DiscountMapper;
import com.adaweng.shoppingcart.mapper.OrderItemMapper;
import com.adaweng.shoppingcart.mapper.ProductMapper;

@Service
public class ShoppingCartService {	

	@Autowired
	OrderItemMapper orderItemMapper;
	
	@Autowired
	ProductMapper productMapper;
	
	@Autowired
	DiscountMapper discountMapper;
	
	public List<OrderItemView> getMyOrderItems(){
		List<OrderItemView> orderItemViewList = new ArrayList<OrderItemView>();
		List<OrderItem> orderItemList = orderItemMapper.getAllOrderItems();
		for(OrderItem oi : orderItemList){
			OrderItemView orderItemView = OrderItemView.convertOrderItemToOrderItemView(oi);
			orderItemView.setName(oi.getName());
			orderItemView.setProdName(oi.getProdName());
			orderItemView.setNumbers(oi.getNumbers());
			orderItemView.setProdUnitPrice(oi.getProdUnitPrice());
			orderItemViewList.add(orderItemView);
		}
		return orderItemViewList;	
	}
	
	@Transactional(readOnly=false)
	public void delProdFromCart(String orderItemId){
		orderItemMapper.delete(Long.parseLong(orderItemId));
	}
	
	@Transactional(readOnly=false)
	public void addProdToCart(String prodId){
		List<OrderItem> orderItemList = orderItemMapper.getAllOrderItems();
		Product product = productMapper.getProductById(Long.parseLong(prodId));
		Discount discount = discountMapper.getDiscountByProductType(product.getType());
		
		List<OrderItem> oiList = orderItemList.stream().filter(o -> product.getId().equals(o.getProdId())).
				collect(Collectors.toList());
		if(oiList.size() == 0 || null != orderItemList && orderItemList.size() == 0){
			OrderItem orderItem = new OrderItem();
			orderItem.setName(product.getName());
			orderItem.setNumbers(1l);
			orderItem.setProduct(product);
			orderItem.setProdUnitPrice(product.getUnitPrice());
			orderItem.setDiscount(discount);
			orderItem.setDiscType(discount.getDiscountType());
			orderItem.setDiscRate(discount.getRate());
			orderItem.setDiscAvailableDate(discount.getAvailableDate());
			
			orderItemMapper.save(orderItem);
			return;
		}
		
		for(OrderItem oi : orderItemList){
			if(oi.getProdId().equals(product.getId())){
				oi.setNumbers(oi.getNumbers() + 1);
				orderItemMapper.update(oi);
			}
		}	
	}
	
	public Long update(OrderItem orderItem){
		return orderItemMapper.update(orderItem);	
	}
	
	public Long delete(OrderItem orderItem){
		return orderItemMapper.delete(orderItem.getId());	
	}

}
