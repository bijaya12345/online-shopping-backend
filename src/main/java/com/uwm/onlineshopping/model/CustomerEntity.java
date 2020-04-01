package com.uwm.onlineshopping.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer_tbl")
public class CustomerEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;
	@Column(name = "customer_name")
	private String customerName;
	@Column(name = "customer_mobile")
	private Long customerMobile;
	@Column(name = "customer_address")
	private String customerAddress;
	@OneToOne
	@JoinColumn(name = "user_id")
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