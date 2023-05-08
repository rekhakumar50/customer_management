package com.example.demo.service;

import static com.example.demo.mapper.CustomerMapper.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import com.example.demo.dao.Customer;
import com.example.demo.dto.CustomerDto;
import com.example.demo.repository.CustomerRepository;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service
public class CustomerService {
	
	private CustomerRepository customerRepository;
	
	
	public void addCustomer(CustomerDto customerDto) {
		Customer customer = convertToCustomer(customerDto);
		customerRepository.save(customer);
	}
	

	public void updateCustomer(CustomerDto customerDto) {
		Customer customer = convertToCustomer(customerDto);
		Optional<Customer> customerOp = customerRepository.findById(customer.getEmail());
		
		if(customerOp.isPresent()) {
			Customer updateCustomer = customerOp.get();
			updateCustomer.setFirstName(customer.getFirstName());
			updateCustomer.setLastName(customer.getLastName());
			updateCustomer.setDob(customer.getDob());
			updateCustomer.setPhoneNumber(customer.getPhoneNumber());
			updateCustomer.setAddresses(customer.getAddresses());

			customerRepository.save(updateCustomer);
		}
	}
	
	
	public void deleteCustomer(CustomerDto customerDto) {
		Customer customer = convertToCustomer(customerDto);
		Optional<Customer> customerOp = customerRepository.findById(customer.getEmail());

		if(customerOp.isPresent()) {
			customerRepository.delete(customerOp.get());
		}
	}
	

	public List<CustomerDto> getAllCustomers() {
		List<CustomerDto> customerList = null;
		List<Customer> customers = customerRepository.findAll();

		if(CollectionUtils.isNotEmpty(customers)) {
			customerList = customers.stream()
						.map(cust -> convertToCustomerDto(cust))
						.collect(Collectors.toList());	
		}
		return customerList;
	}
	

	public CustomerDto getCustomerByEmail(String email) {
		CustomerDto customerDto = null;
		Optional<Customer> customer = customerRepository.findById(email);
		if(customer.isPresent()) {
			customerDto = convertToCustomerDto(customer.get());
		}
		return customerDto;
	}
	
}
