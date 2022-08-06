package com.hp.gekko.ordermanagement.component;

import static org.mockito.Mockito.verify;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hp.gekko.ordermanagement.Dto.OrderDto;
import com.hp.gekko.ordermanagement.Dto.OrderResponse;
import com.hp.gekko.ordermanagement.entity.Customer;
import com.hp.gekko.ordermanagement.entity.Order;
import com.hp.gekko.ordermanagement.entity.Product;
import com.hp.gekko.ordermanagement.repository.CustomerRepository;
import com.hp.gekko.ordermanagement.repository.OrderRepository;
import com.hp.gekko.ordermanagement.service.OrderService;

@SpringBootTest

public class OrderServiceTest {

	private static final String orderId = "ORDERID12";

	@InjectMocks

	private OrderService service;
	@Mock
	private OrderRepository orderRepository;
	@Mock
	private CustomerRepository  customerRepository;

	@Test
	public void TestDeleteMethod() {
		Order order = new Order();
		order.setOrderId(orderId);
		Mockito.when(orderRepository.findByOrderId(Mockito.anyString())).thenReturn(Optional.ofNullable(null));
		String response = service.deleteOrder(orderId);
		Assertions.assertEquals("ORDERID12", orderId);

		Mockito.when(orderRepository.findByOrderId(Mockito.anyString())).thenReturn(Optional.ofNullable(order));
		String response1 = service.deleteOrder(orderId);
		Assertions.assertEquals("ORDERID12", orderId);
	}

	@Test

	public void testGetByOrderIdOrderWithInValidCase() throws ParseException {
		String temp = "25/07/2022";
		Date temp1 = new SimpleDateFormat("dd/MM/yyyy").parse(temp);

		Order order = new Order(1L, "1", "AB2", temp1, temp1, null, null);

		Mockito.when(orderRepository.findByOrderId(Mockito.anyString())).thenReturn(Optional.ofNullable(null));
		Order ordernew = service.getOrdersById(orderId);

		Assertions.assertNull(ordernew);

		Mockito.when(orderRepository.findByOrderId(Mockito.anyString())).thenReturn(Optional.ofNullable(order));
		Order response = service.getOrdersById(orderId);
		Assertions.assertNotNull(response);
	}

	@Test
	public void testInalidupdateOrder() throws ParseException {
		String temp = "25/07/2022";
		Date temp1 = new SimpleDateFormat("dd/MM/yyyy").parse(temp);

		Order order = new Order(1L, "1", "AB2", temp1, temp1, null, null);

		order.setCode("CODE12");
		order.setOrderId(orderId);
		order.setCreateDate(temp1);
		order.setUpdateDate(temp1);
		Mockito.when(orderRepository.findByOrderId(Mockito.anyString())).thenReturn(Optional.ofNullable(order));
		String response = service.updateOrder(order);
		Assertions.assertEquals("Order updated", response);

		Mockito.when(orderRepository.findByOrderId(Mockito.anyString())).thenReturn(Optional.ofNullable(null));
		String response1 = service.updateOrder(order);
		Assertions.assertEquals("Order not exist with this id:" + order.getOrderId(), response1);

		Mockito.doThrow(NullPointerException.class).when(orderRepository).findByOrderId(Mockito.anyString());
		service.updateOrder(order);
		Assertions.assertNotNull(order);

	}

	@Test
	public void testGetAllOrders() throws ParseException {

		Customer cust = Customer.builder().customerId(1L).build();
		List<Order> orderList = new ArrayList<>();
		Order order = Order.builder().orderId("orderId").code("code").customer(cust).build();
		orderList.add(order);
		Mockito.when(orderRepository.findAll()).thenReturn(orderList);
		OrderDto response = service.getAllOrders();
		Assertions.assertNotNull(response);
	}

	@Test
	public void testcreateOrder() throws ParseException, JsonProcessingException {
		String temp = "25/07/2022";
		Date temp1 = new SimpleDateFormat("dd/MM/yyyy").parse(temp);
	
		//Order order = Order.builder().code("as").orderId("1").customer(null).build();
		Customer customer = Customer.builder().userName("abc").build();
		ObjectMapper obj = new ObjectMapper();

		String cust = obj.writeValueAsString(customer);
		Order order = new Order(1L, "1", "AB2", temp1, temp1, null, customer);

		//Product prod = new Product(1L, "Pook", 22, 4.5, temp1, temp1, order);
		List<Product> prodList = new ArrayList<>();
		//prodList.add(prod);
		Mockito.when(orderRepository.findByOrderId(Mockito.anyString())).thenReturn(Optional.ofNullable(order));
		//service.saveCustosaveOrder(order);
		Mockito.when(customerRepository.findByUserName(Mockito.anyString())).thenReturn(Optional.ofNullable(customer));
		
		//.saveCustosaveOrder(order);
		
		Assertions.assertNotNull(order);

	}

}
