package com.hp.gekko.ordermanagement.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hp.gekko.ordermanagement.Dto.ProductDto;
import com.hp.gekko.ordermanagement.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;

	@PostMapping("/addProduct")
	public ResponseEntity<Object> addProduct(@RequestBody ProductDto product) {
		try {
			service.saveProduct(product);
			return new ResponseEntity<Object>("Product added", HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<Object>("Product failed", HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping(value = "/get-product-by-id/{productId}")
	public ResponseEntity<Object> getOrderPathVar(@PathVariable Long productId) {

		ProductDto product = service.getByProductId(productId);
		try {

			if (product != null)
				return new ResponseEntity<>(product, HttpStatus.OK);
		}

		catch (Exception ex) {
			ex.printStackTrace();

		}
		return new ResponseEntity<Object>(" Product details Not Found for this order id: :" + productId,
				HttpStatus.NOT_FOUND);
	}
}
