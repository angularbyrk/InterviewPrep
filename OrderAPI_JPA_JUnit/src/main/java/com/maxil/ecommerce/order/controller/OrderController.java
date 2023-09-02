package com.maxil.ecommerce.order.controller;

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

import com.maxil.ecommerce.order.entity.Order;
import com.maxil.ecommerce.order.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity getAllOrders() {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity getOrderById(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getOrderById(id));
    }

    @PostMapping
    public ResponseEntity saveOrder(@RequestBody Order order) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.saveOrder(order));
    }

    @PutMapping
    public ResponseEntity updateOrder(@RequestBody Order order) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.updateOrder(order));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOrder(@PathVariable int id) {
        orderService.deleteOrder(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}