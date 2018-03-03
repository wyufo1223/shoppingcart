package com.adaweng.shoppingcart.mapper;

import java.util.List;

import com.adaweng.shoppingcart.entity.Product;

public interface ProductMapper {
	  List<Product> getAllProducts();

	  Product getProductById(Long id);

	  List<Product> getProductByName(String name);

	  Long save(Product product);
	  
	  Long update(Product product);

	  Long delete(Long id);
}
