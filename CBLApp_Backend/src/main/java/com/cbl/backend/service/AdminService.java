package com.cbl.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbl.backend.dto.UserDetailsResponse;
import com.cbl.backend.model.User;
import com.cbl.backend.repository.UserRepository;

@Service
public class AdminService {
	
	@Autowired
	private UserRepository userRepository;

	public List<UserDetailsResponse> getAllUsers() {
		
		List<User> users = userRepository.findAll();
		
		return users.stream().map(this::mapFromUserToDto).collect(Collectors.toList());
	}

	private UserDetailsResponse mapFromUserToDto(User user) {
		
		UserDetailsResponse userDetailsResponse = new UserDetailsResponse();

		userDetailsResponse.setUserID(user.getUserID());
		userDetailsResponse.setFirstName(user.getFirstName());
		userDetailsResponse.setLastName(user.getLastName());
		userDetailsResponse.setRole(user.getRole());
		userDetailsResponse.setUsername(user.getUsername());
		userDetailsResponse.setAccountStatus(user.isAccountStatus());
		userDetailsResponse.setAddressLine1(user.getAddressLine1());
		userDetailsResponse.setAddressLine2(user.getAddressLine2());
		userDetailsResponse.setAddressLine3(user.getAddressLine3());
		userDetailsResponse.setPhoneNumbers(user.getPhoneNumbers());
		
		return userDetailsResponse;
	}
}