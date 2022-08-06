package com.hp.gekko.ordermanagement.Dto;

import java.util.Date;
import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderDtoRequest {
	private String orderId;
	private String code;

	

	private List<ProductDto> productDto;
	
	
	
	private CustomerRequest customerRequest;
	
	//private CustomerDto customer;

}
