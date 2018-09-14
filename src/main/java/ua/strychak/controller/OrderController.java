package ua.strychak.controller;

import java.util.List;

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

import ua.strychak.domain.OrderDTO;
import ua.strychak.service.OrderService;

@RestController
@RequestMapping("orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	
	@PostMapping
	public ResponseEntity<Void> saveOrder(OrderDTO order){
		orderService.addOrder(order);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	
	
	@GetMapping("{orderId}")
	public ResponseEntity<OrderDTO> getOrder(@PathVariable("orderId") Long id){
		OrderDTO orderDTO = orderService.findOrderById(id);
		return new ResponseEntity<>(orderDTO , HttpStatus.OK);
}
	
	@GetMapping
	public ResponseEntity<List<OrderDTO>> getOrders() {
		List<OrderDTO> orderDTOs = orderService.getAllOrders();
		return new ResponseEntity<List<OrderDTO>>(orderDTOs, HttpStatus.OK);
	}
	
	
	
	@PutMapping("{orderId}")
	public ResponseEntity<Void> update(@PathVariable("orderId") Long id, @RequestBody OrderDTO orderDTO) {
		OrderDTO order = orderService.findOrderById(id);
		if (order != null) {
			order.setId(id);
			orderService.addOrder(order);
			return new ResponseEntity<Void>(HttpStatus.OK);

		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

	}
	
	
	@DeleteMapping("/{orderId}")
	public ResponseEntity<Void> deleteOrder(@PathVariable("orderId") Long id) {
		OrderDTO order = orderService.findOrderById(id);
		if (order != null) {
			orderService.deleteOrder(order.getId());
			return new ResponseEntity<Void>(HttpStatus.OK);
		}

		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	
	
	
	
	
	
}
