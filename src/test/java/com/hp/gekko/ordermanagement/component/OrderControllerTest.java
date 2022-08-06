package com.hp.gekko.ordermanagement.component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hp.gekko.ordermanagement.Dto.OrderDto;
import com.hp.gekko.ordermanagement.Dto.OrderResponse;
import com.hp.gekko.ordermanagement.entity.Order;
import com.hp.gekko.ordermanagement.repository.OrderRepository;
import com.hp.gekko.ordermanagement.rest.OrderController;
import com.hp.gekko.ordermanagement.service.OrderService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class OrderControllerTest {

	private static final String orderId = "ORDERID12";

	@InjectMocks
	@Spy
	private OrderController orderController;

	@Mock
	OrderService orderService;
	@Mock
	OrderDto orderdto;
	@Mock
	OrderRepository orderRepository;

	@Test
	public void testGetAll() throws ParseException, JsonProcessingException {

		String temp = "25/07/2022";
		Date temp1 = new SimpleDateFormat("dd/MM/yyyy").parse(temp);

		OrderResponse orderResponse = new OrderResponse("1", "AB2", temp1, temp1, null, null);
		List<OrderResponse> orderList = new ArrayList<>();
		orderList.add(orderResponse);
		OrderDto orderDto = new OrderDto(orderList);

		Mockito.when(orderService.getAllOrders()).thenReturn(orderDto);

		OrderDto orderDto1 = orderController.getAllOrders();
		Assert.assertNotNull(orderDto1);
	}

	@Test
	public void testByIdInValid() throws ParseException {

		Mockito.when(orderService.getOrdersById(orderId)).thenReturn(null);
		ResponseEntity<Object> res = orderController.getOrderPathVar(orderId);
		Assert.assertEquals(HttpStatus.NOT_FOUND, res.getStatusCode());
	}

	@Test
	public void testByIdValid() throws ParseException {

		String temp = "25/07/2022";
		Date temp1 = new SimpleDateFormat("dd/MM/yyyy").parse(temp);

		Order order = new Order(1L, "1", "AB2", temp1, temp1, null, null);

		Mockito.when(orderService.getOrdersById(Mockito.anyString())).thenReturn(order);
		ResponseEntity<Object> res = orderController.getOrderPathVar(orderId);
		Assert.assertEquals(HttpStatus.OK, res.getStatusCode());
	}

	@Test
	public void testvalidUpdate() throws ParseException, JsonProcessingException {

		String temp = "25/07/2022";
		Date temp1 = new SimpleDateFormat("dd/MM/yyyy").parse(temp);

		Order order = new Order(1L, "1", "AB2", temp1, temp1, null, null);
		ObjectMapper obj = new ObjectMapper();

		String ord = obj.writeValueAsString(order);
		Mockito.when(orderService.updateOrder(order)).thenReturn("Order updated");
		ResponseEntity<String> response = orderController.updateOrders(order);
		Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());

		Mockito.when(orderService.updateOrder(order)).thenReturn("order details not exist:  order id:" + orderId);
		ResponseEntity<String> response1 = orderController.updateOrders(order);
		Assertions.assertEquals(HttpStatus.CREATED, response1.getStatusCode());

	}

	@Test
	public void TestDeleteOrder() throws ParseException, JsonProcessingException {

		Mockito.when(orderService.deleteOrder(orderId)).thenReturn("order deleted successfully order id:" + orderId);
		ResponseEntity<String> response = orderController.deleteOdeleteOrderrder(orderId);
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());

		Mockito.when(orderService.deleteOrder(orderId)).thenReturn("order details not exist:  order id:" + orderId);
		ResponseEntity<String> response1 = orderController.deleteOdeleteOrderrder(orderId);
		Assertions.assertEquals(HttpStatus.OK, response1.getStatusCode());
	}

}
