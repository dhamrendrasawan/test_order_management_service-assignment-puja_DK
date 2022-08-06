package com.hp.gekko.ordermanagement.component;

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

import com.hp.gekko.ordermanagement.Dto.ProductDto;
import com.hp.gekko.ordermanagement.entity.Product;
import com.hp.gekko.ordermanagement.rest.ProductController;
import com.hp.gekko.ordermanagement.service.ProductService;
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {
	
	
	
	

		private final Long productId = 1L;

		@InjectMocks
		@Spy
		private ProductController productController;

		@Mock
		ProductService service;
		
		@Mock
		ProductDto productDto;
		
		@Test
		public void testByIdInValidProduct() {
			//ProductDto prodDto = ProductDto.builder().price((double) 1L).name("poo").quantity(1).build();
			
		//	Mockito.when(service.getByProductId(productId)).thenReturn(prodDto);
			ResponseEntity<Object> response = productController.getOrderPathVar(productId);
			Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
			
			Mockito.when(service.getByProductId(productId)).thenReturn(null);
			ResponseEntity<Object> response1 = productController.getOrderPathVar(productId);
			Assert.assertEquals(HttpStatus.NOT_FOUND, response1.getStatusCode());
			
			 Mockito.doThrow(NullPointerException.class).when(service).getByProductId(productId);
			 ResponseEntity<Object> response2 = productController.getOrderPathVar(productId);
		   //  Assertions.assertNull(prodDto);
		    
			
			
			
			
			
			
		}

	
		
		

	}

