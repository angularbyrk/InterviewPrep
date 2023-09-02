package com.maxil.ecommerce.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maxil.ecommerce.order.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
