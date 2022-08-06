package com.hp.gekko.ordermanagement.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AddressDto {
	//private Long addressId;
	private String address_type;
	private String streetName;
	private String landmark;
	private String city;
	private String state;
	private String pincode;

}
