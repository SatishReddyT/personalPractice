package com.bhavna.order.api.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bhavna.order.api.model.Order;
import com.bhavna.order.api.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	OrderService service;

	@GetMapping(path = "/getAllOrders")
	public List<Order> getAllorders() {
		return service.getAllOrders();
	}

	@PostMapping(path = "/addOrder")
	public Order addEmployee(@RequestBody Order order) throws IOException {

		return service.addOrder(order);
	}

	@GetMapping(path = "/getOrderByCategory/{category}")
	public List<Order> getOrerByCategoy(@PathVariable("category") String category) {
		return service.getOrderByCategory(category);
	}

	@DeleteMapping(path = "/deleteByCategory/{category}")
	public void deleteOrderByCategory(@PathVariable("category") String category) {
		service.deleteByCategory(category);
	}

	@PutMapping(path = "/updateOrderByCategory/{orderId}")
	public void updateOrder(@PathVariable("orderId") int orderId, @RequestBody Order order) {
		service.updateOrder(orderId, order);
	}
	
}
