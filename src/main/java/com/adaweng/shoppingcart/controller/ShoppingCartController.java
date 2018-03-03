package com.adaweng.shoppingcart.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.adaweng.shoppingcart.mapper.OrderItemMapper;
import com.adaweng.shoppingcart.service.ShoppingCartService;
import com.adaweng.shoppingcart.service.common.OrderResponse;

@RestController
@EnableAutoConfiguration
@RequestMapping("/shoppingcart")
public class ShoppingCartController {
	@Autowired
	ShoppingCartService shoppingCartService;
	
	@Autowired
	OrderItemMapper orderItemMapper;
	
	
	
    @RequestMapping("addProductToCart")
    @ResponseBody
    public ModelAndView addProductToCart(ModelMap model, @RequestBody String id){
    	shoppingCartService.addProdToCart(id);
		return new ModelAndView("myShoppingCart");
    }
    
    @RequestMapping("delProdFromCart")
    @ResponseBody
    public void delProdFromCart(ModelMap model, @RequestBody String id){
    	shoppingCartService.delProdFromCart(id);
    }
    
    @RequestMapping("myShoppingCart")
    @ResponseBody
    public ModelAndView myShoppingCart(ModelMap model) throws ParseException{
    	OrderResponse orderResponse = shoppingCartService.getMyOrderDetail();
    	model.addAttribute("orderItems", orderResponse.getOrderItemsView());
    	model.addAttribute("myCoupon", orderResponse.getCouponView());
    	model.addAttribute("totalPrice", orderResponse.getOrderView().getTotalPrice());
		return new ModelAndView("myShoppingCart", model);
    }	
}
