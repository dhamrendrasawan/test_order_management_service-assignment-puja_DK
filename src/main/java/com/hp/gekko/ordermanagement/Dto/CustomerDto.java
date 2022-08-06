package com.hp.gekko.ordermanagement.Dto;

import java.util.List;

import com.hp.gekko.ordermanagement.entity.Customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CustomerDto {
	private Long customerId;
	private String userName;
	
	private List<Customer> customers;
	}


