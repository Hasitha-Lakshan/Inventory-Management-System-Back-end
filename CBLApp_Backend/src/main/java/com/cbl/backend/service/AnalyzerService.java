package com.cbl.backend.service;



import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cbl.backend.dto.EmployeeDetailsResponse;

import com.cbl.backend.model.User;
import com.cbl.backend.repository.UserRepository;


@Service
@Component
public class AnalyzerService 
{
	 @Autowired
	private UserRepository userRepository;

	
	
	/* public AnalyzerService(UserRepository rep)
	 {
		 this.repo = rep;
	 }*/
	 
	 
	// private UserRepository userRepository;
	
	
	public List<EmployeeDetailsResponse> getAllEmployees() 
	{
		List<User> users =userRepository.findAll(); 
		
		return users.stream().map(this::mapFromUserToDto).collect(Collectors.toList());
		
		
	}
	
		private EmployeeDetailsResponse mapFromUserToDto(User user) 
		{
		
			EmployeeDetailsResponse employeeDetailsResponse= new EmployeeDetailsResponse();

			employeeDetailsResponse.setUserID(user.getUserID());
			employeeDetailsResponse.setFirstName(user.getFirstName());
			employeeDetailsResponse.setLastName(user.getLastName());
			employeeDetailsResponse.setRole(user.getRole());
			employeeDetailsResponse.setAddressLine1(user.getAddressLine1());
			employeeDetailsResponse.setAddressLine2(user.getAddressLine2());
			employeeDetailsResponse.setAddressLine3(user.getAddressLine3());
			employeeDetailsResponse.setPhoneNumbers(user.getPhoneNumbers());
		
		return employeeDetailsResponse;
	}
	
	
	
	
	
	
	
	
	
	
	
	/*public Optional<User> getEmployee(Integer userID)
	{
		return userRepository.findById(userID);
	}*/

	
	
	


}
