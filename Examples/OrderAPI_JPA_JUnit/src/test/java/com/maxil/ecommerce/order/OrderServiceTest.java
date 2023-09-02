package com.maxil.ecommerce.order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.maxil.ecommerce.order.entity.Order;
import com.maxil.ecommerce.order.repository.OrderRepository;
import com.maxil.ecommerce.order.service.OrderService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class OrderServiceTest {

	@Autowired
	OrderService orderService;
	@MockBean
	OrderRepository orderRepository;

	@Test
	public void getAllOrdersTest() {
		Order o1 = new Order(1, "c1", 99.0);
		Order o2 = new Order(2, "c2", 9.16);
		when(orderRepository.findAll()).thenReturn(new ArrayList<>()).thenReturn(Stream.of(o1, o2).toList());
		assertEquals(orderService.getAllOrders().size(), 0);
		assertEquals(orderService.getAllOrders().size(), 2);
	}

	@Test
	public void getOrderByIdTest() {
		Order o1 = new Order(1, "c1", 99.0);
		when(orderRepository.findById(Mockito.any())).thenReturn(Optional.of(o1)).thenReturn(Optional.empty());
		assertEquals(orderService.getOrderById(1).get().getId(), 1);
		assertEquals(orderService.getOrderById(2), Optional.empty());
	}

	@Test
	public void saveOrderTest() {
		Order o1 = new Order(1, "c1", 99.0);
		when(orderRepository.save(o1)).thenReturn(o1);
		assertEquals(orderService.saveOrder(o1).getId(), 1);
	}

	@Test
	public void updateOrderTest() {
		Order o1 = new Order(1, "c1", 99.0);
		when(orderRepository.save(o1)).thenReturn(o1);
		assertEquals(orderService.updateOrder(o1).getId(), 1);
	}

	@Test
	public void deleteOrderTest() {
		doNothing().when(orderRepository).deleteById(1);
		orderService.deleteOrder(1);
		verify(orderRepository, times(1)).deleteById(1);

	}

}
