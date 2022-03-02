package com.bhavna.order.api.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
//
//	@GetMapping(path = "/getOrderByCategory/{category}")
//	public List<Order> getOrerByCategoy(@PathVariable("category") String category) {
//		return service.getOrderByCategory(category);
//	}
//
//	@DeleteMapping(path = "/deleteByCategory/{category}")
//	public String deleteOrderByCategory(@PathVariable("category") String category) {
//		return service.deleteByCategory(category);
//	}
	
	@GetMapping(path = "/getOrderById/{orderId}")
	public Order getOrderById(@PathVariable("orderId") int orderId) {
		return service.getOrderByOrderId(orderId);
	}
	
	@DeleteMapping(path = "/deleteOrderById/{orderId}")
	public String deleteOrderById(@PathVariable("orderId") int orderId) {
	return service.deleteByOrderId(orderId);
	}

	@PutMapping(path = "/updateOrder")
	public String updateOrder(  @RequestBody Order order) {
		return service.updateOrder( order);
	}

	@PatchMapping(path = "/patchByOrderId/{orderId}")
	public void PatchByOrderId(@PathVariable("orderId") Integer orderId,
			@RequestParam(name = "prodId", required = false) Integer prodId,
			@RequestParam(name = "quantity", required = false) Integer quantity,
			@RequestParam(name = "address", required = false) String address) {
		service.patchOrderById(orderId, prodId, quantity, address);
	}

}
