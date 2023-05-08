package com.example.demo.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response implements Serializable {
	
	private static final long serialVersionUID = 3782356738956590900L;
	
	private ResponseInformation information;	
	private List<CustomerDto> customerDtos;
	private CustomerDto customerDto;

}
