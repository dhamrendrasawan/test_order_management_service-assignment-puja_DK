package com.hp.gekko.ordermanagement.Dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class ProductDto {

	private String name;
	private Long quantity;
	private BigDecimal price;

}
