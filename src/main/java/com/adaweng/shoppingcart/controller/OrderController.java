package com.adaweng.shoppingcart.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@EnableAutoConfiguration
@MapperScan("com.adaweng.shoppingcart.persistence.mapper")
public class OrderController {

}
