package com.sylleryum.order.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Entity
public class ItemDAO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String itemNumber;
	@ManyToOne
	@JoinColumn(name = "order_id")
	@JsonBackReference
	private OrderDAO order;
	private long quantity;

	public ItemDAO(String itemNumber, OrderDAO order, long quantity) {
		super();
		this.itemNumber = itemNumber;
		this.order = order;
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(String itemNumber) {
		this.itemNumber = itemNumber;
	}

	public OrderDAO getOrder() {
		return order;
	}

	public void setOrder(OrderDAO order) {
		this.order = order;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

}
