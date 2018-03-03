package com.adaweng.shoppingcart.mapper;

import java.util.List;

import com.adaweng.shoppingcart.entity.Discount;

public interface DiscountMapper {
	  List<Discount> getAllDiscounts();

	  Discount getDiscountById(Long id);
	  
	  Discount getDiscountByProductType(String productType);

	  List<Discount> getDiscountByName(String name);

	  Long save(Discount discount);
	  
	  Long update(Discount discount);

	  Long delete(Long id);
}
