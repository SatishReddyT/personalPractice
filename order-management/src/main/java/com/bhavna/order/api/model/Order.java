package com.bhavna.order.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDERS")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ORDERID")
	private int orderId;

//	@Column(name = "CATEGORY")
//	private String category;

	@Column(name = "PRODID")
	private int prodId;

	@Column(name = "QUANTITY")
	private int quantity;

	@Column(name = "ORDERPRICE")
	private int orderPrice;

	@Column(name = "ADDRESS")
	private String address;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

//	public String getCategory() {
//		return category;
//	}
//
//	public void setCategory(String category) {
//		this.category = category;
//	}

	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Order() {
		super();
	}

	public Order(int orderId, int prodId, int quantity, int orderPrice, String address) {
		super();
		this.orderId = orderId;
		this.prodId = prodId;
		this.quantity = quantity;
		this.orderPrice = orderPrice;
		this.address = address;
	}

	public Order updateWith(Order order) {
		return new Order(this.orderId, order.prodId, order.quantity, order.orderPrice, order.address);
	}

}
