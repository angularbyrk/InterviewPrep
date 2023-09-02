package com.cenit.aopex.order.service;

import org.springframework.stereotype.Service;

import com.cenit.aopex.order.entity.Order;

@Service
public class OrderService {

    public Order saveOrder(Order order) {
        return order;
    }
    public void deleteOrder(int id) {
    }

}