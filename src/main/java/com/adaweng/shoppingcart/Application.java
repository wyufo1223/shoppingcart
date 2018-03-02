package com.adaweng.shoppingcart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableCaching
public class Application {
	@RequestMapping("")
	public String index(){
		return "Hello Ada, welcome to Spring boot world！！！";
	}
	
	public static void main(String[] args){
		SpringApplication.run(Application.class, args);
	}
}
