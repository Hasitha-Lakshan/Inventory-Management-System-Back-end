package com.cbl.backend.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import com.cbl.backend.dto.DeleteRequest;
import com.cbl.backend.dto.RegisterRequest;
import com.cbl.backend.dto.SetAccountStatusRequest;
import com.cbl.backend.dto.UserInfoUpdateRequest;
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
	
	public boolean updateUserInfo(UserInfoUpdateRequest rq) {
		
		User user = userRepository.findByUsername(rq.getUsername()).orElse(null);
		System.out.println(rq.getUsername()+"Services");
		if(user!=null) {
			
			/* Updatable attributes */
			user.setFirstName(rq.getFirstName());
			user.setLastName(rq.getLastName());
			user.setAddressLine1(rq.getAddressLine1());
			user.setAddressLine2(rq.getAddressLine2());
			user.setAddressLine3(rq.getAddressLine3());
			user.setRole(rq.getRole());
			
			
			/* Non updatable attributes */
			user.setPassword(user.getPassword());
			user.setUserID(user.getUserID());
			user.setUsername(user.getUsername());
			
			userRepository.save(user);
			return true;
			
		}else {
			return false;
		}
			
	}
	
	public boolean setAccountStatus(SetAccountStatusRequest rq) {
		
		User user = userRepository.findByUsername(rq.getUsername()).orElse(null);
		
		if(user!=null) {
			
			user.setAccountStatus(rq.isAccountStatus());			
			userRepository.save(user);
			return true;
		}else {
			return false;
		}
		
			
	}
	
	public boolean deleteUser(DeleteRequest rq) {
		
		User user = userRepository.findByUsername(rq.getUsername()).orElse(null);
		System.out.println(rq.getUsername());
		if(user!=null) {
			userRepository.deleteById(user.getUserID());
			return true;
		}else {
			return false;
		}
	}
	
}