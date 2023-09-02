package com.cenit.aopex.order.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.cenit.aopex.order.entity.Order;

@Aspect
@Component
public class OrderServiceAspect {

	@Before(value = "execution(* com.cenit.aopex.order.service.OrderService.saveOrder(..)) and args(order)")
	public void beforeAdvice(JoinPoint joinPoint, Order order) {
		System.out.println("Before method:" + joinPoint.getSignature());
		System.out.println("Creating order with name - " + order.getCustomerName() + " and id - " + order.getId());
	}
	
	@After(value = "execution(* com.cenit.aopex.order.service.OrderService.saveOrder(..)) and args(order)")
	public void afterSaveOrderAdvice(JoinPoint joinPoint, Order order) {
		System.out.println("after method:" + joinPoint.getSignature());
		System.out.println("Creating order with name - " + order.getCustomerName() + " and id - " + order.getId());
	}
	
	@Before(value = "execution(* com.cenit.aopex.order.service.OrderService.deleteOrder(..)) and args(orderId)")
	public void beforeDeleteAdvice(JoinPoint joinPoint, int orderId) {
		System.out.println("after method:" + joinPoint.getSignature());
		System.out.println("deleting order with id - " + orderId);
	}

	@After(value = "execution(* com.cenit.aopex.order.service.OrderService.deleteOrder(..)) and args(orderId)")
	public void afterDeleteAdvice(JoinPoint joinPoint, int orderId) {
		System.out.println("After method:" + joinPoint.getSignature());
		System.out.println("deleting order with id - " + orderId);
	}
}