package com.uwm.onlineshopping.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart_tbl")
public class CartEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;
	@OneToMany
	private List<ProductEntity> products = new ArrayList<>();
	@Column(name = "total_price")
	private BigDecimal totalPrice;
	@JoinColumn(name = "customer_id")
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