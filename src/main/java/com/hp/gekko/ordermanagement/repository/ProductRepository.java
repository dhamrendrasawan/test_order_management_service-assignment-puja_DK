package com.hp.gekko.ordermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hp.gekko.ordermanagement.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	Product findByName(String name);

	Product findByProductId(Long productId);

}
