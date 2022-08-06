package com.hp.gekko.ordermanagement.Dto;

import java.util.List;
import java.util.Set;

import com.hp.gekko.ordermanagement.entity.Address;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {

	private String userName;

	private String emailId;

	private String firstName;

	private String lastName;

	private String mobileNumber;

	private List<AddressRequest> addresses;
	
	//private OrderRequest orderReuquest;

}
