package com.cenit.aopex.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cenit.aopex.order.entity.Order;
import com.cenit.aopex.order.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping
	public ResponseEntity saveOrder(@RequestBody Order order) {
		return ResponseEntity.status(HttpStatus.CREATED).body(orderService.saveOrder(order));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity deleteOrder(@PathVariable int id) {
		orderService.deleteOrder(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
