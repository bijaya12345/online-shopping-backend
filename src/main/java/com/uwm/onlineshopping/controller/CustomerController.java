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

import com.uwm.onlineshopping.dto.CustomerDto;
import com.uwm.onlineshopping.service.CustomerService;
import com.uwm.onlineshopping.util.ServiceResponse;

@RestController
@RequestMapping("customers")
public class CustomerController {

	private final CustomerService customerSercice;

	@Autowired
	public CustomerController(CustomerService customerSercice) {
		this.customerSercice = customerSercice;
	}

	@PostMapping
	public ResponseEntity<ServiceResponse> saveCustomer(@RequestBody CustomerDto customerDto) {
		customerSercice.saveCustomer(customerDto);
		return new ResponseEntity<>(ServiceResponse.getServiceResponse("Customer has been registered successfully."),
				HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<ServiceResponse> updateCustomer(@RequestBody CustomerDto customerDto) {
		customerSercice.updateCustomer(customerDto);
		return new ResponseEntity<>(ServiceResponse.getServiceResponse("Customer has been updated successfully."),
				HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ServiceResponse> deleteCustomer(@PathVariable Long id) {
		customerSercice.deleteCustomer(id);
		return new ResponseEntity<>(ServiceResponse.getServiceResponse("Customer has been deleted successfully."),
				HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ServiceResponse> getCustomer(@PathVariable Long id) {
		return new ResponseEntity<>(ServiceResponse.getServiceResponse("Customer has been deleted successfully.")
				.addParam("customer", customerSercice.getCustomerById(id)), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<ServiceResponse> getCustomer() {
		return new ResponseEntity<>(ServiceResponse.getServiceResponse("Customer has been retrieved successfully.")
				.addParam("customers", customerSercice.getAllCustomer()), HttpStatus.OK);
	}

}
