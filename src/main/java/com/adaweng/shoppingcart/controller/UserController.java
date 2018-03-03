package com.adaweng.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.adaweng.shoppingcart.mapper.UserMapper;

@RestController
@RequestMapping("")
public class UserController {
	@Autowired
    private UserMapper userMapper;
	

	
    @RequestMapping("/users")
    public ModelAndView getAllProducts(ModelMap model){
    	model.addAttribute("products", userMapper.getAllUsers());
		return new ModelAndView("productList", model);
    }
}
