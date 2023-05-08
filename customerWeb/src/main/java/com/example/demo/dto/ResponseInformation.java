package com.example.demo.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseInformation implements Serializable {
	
	private static final long serialVersionUID = 7516808161796265600L;
	
	private int code;
	private String message;
		
}
