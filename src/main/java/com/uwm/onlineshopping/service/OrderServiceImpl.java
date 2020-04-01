package com.uwm.onlineshopping.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uwm.onlineshopping.dto.OrderDto;
import com.uwm.onlineshopping.model.OrderEntity;
import com.uwm.onlineshopping.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	private final OrderRepository orderRepository;

	@Autowired
	public OrderServiceImpl(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@Override
	public void saveOrder(OrderDto orderDto) {
		OrderEntity orderEntity = new OrderEntity();
		BeanUtils.copyProperties(orderDto, orderEntity);
		orderRepository.save(orderEntity);
	}

	@Override
	public void updateOrder(OrderDto orderDto) {
		OrderEntity orderEntity = new OrderEntity();
		BeanUtils.copyProperties(orderDto, orderEntity);
		orderRepository.save(orderEntity);

	}

	@Override
	public void deleteOrder(Long id) {
		orderRepository.deleteById(id);

	}

	@Override
	public OrderDto getOrderById(Long id) {
		OrderDto orderDto = new OrderDto();
		BeanUtils.copyProperties(orderRepository.findById(id), orderDto);
		return orderDto;
	}

	@Override
	public List<OrderDto> getAllOrder() {
		return orderRepository.findAll().stream().map(orderEntity -> {
			OrderDto orderDto = new OrderDto();
			BeanUtils.copyProperties(orderEntity, orderDto);
			return orderDto;
		}).collect(Collectors.toList());
	}
}
