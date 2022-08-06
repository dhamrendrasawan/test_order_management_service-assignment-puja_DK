package com.hp.gekko.ordermanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.hp.gekko.ordermanagement.Dto.CustomerRequest;
import com.hp.gekko.ordermanagement.Dto.OrderDto;
import com.hp.gekko.ordermanagement.Dto.OrderDtoRequest;
import com.hp.gekko.ordermanagement.Dto.OrderResponse;
import com.hp.gekko.ordermanagement.Dto.ProductDto;
import com.hp.gekko.ordermanagement.entity.Address;
import com.hp.gekko.ordermanagement.entity.Customer;
import com.hp.gekko.ordermanagement.entity.Order;
import com.hp.gekko.ordermanagement.entity.Product;
import com.hp.gekko.ordermanagement.exceptions.ErrorCategory;
import com.hp.gekko.ordermanagement.repository.CustomerRepository;
import com.hp.gekko.ordermanagement.repository.OrderRepository;
import com.hp.gekko.ordermanagement.repository.ProductRepository;
import com.hp.gekko.ordermanagement.util.ValidationUtils;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private CustomerRepository customerRepository;

	/**
	 * This method is used to get all order details
	 * 
	 */

	public OrderDto getAllOrders() {
		List<Order> order = orderRepository.findAll();
		return convertEntityToDto(order);
	}

	private OrderDto convertEntityToDto(List<Order> order) {
		List<OrderResponse> ordResp = new ArrayList<>();

		OrderResponse ordResponse = null;
		for (Order ord : order) {
			ordResponse = OrderResponse.builder().orderId(ord.getOrderId()).code(ord.getCode())
					.createDate(ord.getCreateDate()).updateDate(ord.getUpdateDate()).customerId(ord.getCustomer())
					.build();
			ordResp.add(ordResponse);

		}

		return OrderDto.builder().orders(ordResp).build();
	}

	/**
	 * This method is use to get order details according to orderId
	 * 
	 * @param orderId
	 * 
	 */

	public Order getOrdersById(String orderId) {

		Optional<Order> orderInfoOptional = orderRepository.findByOrderId(orderId);
		if (orderInfoOptional.isPresent()) {
			return (orderInfoOptional.get());
		} else {
			return null;
		}
	}

	public Order createOrder(OrderDtoRequest orderDtoRequest) {

		try {
			Order order = OrderDtoRequestToOrder(orderDtoRequest);
			Optional<Order> orderOptional = orderRepository.findByOrderId(order.getOrderId());
			if (orderOptional.isPresent()) {

				return orderOptional.get();
			} else {
				orderRepository.save(order);
				return order;

			}
		} catch (Exception exp) {

			return null;
		}

	}
	
	public Customer saveCustomer(Customer cust)
	{
		Optional<Customer> customerOptional = customerRepository.findByUserName(cust.getUserName());
		if(customerOptional.isPresent())
		{
			return customerOptional.get();
		}
		else 
		cust = customerRepository. save(cust);
		return cust;
		
	}
	

	private Order OrderDtoRequestToOrder(OrderDtoRequest orderDtoRequest) {
		Order order = new Order();
		order.setCode(orderDtoRequest.getCode());
		order.setOrderId(orderDtoRequest.getOrderId());
		
		CustomerRequest customerRequest = orderDtoRequest.getCustomerRequest();
		
		Customer cust = Customer.builder().emailId(customerRequest.getEmailId())
				.firstName(customerRequest.getFirstName()).lastName(customerRequest.getLastName())
				.mobileNumber(customerRequest.getMobileNumber()).userName(customerRequest.getUserName()).build();
		Customer customer = saveCustomer(cust);
		order.setCustomer(customer);
		
		cust.setOrder(order);

		List<Product> product = orderDtoRequest.getProductDto().stream().map(pr -> {
			Product product1 = Product.builder().name(pr.getName()).price(pr.getPrice()).quantity(pr.getQuantity())
					.build();
			return product1;
		}).collect(Collectors.toList());
		order.setProduct(product);
		return order;

	}

	public String updateOrder(Order order) {

		try {
			Optional<Order> orderOptional = orderRepository.findByOrderId(order.getOrderId());
			if (orderOptional.isPresent()) {
				Order order1 = orderOptional.get();
				order1.setCode(order.getCode());
				orderRepository.save(order1);
				return "Order updated";
			} else {
				return "Order not exist with this id:" + order.getOrderId();
			}
		} catch (Exception exp) {

			return "Exceptionally failed " + exp.getMessage();
		}
	}

	/**
	 * This method is use to delete the record from table
	 * 
	 * @param orderId
	 * 
	 */

	@Transactional
	@Modifying
	public String deleteOrder(String orderId) {
		Optional<Order> orderOptional = orderRepository.findByOrderId(orderId);
		if (orderOptional.isPresent()) {
			orderRepository.deleteByOrderId(orderId);
			return "order deleted successfully order id:" + orderId;
		} else {
			return "order details not exist:  order id:" + orderId;
		}
	}

}
