package com.cenit.aopex.order.entity;

public class Order {
	private int id;
	private String customerName;
	private Double price;

	public Order() {

	}

	public Order(int id, String customerName, Double price) {
		this.id = id;
		this.customerName = customerName;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}