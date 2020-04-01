package com.uwm.onlineshopping.service;

import java.util.List;

import com.uwm.onlineshopping.dto.OrderDto;

public interface OrderService {
	void saveOrder(OrderDto orderDto);

	void updateOrder(OrderDto orderDto);

	void deleteOrder(Long id);

	OrderDto getOrderById(Long id);

	List<OrderDto> getAllOrder();

}
