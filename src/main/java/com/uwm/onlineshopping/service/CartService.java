package com.uwm.onlineshopping.service;

import java.util.List;

import com.uwm.onlineshopping.dto.CartDto;

// interface class 
public interface CartService {

      // list of abstract methods 
         
	void saveCart(CartDto cartDto);

	void updateCart(CartDto cartDto);

	void deleteCart(Long id);

	CartDto getCartById(Long id);

	List<CartDto> getAllCart();

}
