package com.uwm.onlineshopping.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "order_tbl")
public class OrderEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@JoinColumn(name = "order_customer_id")
	private CustomerEntity orderCustomerId;
	@Column(name = "order_number")
	private Long orderNumber;
	@Column(name = "order_description")
	private String orderDescription;
	@Column(name = "order_shipped_date")
	private Instant orderShippedDate;
	@Column(name = "order_date")
	private Instant orderDate;
	@Column(name = "order_status")
	private Boolean orderStatus;

	public CustomerEntity getOrderCustomerId() {
		return orderCustomerId;
	}

	public void setOrderCustomerId(CustomerEntity orderCustomerId) {
		this.orderCustomerId = orderCustomerId;
	}

	public Long getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Long orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getOrderDescription() {
		return orderDescription;
	}

	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}

	public Instant getOrderShippedDate() {
		return orderShippedDate;
	}

	public void setOrderShippedDate(Instant orderShippedDate) {
		this.orderShippedDate = orderShippedDate;
	}

	public Instant getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Instant orderDate) {
		this.orderDate = orderDate;
	}

	public Boolean getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Boolean orderStatus) {
		this.orderStatus = orderStatus;
	}

}
