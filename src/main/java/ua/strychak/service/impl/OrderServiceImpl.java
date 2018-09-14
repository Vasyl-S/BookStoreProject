package ua.strychak.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.strychak.domain.OrderDTO;
import ua.strychak.entity.Order;
import ua.strychak.repository.OrderRepository;
import ua.strychak.service.OrderService;
import ua.strychak.service.utils.ObjectMapperUtils;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ObjectMapperUtils objectMapper;

	@Override
	public void addOrder(OrderDTO order) {
		Order orders = objectMapper.map(order, Order.class);
		orderRepository.save(orders);
	}

	@Override
	public void deleteOrder(Long id) {
		orderRepository.deleteById(id);
	}

	@Override
	public OrderDTO findOrderById(Long id) {
		Order order = orderRepository.findById(id).get();
		OrderDTO dto = objectMapper.map(order, OrderDTO.class);
		return dto;
	}

	@Override
	public List<OrderDTO> getAllOrders() {
		List<Order> orders = orderRepository.findAll();
		List<OrderDTO> orderDTOs = objectMapper.mapAll(orders, OrderDTO.class);
		return orderDTOs;

	}

}
