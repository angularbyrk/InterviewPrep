package com.maxil.ecommerce.order;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.maxil.ecommerce.order.entity.Order;
import com.maxil.ecommerce.order.service.OrderService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private OrderService orderService;

	@Test
	public void getAllOrders() throws Exception {

		Order o1 = new Order(1, "c1", 99.0);
		Order o2 = new Order(2, "c2", 9.16);
		when(orderService.getAllOrders()).thenReturn(Stream.of(o1, o2).toList());

		this.mockMvc.perform(get("/orders").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].customerName", is(o1.getCustomerName())));
	}

	@Test
	public void save() throws Exception {
		Order o1 = new Order(1, "c1", 99.0);
		when(orderService.saveOrder(any())).thenReturn(o1);

		this.mockMvc.perform(post("/orders").contentType(MediaType.APPLICATION_JSON).content(JsonUtil.toJson(o1)))
				.andExpect(status().isCreated()).andExpect(jsonPath("$.customerName", is("c1")));
		verify(orderService, VerificationModeFactory.times(1)).saveOrder(Mockito.any());
		reset(orderService);
	}

}
