package com.hp.gekko.ordermanagement.util;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderMockDto {

	 private  String id;
	 private LocalDateTime CreationDate;
	 private long amount;
	 private String productName;
	 
	
}
