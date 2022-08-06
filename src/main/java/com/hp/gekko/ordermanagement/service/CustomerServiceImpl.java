package com.hp.gekko.ordermanagement.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.hp.gekko.ordermanagement.Dto.CustomerRequest;
import com.hp.gekko.ordermanagement.Dto.CustomerResponse;
import com.hp.gekko.ordermanagement.entity.Address;
import com.hp.gekko.ordermanagement.entity.Customer;
import com.hp.gekko.ordermanagement.exceptions.ErrorCategory;
import com.hp.gekko.ordermanagement.repository.CustomerRepository;
import com.hp.gekko.ordermanagement.repository.OrderRepository;
import com.hp.gekko.ordermanagement.util.ValidationUtils;

@Service
public class CustomerServiceImpl implements CustomerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	OrderRepository orderRepository;

	@Override
	public Customer createCustomer(CustomerRequest customerRequestDTO) {

		LOGGER.info("Create Customer method started");
		try {
			Customer customer = CustomerRequestToCustomer(customerRequestDTO);
			Optional<Customer> customerOptional = customerRepository.findByEmailId(customer.getEmailId());
			if (customerOptional.isPresent()) {

				LOGGER.info("Customer already exist and customer id is:", customerOptional.get().getEmailId());
				ValidationUtils.getValidationError(ErrorCategory.ER0005, CustomerServiceImpl.class.getName());
				return customerOptional.get();
			} else {
				customerRepository.save(customer);
				return customer;

			}
		} catch (Exception exp) {
			LOGGER.error(exp.getMessage());
			ValidationUtils.getValidationError(ErrorCategory.ER0006, CustomerServiceImpl.class.getName());
			return null;
		}

	}

	private Customer CustomerRequestToCustomer(CustomerRequest customerRequestDTO) {
		Customer customer = new Customer();
		customer.setUserName(customerRequestDTO.getUserName());
		customer.setEmailId(customerRequestDTO.getEmailId());
		customer.setMobileNumber(customerRequestDTO.getMobileNumber());
		customer.setFirstName(customerRequestDTO.getFirstName());
		customer.setLastName(customerRequestDTO.getLastName());

		List<Address> addresses = customerRequestDTO.getAddresses().stream().map(arg -> {
			Address address = new Address();

			address.setAddress_type(arg.getAddress_type());
			address.setCity(arg.getCity());
			address.setLandmark(arg.getLandmark());
			address.setPincode(arg.getPincode());
			address.setState(arg.getState());
			address.setStreetName(arg.getStreetName());

			address.setCustomer(customer);
			return address;
		}).collect(Collectors.toList());

		customer.setAddresses(addresses);

		return customer;
	}

	public String updateOrder(CustomerResponse customerResponse) {
		LOGGER.info("update Customer method started");
		try {
			Optional<Customer> customerOptional = customerRepository.findById(customerResponse.getCustomerId());
			if (customerOptional.isPresent()) {
				Customer customerupdate = customerOptional.get();
				customerupdate.setFirstName(customerResponse.getFirstName());
				customerupdate.setLastName(customerResponse.getLastName());
				customerupdate.setEmailId(customerResponse.getEmailId());
				customerupdate.setMobileNumber(customerResponse.getMobileNumber());

				List<Address> addresses = customerResponse.getAddresses().stream().map(arg -> {
					Address address = new Address();

					address.setAddress_type(arg.getAddress_type());
					address.setCity(arg.getCity());
					address.setLandmark(arg.getLandmark());
					address.setPincode(arg.getPincode());
					address.setState(arg.getState());
					address.setStreetName(arg.getStreetName());

					address.setCustomer(customerupdate);
					return address;
				}).collect(Collectors.toList());

				customerupdate.setAddresses(addresses);

				customerRepository.save(customerupdate);
				return "Customer updated";
			} else {
				return "Customer not exist with this id:" + customerResponse.getCustomerId();
			}
		} catch (Exception exp) {
			LOGGER.error(exp.getMessage());
			return "Exceptionally failed " + exp.getMessage();
		} finally {
			LOGGER.info("update Customer method Completed");
		}

	}

	@Transactional
	@Modifying
	@Override
	public String deleteById(Long custmerId) {
		LOGGER.info("delete Customer method Started");
		try {
			Optional<Customer> customerOptional = customerRepository.findById(custmerId);
			if (customerOptional.isPresent()) {
				customerRepository.deleteById(custmerId);
				return "Customer deleted successfully with  Customer id:" + custmerId;
			} else {
				return "Customer details not exist:  Customer id:" + custmerId;
			}
		} catch (Exception exp) {
			LOGGER.error("Exceptionally failed. Try again  ", exp.getMessage());
			return "Exceptionally failed. Try again  " + exp.getMessage();
		} finally {
			LOGGER.info("delete Customer method Completed");
		}

	}

	public Optional<Customer> getById(Long custmerId) {

		return customerRepository.findById(custmerId);
	}

	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

}
