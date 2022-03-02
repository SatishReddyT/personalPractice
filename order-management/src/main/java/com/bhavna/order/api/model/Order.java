package com.bhavna.order.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "ORDERS")
public class Order {

	@Id
	@Column(name = "ORDERID")
	private int orderId;

	@ManyToOne
	@JoinColumn(name = "PRODID")
	private Product prodId;

	
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

	public Product getProdId() {
		return prodId;
	}

	public void setProdId(Product prodId) {
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

	public Order(int orderId, Product prodId, int quantity, int orderPrice, String address) {
		super();
		this.orderId = orderId;
		this.prodId = prodId;
		this.quantity = quantity;
		this.orderPrice = orderPrice;
		this.address = address;
	}

}
