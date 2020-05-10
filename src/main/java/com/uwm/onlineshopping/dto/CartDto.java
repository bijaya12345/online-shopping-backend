package com.uwm.onlineshopping.dto;

import java.math.BigDecimal;
import java.util.List;

public class CartDto extends BaseDto {

	private List<CheckoutDto> products;
	private BigDecimal total;
	private UserDto customerId;

	public List<CheckoutDto> getProducts() {
		return products;
	}

	public void setProducts(List<CheckoutDto> products) {
		this.products = products;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public UserDto getCustomerId() {
		return customerId;
	}

	public void setCustomerId(UserDto customerId) {
		this.customerId = customerId;
	}

}
