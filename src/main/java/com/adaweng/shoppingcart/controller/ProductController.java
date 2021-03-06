package com.adaweng.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.adaweng.shoppingcart.mapper.ProductMapper;

@RestController
@RequestMapping("/shoppingcart")
public class ProductController {
	@Autowired
    private ProductMapper productMapper;
	

	
    @RequestMapping("/products")
    public ModelAndView getAllProducts(ModelMap model){
    	model.addAttribute("products", productMapper.getAllProducts());
		return new ModelAndView("productList", model);
    }
    
}
