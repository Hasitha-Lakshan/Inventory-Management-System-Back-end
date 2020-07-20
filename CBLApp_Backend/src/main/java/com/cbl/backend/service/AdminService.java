package com.cbl.backend.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cbl.backend.dto.UserDetailsRequest;
import com.cbl.backend.dto.UserInfoUpdateRequest;
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
	
	public UserInfoUpdateRequest updateUserInfo(@RequestBody UserInfoUpdateRequest rq) {
		
		User user = userRepository.findById(rq.getUserID()).orElse(null);
		if(user!=null) {
			/* Updatable attributes */
			user.setFirstName(rq.getFirstName());
			user.setLastName(rq.getLastName());
			user.setAddressLine1(rq.getAddressLine1());
			user.setAddressLine2(rq.getAddressLine2());
			user.setAddressLine3(rq.getAddressLine3());
			user.setAccountStatus(rq.isAccountStatus());
			user.setRole(rq.getRole());
			user.setPhoneNumbers(rq.getPhoneNumbers());
			
			/* Non updatable attributes */
			user.setPassword(user.getPassword());
			user.setUserID(user.getUserID());
			user.setUsername(user.getUsername());
			
			userRepository.save(user);
			return rq;
		} 
			return null;	
		
	}
	
	public boolean swapAccountStatus(int id) {
		
		User user = userRepository.findById(id).orElse(null);
		if(user!=null) {
			/*swap the boolean status of the user account status*/
			user.setAccountStatus(!user.isAccountStatus());			
			userRepository.save(user);
			return true;
		} 
			return false;	
	}
	
	public boolean deleteUserById(int id) {
		
		Optional<User> user = userRepository.findById(id);
		if(user!=null) {
			userRepository.deleteById(id);
			return true;  
		}else {
			return false;
		}
	}
}