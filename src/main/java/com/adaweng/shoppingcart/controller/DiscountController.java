package com.adaweng.shoppingcart.controller;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adaweng.shoppingcart.dto.Discount;



@RestController
@RequestMapping("/discounts")
@EnableAutoConfiguration
@MapperScan("com.adaweng.shoppingcart.persistence.mapper")
public class DiscountController {

	
	
}
