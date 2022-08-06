package com.hp.gekko.ordermanagement.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hp.gekko.ordermanagement.Dto.CustomerRequest;
import com.hp.gekko.ordermanagement.Dto.CustomerResponse;
import com.hp.gekko.ordermanagement.entity.Customer;
import com.hp.gekko.ordermanagement.service.CustomerServiceImpl;

/**
 * @author GorakhAb
 *
 */

@RestController
@RequestMapping(value = "/customer-service")
@Validated
public class CustomerController {

	@Autowired
	CustomerServiceImpl customerServiceImpl;

	@GetMapping(path = "/customer/{custmerId}")
	public Optional<Customer> getCustomerById(@PathVariable @NotNull Long custmerId) {
		return (customerServiceImpl.getById(custmerId));
	}

	/**
	 * @param customerRequestDTO
	 * @return
	 */
	@PostMapping(path = "/createCustomer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<Customer> createCustomer(@RequestBody CustomerRequest customerRequestDTO) {
		return new ResponseEntity<>(customerServiceImpl.createCustomer(customerRequestDTO), HttpStatus.CREATED);

	}

	@PutMapping(path = "/updateCustomer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateOrders(@RequestBody CustomerResponse customerResponse) {

		return new ResponseEntity<String>(customerServiceImpl.updateOrder(customerResponse), HttpStatus.CREATED);
	}

	@DeleteMapping(path = "/delete/{custmerId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable Long custmerId) {

		return new ResponseEntity<>(customerServiceImpl.deleteById(custmerId), HttpStatus.OK);
	}

	@GetMapping(path = "/GetAll")
	public List<Customer> getAllCustomer() {
		return customerServiceImpl.getAllCustomers();
	}
}
