package com.adaweng.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.adaweng.shoppingcart.entity.Discount;
import com.adaweng.shoppingcart.entity.OrderItem;
import com.adaweng.shoppingcart.entity.Product;
import com.adaweng.shoppingcart.mapper.DiscountMapper;
import com.adaweng.shoppingcart.mapper.OrderItemMapper;
import com.adaweng.shoppingcart.mapper.ProductMapper;
import com.adaweng.shoppingcart.service.ShoppingCartService;

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
    public ModelAndView myShoppingCart(ModelMap model){
    	model.addAttribute("orderItems", shoppingCartService.getMyOrderItems());
    	model.addAttribute("coupon", shoppingCartService.getMyOrderItems());
		return new ModelAndView("myShoppingCart", model);
    }	
}
