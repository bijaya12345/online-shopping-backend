package com.uwm.onlineshopping.dto;

import java.time.Instant;

import com.uwm.onlineshopping.model.CustomerEntity;

public class OrderDto extends BaseDto {

	private CustomerEntity orderCustomerId;
	private Long orderNumber;
	private String orderDescription;
	private Instant orderShippedDate;
	private Instant orderDate;
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
