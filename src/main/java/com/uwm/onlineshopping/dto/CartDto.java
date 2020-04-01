package com.uwm.onlineshopping.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.uwm.onlineshopping.model.CustomerEntity;
import com.uwm.onlineshopping.model.ProductEntity;

public class CartDto {

	@OneToMany
	private List<ProductEntity> products = new ArrayList<>();
	private BigDecimal totalPrice;
	@OneToOne
	private CustomerEntity customerId;

	public List<ProductEntity> getProducts() {
		return products;
	}

	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public CustomerEntity getCustomerId() {
		return customerId;
	}

	public void setCustomerId(CustomerEntity customerId) {
		this.customerId = customerId;
	}

}
