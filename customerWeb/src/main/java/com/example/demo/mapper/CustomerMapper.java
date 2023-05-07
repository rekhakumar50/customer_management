package com.example.demo.mapper;

import com.example.demo.dao.Customer;
import com.example.demo.dto.CustomerDto;

public class CustomerMapper {
	
	
	public static CustomerDto convertToCustomerDto(Customer customer) {
		CustomerDto customerDto = new CustomerDto();
		customerDto.setEmail(customer.getEmail());
		customerDto.setFirstName(customer.getFirstName());
		customerDto.setLastName(customer.getLastName());
		customerDto.setDob(customer.getDob());
		customerDto.setPhoneNumber(customer.getPhoneNumber());
		customerDto.setAddresses(customer.getAddresses());

		return customerDto;
	}
	
	
	public static Customer convertToCustomer(CustomerDto customerDto) {
		Customer customer = new Customer();
		customer.setEmail(customerDto.getEmail());
		customer.setFirstName(customerDto.getFirstName());
		customer.setLastName(customerDto.getLastName());
		customer.setDob(customerDto.getDob());
		customer.setPhoneNumber(customerDto.getPhoneNumber());
		customer.setAddresses(customerDto.getAddresses());

		return customer;
	}

}
