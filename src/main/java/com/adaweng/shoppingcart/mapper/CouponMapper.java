package com.adaweng.shoppingcart.mapper;

import java.util.List;

import com.adaweng.shoppingcart.entity.Coupon;

public interface CouponMapper {
	List<Coupon> getAllCoupons();
	
	Coupon getCouponById(Long id);
	  
}
