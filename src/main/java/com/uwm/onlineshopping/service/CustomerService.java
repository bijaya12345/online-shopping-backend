package com.uwm.onlineshopping.service;

import java.util.List;

import com.uwm.onlineshopping.dto.CustomerDto;

public interface CustomerService {
	
	void saveCustomer(CustomerDto customerDto);

	void updateCustomer(CustomerDto customerDto);

	void deleteCustomer(Long id);

	CustomerDto getCustomerById(Long id);

	List<CustomerDto> getAllCustomer();

}
