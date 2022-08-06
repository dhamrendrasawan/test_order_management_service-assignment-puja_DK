package com.hp.gekko.ordermanagement.Dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse {
	private Long customerId;

	private String emailId;

	private String firstName;

	private String lastName;

	private String mobileNumber;

	private List<AddressDto> addresses;

}
