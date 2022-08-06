package com.hp.gekko.ordermanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hp.gekko.ordermanagement.entity.Order;

public interface OrderRepository extends JpaRepository<Order, String> {

	Optional<Order> findByOrderId(String string);

	void deleteByOrderId(String orderId);

	Order findByOrderInfoId(Long orderInfoId);

}
