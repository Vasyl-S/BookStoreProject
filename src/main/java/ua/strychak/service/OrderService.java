package ua.strychak.service;

import java.util.List;

import ua.strychak.domain.OrderDTO;

public interface OrderService {
	
	void addOrder(OrderDTO order);
		
	void deleteOrder(Long id);
	
	OrderDTO findOrderById(Long id);
	
	List<OrderDTO> getAllOrders();
	

}
