package com.adaweng.shoppingcart.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.adaweng.shoppingcart.persistence.mapper.ProductMapper;

@RestController
@RequestMapping("/shoppingcart")
@EnableAutoConfiguration
@MapperScan("com.adaweng.shoppingcart.persistence.mapper")
public class ProductController {
	@Autowired
    private ProductMapper productMapper;
	
	@RequestMapping("")
	public String index(){
		return "Hello Ada, welcome to Spring boot world！！！";
	}
	
    @RequestMapping("/products")
    public ModelAndView getAllProducts(ModelMap model){
    	model.addAttribute("products", productMapper.getAllProducts());
		return new ModelAndView("productList", model);
    }
    
//	@RequestMapping("showComments.do")
//	public ModelAndView showComments(String demandId, Model model){
//		model.addAttribute("demandId", demandId);
//		return new ModelAndView("commonSystem/comments");
//	}
    
}
