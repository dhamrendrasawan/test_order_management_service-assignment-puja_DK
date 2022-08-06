package com.hp.gekko.ordermanagement.Dto;

import java.util.Date;
import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class OrderRequest {

	

	private String code;
	
	

	private String orderId;
private List<ProductDto> product;
}


	
	


