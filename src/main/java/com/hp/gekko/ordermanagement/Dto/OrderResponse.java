package com.hp.gekko.ordermanagement.Dto;

import java.util.Date;

import com.hp.gekko.ordermanagement.entity.Customer;

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

public class OrderResponse {

	private String orderId;

	private String code;

	private Date createDate;

	private Date updateDate;

	private String userName;

	private Customer customerId;

}
