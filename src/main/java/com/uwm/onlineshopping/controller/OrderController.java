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

import com.uwm.onlineshopping.dto.OrderDto;
import com.uwm.onlineshopping.service.OrderService;
import com.uwm.onlineshopping.util.ServiceResponse;

@RestController
@RequestMapping("orders")
public class OrderController {

	private final OrderService orderService;

	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@PostMapping
	public ResponseEntity<ServiceResponse> saveOrder(@RequestBody OrderDto orderDto) {
		orderService.saveOrder(orderDto);
		return new ResponseEntity<>(ServiceResponse.getServiceResponse("Order has been registered successfully."),
				HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<ServiceResponse> updateOrder(@RequestBody OrderDto orderDto) {
		orderService.updateOrder(orderDto);
		return new ResponseEntity<>(ServiceResponse.getServiceResponse("Order has been updated successfully."),
				HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ServiceResponse> deleteOrder(@PathVariable Long id) {
		orderService.deleteOrder(id);
		return new ResponseEntity<>(ServiceResponse.getServiceResponse("Order has been deleted successfully."),
				HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ServiceResponse> getOrder(@PathVariable Long id) {
		return new ResponseEntity<>(ServiceResponse.getServiceResponse("Order has been deleted successfully.")
				.addParam("order", orderService.getOrderById(id)), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<ServiceResponse> getOrder() {
		return new ResponseEntity<>(ServiceResponse.getServiceResponse("Order has been retrieved successfully.")
				.addParam("orders", orderService.getAllOrder()), HttpStatus.OK);
	}

}
