package com.hp.gekko.ordermanagement.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressRequest {

	private String address_type;
	private String streetName;
	private String landmark;
	private String city;
	private String state;
	private String pincode;

}