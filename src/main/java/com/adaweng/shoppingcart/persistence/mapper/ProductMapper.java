package com.adaweng.shoppingcart.persistence.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.adaweng.shoppingcart.dto.Product;

@Mapper
public interface ProductMapper {
	  @Select("SELECT * FROM Product")
	  List<Product> getAllProducts();

	  Product getProductById(Long id);

	  List<Product> getProductByName(String name);

	  Long save(Product product);
	  
	  Long update(Product product);

	  @Delete("DELETE FROM Product WHERE id =#{id}")
	  Long delete(Long id);
}
