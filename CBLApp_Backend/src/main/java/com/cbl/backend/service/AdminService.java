package com.cbl.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbl.backend.dto.UserDetailsRequest;
import com.cbl.backend.model.User;
import com.cbl.backend.repository.UserRepository;

@Service
public class AdminService {
	
	@Autowired
	private UserRepository userRepository;

	public List<UserDetailsRequest> getAllUsers() {
		
		List<User> users = userRepository.findAll();
		
		return users.stream().map(this::mapFromUserToDto).collect(Collectors.toList());
	}

	private UserDetailsRequest mapFromUserToDto(User user) {
		
		UserDetailsRequest userDetailsRequest = new UserDetailsRequest();

		userDetailsRequest.setUserID(user.getUserID());
		userDetailsRequest.setFirstName(user.getFirstName());
		userDetailsRequest.setLastName(user.getLastName());
		userDetailsRequest.setRole(user.getRole());
		userDetailsRequest.setUsername(user.getUsername());
		userDetailsRequest.setAccountStatus(user.isAccountStatus());
		userDetailsRequest.setAddressLine1(user.getAddressLine1());
		userDetailsRequest.setAddressLine2(user.getAddressLine2());
		userDetailsRequest.setAddressLine3(user.getAddressLine3());
		userDetailsRequest.setPhoneNumbers(user.getPhoneNumbers());
		
		return userDetailsRequest;
	}
}