package com.bhavna.order.api.service;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhavna.order.api.model.Order;
import com.bhavna.order.api.model.Product;
import com.bhavna.order.api.repository.OrderRepository;
import com.bhavna.order.api.repository.ProductRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repo;

	@Autowired
	private ProductRepository prodRepo;

	public List<Order> getAllOrders() {

		return repo.findAll();

	}

	public Order addOrder(Order order) throws IOException {

		Optional<Order> var = repo.findById(order.getOrderId());
		if (var.isPresent()) {

			throw new IOException("order ALREADY EXIST");
		} else {

			order.setOrderPrice(order.getQuantity() * prodRepo.getById(order.getProdId().getProdId()).getPrice());
			return repo.save(order);

		}

	}

//	public List<Order> getOrderById(String category) {
//		return repo.getOrderByCategory(category);
//	}
//
//	public String deleteByCategory(String category) {
//		repo.deleteByCategory(category);
//		return "order record deleted " + category ;
//	}

	public Order getOrderByOrderId(int orderId) {
		return repo.findById(orderId).orElseThrow();

	}

	public String deleteByOrderId(int orderId) {
		repo.deleteById(orderId);
		return "order deleted " + orderId;
	}

	public String updateOrder(Order order) {

		order.setOrderPrice(order.getQuantity() * prodRepo.getById(order.getProdId().getProdId()).getPrice());
		repo.save(order);
		System.out.println(order);

		return "updated successfully " + order.getOrderId();

	}

	public void patchOrderById(Integer orderId, Integer prodId, Integer quantity, String address) {
		Order order = repo.findById(orderId).get();
		if (quantity != null)
			order.setQuantity(quantity);
		if (prodId != null)
			order.setProdId(prodRepo.findById(prodId).get());
		order.setOrderPrice(order.getQuantity() * prodRepo.getById(prodId).getPrice());
		if (address != null)
			order.setAddress(address);
		repo.save(order);
	}

}
