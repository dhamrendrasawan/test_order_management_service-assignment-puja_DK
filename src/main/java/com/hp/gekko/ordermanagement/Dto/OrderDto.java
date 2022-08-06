package com.hp.gekko.ordermanagement.Dto;

import java.util.List;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderDto {
	private List<OrderResponse> orders;

}
