package com.maxil.ecommerce.order;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.maxil.ecommerce.order.controller.OrderController;
import com.maxil.ecommerce.order.entity.Order;
import com.maxil.ecommerce.order.service.OrderService;

@RunWith(SpringRunner.class)
@WebMvcTest(OrderController.class)
public class OrderControllTestS {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    OrderService orderService;

    @Test
    public  void getAllOrders() throws Exception {

        Order o1 = new Order(1,"c1",100.00);

        when(orderService.getAllOrders()).thenReturn(Stream.of(o1).toList());

        mockMvc.perform( get("/orders").contentType(MediaType.APPLICATION_JSON) ).andExpect( jsonPath("$[0].customerName" , is(o1.getCustomerName())));

    }

}
