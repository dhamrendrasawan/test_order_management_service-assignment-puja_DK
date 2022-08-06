package com.hp.gekko.ordermanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hp.gekko.ordermanagement.Dto.ProductDto;
import com.hp.gekko.ordermanagement.entity.Order;
import com.hp.gekko.ordermanagement.entity.Product;
import com.hp.gekko.ordermanagement.repository.OrderRepository;
import com.hp.gekko.ordermanagement.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	@Autowired
	OrderRepository orderRepository;

	public void saveProduct(ProductDto productdDto) {

		Order order = orderRepository.findByOrderInfoId(1L);

		Product product = Product.builder().name(productdDto.getName()).price(productdDto.getPrice())
				.quantity(productdDto.getQuantity()).order(order).build();

		productRepository.save(product);
	}

	public ProductDto getByProductId(Long productId) {

		Product product = productRepository.findByProductId(productId);
		ProductDto prodDto = ProductDto.builder().name(product.getName()).price(product.getPrice())
				.quantity(product.getQuantity()).build();

		return prodDto;
	}

}