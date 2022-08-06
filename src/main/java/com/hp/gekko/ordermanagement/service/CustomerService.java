package com.hp.gekko.ordermanagement.service;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import com.hp.gekko.ordermanagement.Dto.CustomerRequest;
import com.hp.gekko.ordermanagement.Dto.CustomerResponse;
import com.hp.gekko.ordermanagement.entity.Customer;

public interface CustomerService {

	String deleteById(Long custmerId);

	String updateOrder(CustomerResponse customerResponse);

	Optional<Customer> getById(@NotNull Long custmerId);

	Customer createCustomer(CustomerRequest customerRequestDTO);

}
