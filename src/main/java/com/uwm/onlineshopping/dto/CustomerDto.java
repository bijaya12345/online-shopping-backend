package com.uwm.onlineshopping.dto;

import javax.persistence.OneToOne;

import com.uwm.onlineshopping.model.UserEntity;
public class CustomerDto extends BaseDto {

	private String customerName;
	private Long customerMobile;
	private String customerAddress;
	@OneToOne
	private UserEntity userId;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Long getCustomerMobile() {
		return customerMobile;
	}

	public void setCustomerMobile(Long customerMobile) {
		this.customerMobile = customerMobile;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public UserEntity getUserId() {
		return userId;
	}

	public void setUserId(UserEntity userId) {
		this.userId = userId;
	}

}
