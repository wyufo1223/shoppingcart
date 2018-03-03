package com.adaweng.shoppingcart.mapper;

import java.util.List;

import com.adaweng.shoppingcart.entity.User;

public interface UserMapper {
	  List<User> getAllUsers();
	
	  User getUserById(Long id);
	
	  List<User> getUserByName(String name);
	
	  Long save(User user);
	
	  Long delete(Long id);
}
