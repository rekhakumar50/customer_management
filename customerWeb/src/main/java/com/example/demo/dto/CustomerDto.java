package com.example.demo.dto;

import java.io.Serializable;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto implements Serializable {
	
	private static final long serialVersionUID = -1966664893854947820L;
	
	private String email;
	private String firstName;
	private String lastName;
	private String dob;
	private String phoneNumber;
	private Set<AddressDto> addresses;

}
