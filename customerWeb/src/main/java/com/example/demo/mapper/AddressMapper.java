package com.example.demo.mapper;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;

import com.example.demo.dao.Address;
import com.example.demo.dto.AddressDto;

public class AddressMapper {

	
	public static List<AddressDto> convertToAddressDto(List<Address> addressList) {
		List<AddressDto> addressDtoList = null;
		if(CollectionUtils.isNotEmpty(addressList)) {
			addressDtoList = addressList.stream()
										.filter(Objects::nonNull)
										.map(addressDtoMap)
										.collect(Collectors.toList());
		}
		return addressDtoList;
	}
	
	
	private static Function<Address, AddressDto> addressDtoMap = address -> {
		AddressDto addressDto = new AddressDto();
		addressDto.setStreet1(address.getStreet1());
		addressDto.setStreet2(address.getStreet2());
		addressDto.setCity(address.getCity());
		addressDto.setState(address.getState());
		addressDto.setCountry(address.getCountry());
		addressDto.setPincode(address.getPincode());
		addressDto.setAddressType(address.getAddressType());
		
		return addressDto;
	};
	
	
	public static List<Address> convertToAddress(List<AddressDto> addressDtoList) {
		List<Address> addressList = null;
		if(CollectionUtils.isNotEmpty(addressDtoList)) {
			addressList = addressDtoList.stream()
										.filter(Objects::nonNull)
										.map(addressMap)
										.collect(Collectors.toList());
		}
		return addressList;
	}
	
	
	
	private static Function<AddressDto, Address> addressMap = addressDto -> {
		Address address = new Address();
		address.setStreet1(addressDto.getStreet1());
		address.setStreet2(addressDto.getStreet2());
		address.setCity(addressDto.getCity());
		address.setState(addressDto.getState());
		address.setCountry(addressDto.getCountry());
		address.setPincode(addressDto.getPincode());
		address.setAddressType(addressDto.getAddressType());
		
		return address;
	};
	
}
