package com.bhavna.order.api.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhavna.order.api.model.Order;
import com.bhavna.order.api.model.Product;
import com.bhavna.order.api.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repo;

	public List<Order> getAllOrders() {

		return repo.findAll();

	}

	public Order addOrder(Order order) throws IOException {

		Optional<Order> var = repo.findById(order.getOrderId());
		if (var.isPresent()) {

			throw new IOException("order ALREADY EXIST");
		} else {

			order.setOrderPrice(order.getQuantity() * repo.getProdPrice(order.getProdId()));
			return repo.save(order);

		}

	}

	public List<Order> getOrderByCategory(String category) {
		return repo.getOrderByCategory(category);
	}

	public void deleteByCategory(String category) {
		repo.deleteByCategory(category);
		System.out.println("order record deleted " + category);
	}

	public Optional<Order> updateOrder(int orderId, Order order) {

		return repo.findById(orderId).map(oldOrder -> {
			Order updated = oldOrder.updateWith(order);
			updated.setOrderPrice(updated.getQuantity() * repo.getProdPrice(updated.getProdId()));
			return repo.save(updated);
		});
	}


}
