package com.adaweng.shoppingcart;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@MapperScan("com.adaweng.shoppingcart.mapper")
public class Application {
	@RequestMapping("/shoppingcart")
	public String index(){
		return "Hello Ada, welcome to Spring boot world！！！";
	}
	
	public static void main(String[] args){
		SpringApplication.run(Application.class, args);
	}
}
