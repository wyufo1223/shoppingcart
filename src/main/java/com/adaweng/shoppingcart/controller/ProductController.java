package com.adaweng.shoppingcart.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Object getAllProducts(){
        return productMapper.getAllProducts();
    }
}
