package com.example.demo.dao;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Address implements Serializable {
	
	private static final long serialVersionUID = 125218880316596081L;
	
	@Column(nullable = false)
	private String street1;
	
	private String street2;
	
	@Column(nullable = false)
	private String city;
	
	private String state;
	
	@Column(nullable = false)
	private String country;
	
	@Column(nullable = false)
	private String pincode;
	
	private String addressType;

}
