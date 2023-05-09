package com.example.demo.controller;

import static com.example.demo.constant.Constants.DATA_DELETED;
import static com.example.demo.constant.Constants.DATA_RETRIEVED;
import static com.example.demo.constant.Constants.DATA_SAVED;
import static com.example.demo.constant.Constants.DATA_UPDATED;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CustomerDto;
import com.example.demo.dto.Response;
import com.example.demo.service.CustomerService;
import com.example.demo.transformer.ResponseTransformer;


@RestController
@RequestMapping("/api")
public class CustomerController {
	
	
	@Autowired
	private CustomerService customerService;
	
	
	@Autowired
	private ResponseTransformer responseTransformer;
	
	
	@PostMapping(value = "/customer", consumes = "application/json")
	public ResponseEntity<Response> addCustomer(@RequestBody CustomerDto customerDto) {
		try {
			customerService.addCustomer(customerDto);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		Response response = responseTransformer.getResponse(HttpStatus.CREATED.value(), DATA_SAVED);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	
	@PutMapping(value = "/customer", consumes = "application/json")
	public ResponseEntity<Response> updateCustomer(@RequestBody CustomerDto customerDto) {
		try {
			customerService.updateCustomer(customerDto);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		Response response = responseTransformer.getResponse(HttpStatus.OK.value(), DATA_UPDATED);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
	@DeleteMapping(value = "/customer", consumes = "application/json")
	public ResponseEntity<Response> deleteCustomer(@RequestBody CustomerDto customerDto) {
		try {
			customerService.deleteCustomer(customerDto);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		Response response = responseTransformer.getResponse(HttpStatus.OK.value(), DATA_DELETED);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/customers", produces = "application/json")
	public ResponseEntity<Response> getAllCustomer() {
		List<CustomerDto>  customerDtoList = customerService.getAllCustomers();
		try {
			customerDtoList = customerService.getAllCustomers();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		Response response = responseTransformer.getResponse(HttpStatus.OK.value(), DATA_RETRIEVED);
		response.setCustomerDtos(customerDtoList);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/customer/{email}", produces = "application/json")
	public ResponseEntity<Response>  getCustomerByemail(@PathVariable String email) {
		CustomerDto customerDto = null;
		try {
			customerDto = customerService.getCustomerByEmail(email);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		Response response = responseTransformer.getResponse(HttpStatus.OK.value(), DATA_RETRIEVED);
		response.setCustomerDto(customerDto);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
