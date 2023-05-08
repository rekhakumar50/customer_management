package com.example.demo.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDto implements Serializable {
	
	private static final long serialVersionUID = -2037239164496793696L;
	
	private long addressId;
	private String street1;
	private String street2;
	private String city;
	private String state;
	private String country;
	private String pincode;
	private String addressType;

}
