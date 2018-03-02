package com.adaweng.shoppingcart.persistence.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.adaweng.shoppingcart.dto.Discount;

@Mapper
public interface DiscountMapper {
	  @Select("SELECT * FROM Discount")
	  List<Discount> getAllDiscounts();

	  Discount getDiscountById(Long id);

	  List<Discount> getDiscountByName(String name);

	  Long save(Discount discount);
	  
	  Long update(Discount discount);

	  @Delete("DELETE FROM Discount WHERE id =#{id}")
	  Long delete(Long id);
}
