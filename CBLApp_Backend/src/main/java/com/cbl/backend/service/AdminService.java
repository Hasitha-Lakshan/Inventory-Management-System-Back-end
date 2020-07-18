package com.cbl.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbl.backend.dto.UserDetailsRequest;
import com.cbl.backend.model.User;
import com.cbl.backend.repository.UserRepository;

import java.util.stream.Collectors;

@Service
public class AdminService {
	
	@Autowired
	private UserRepository userRepository;

	public List<UserDetailsRequest> getAllUsers() {
		
		List<User> employees = userRepository.findAll();
		
		return employees.stream().map(this::mapFromUserToDto).collect(Collectors.toList());
	}
	
	private UserDetailsRequest mapFromUserToDto(User user) {
		
		UserDetailsRequest userDetailsRequest = new UserDetailsRequest();
		
		userDetailsRequest.setFirstName(user.getFirstName());
		userDetailsRequest.setLastName(user.getLastName());
		userDetailsRequest.setRole(user.getRole());
		userDetailsRequest.setUsername(user.getUsername());
		userDetailsRequest.setPassword(user.getPassword());
		//userDetailsRequest.setPhoneNumbers(employee.getPhoneNumbers());
		userDetailsRequest.setAddressLine1(user.getAddressLine1());
		userDetailsRequest.setAddressLine2(user.getAddressLine2());
		userDetailsRequest.setAddressLine3(user.getAddressLine3());
		
		return userDetailsRequest;
	}
}
