package com.example.demo.mapper;

import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;

import com.example.demo.dao.Address;
import com.example.demo.dto.AddressDto;

public class AddressMapper {

	
	public static Set<AddressDto> convertToAddressDto(Set<Address> addressList) {
		Set<AddressDto> addressDtoList = null;
		if(CollectionUtils.isNotEmpty(addressList)) {
			addressDtoList = addressList.stream()
										.filter(Objects::nonNull)
										.map(addressDtoMap)
										.collect(Collectors.toSet());
		}
		return addressDtoList;
	}
	
	
	private static Function<Address, AddressDto> addressDtoMap = address -> {
		AddressDto addressDto = new AddressDto();
		addressDto.setAddressId(address.getAddressId());
		addressDto.setStreet1(address.getStreet1());
		addressDto.setStreet2(address.getStreet2());
		addressDto.setCity(address.getCity());
		addressDto.setState(address.getState());
		addressDto.setCountry(address.getCountry());
		addressDto.setPincode(address.getPincode());
		addressDto.setAddressType(address.getAddressType());
		
		return addressDto;
	};
	
	
	public static Set<Address> convertToAddress(Set<AddressDto> addressDtoList) {
		Set<Address> addressList = null;
		if(CollectionUtils.isNotEmpty(addressDtoList)) {
			addressList = addressDtoList.stream()
										.filter(Objects::nonNull)
										.map(addressMap)
										.collect(Collectors.toSet());
		}
		return addressList;
	}
	
	
	
	private static Function<AddressDto, Address> addressMap = addressDto -> {
		Address address = new Address();
		address.setAddressId(addressDto.getAddressId());
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
