package com.uwm.onlineshopping.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cart_tbl")
public class CartEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;
	@Column(name = "product_order_ids")
	@OneToMany(cascade = CascadeType.ALL)
	private List<ProductOrderEntity> productOrderIds;
	@Column(name = "total_price")
	private BigDecimal totalPrice;
	@Column(name = "customer_id")
	private int customerId;

	public List<ProductOrderEntity> getProductOrderIds() {
		return productOrderIds;
	}

	public void setProductOrderIds(List<ProductOrderEntity> productOrderIds) {
		this.productOrderIds = productOrderIds;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

}