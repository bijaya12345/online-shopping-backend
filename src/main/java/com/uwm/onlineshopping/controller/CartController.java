package com.uwm.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uwm.onlineshopping.dto.CartDto;
import com.uwm.onlineshopping.service.CartService;
import com.uwm.onlineshopping.util.ServiceResponse;

@RestController
@RequestMapping("/api/v1/carts")
public class CartController {

	private final CartService cartSercice;

	@Autowired
	public CartController(CartService cartSercice) {
		this.cartSercice = cartSercice;
	}

	@PostMapping
	public ResponseEntity<ServiceResponse> saveCart(@RequestBody CartDto cartDto) {
		cartSercice.saveCart(cartDto);
		return new ResponseEntity<>(ServiceResponse.getServiceResponse("cart has been registered successfully."),
				HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<ServiceResponse> updateCart(@RequestBody CartDto cartDto) {
		cartSercice.updateCart(cartDto);
		return new ResponseEntity<>(ServiceResponse.getServiceResponse("Cart has been updated successfully."),
				HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ServiceResponse> deleteCart(@PathVariable Long id) {
		cartSercice.deleteCart(id);
		return new ResponseEntity<>(ServiceResponse.getServiceResponse("Cart has been deleted successfully."),
				HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ServiceResponse> getCart(@PathVariable Long id) {
		return new ResponseEntity<>(ServiceResponse.getServiceResponse("Cart has been deleted successfully.")
				.addParam("product", cartSercice.getCartById(id)), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<ServiceResponse> getCart() {
		return new ResponseEntity<>(ServiceResponse.getServiceResponse("Cart has been retrieved successfully.")
				.addParam("products", cartSercice.getAllCart()), HttpStatus.OK);
	}

}
