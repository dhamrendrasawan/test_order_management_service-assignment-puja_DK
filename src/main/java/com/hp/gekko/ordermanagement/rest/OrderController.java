package com.hp.gekko.ordermanagement.rest;

/**
 * @author KumthekP
 */

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hp.gekko.ordermanagement.Dto.CustomerRequest;
import com.hp.gekko.ordermanagement.Dto.OrderDto;
import com.hp.gekko.ordermanagement.Dto.OrderDtoRequest;
import com.hp.gekko.ordermanagement.entity.Customer;
import com.hp.gekko.ordermanagement.entity.Order;
import com.hp.gekko.ordermanagement.service.OrderService;

@RestController
@RequestMapping("/api/orders")

public class OrderController {

	@Autowired
	private OrderService orderService;

	/**
	 * For Get Method
	 * 
	 * @return
	 */
	@GetMapping(value = "/orders")
	public OrderDto getAllOrders() {
		return orderService.getAllOrders();
	}

	/**
	 * For GetById Method
	 * 
	 * @param orderId
	 * @returnggg
	 */

	@GetMapping(value = "/get-order-by-id/{orderId}")
	public ResponseEntity<Object> getOrderPathVar(@PathVariable String orderId) {
		Order order = orderService.getOrdersById(orderId);
		if (order == null) {
			return new ResponseEntity<>(" Order details Not Found for this order id: :" + orderId,
					HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(order, HttpStatus.OK);
		}
	}

	/**
	 * For Post Method
	 * 
	 * @param order
	 * @return
	 */
	@PostMapping("/saveorders")
	private ResponseEntity<Order> saveOrder(@RequestBody OrderDtoRequest orderDtoRequest) {
		return new ResponseEntity<>(orderService.createOrder(orderDtoRequest), HttpStatus.CREATED);
	}
		

	/**
	 * For Delete Method
	 * 
	 * @param orderId
	 * @return
	 */

	@PutMapping(value = "/update-orders")
	public ResponseEntity<String> updateOrders(@RequestBody Order order) {
		return new ResponseEntity<>(orderService.updateOrder(order), HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/delete")
	public ResponseEntity<String> deleteOdeleteOrderrder(@RequestParam("orderId") String orderId) {
		return new ResponseEntity<>(orderService.deleteOrder(orderId), HttpStatus.OK);
	}

}
