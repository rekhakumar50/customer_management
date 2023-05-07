package com.example.demo.dao;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Address implements Serializable {
	
	private static final long serialVersionUID = 125218880316596081L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long addressId;
	
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
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
	private Customer customer;

}
