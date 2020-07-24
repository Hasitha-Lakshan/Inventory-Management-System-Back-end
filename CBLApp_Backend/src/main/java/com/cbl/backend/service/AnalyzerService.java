package com.cbl.backend.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbl.backend.dto.EmployeeDetailsResponse;

import com.cbl.backend.repository.UserRepository;
import com.jayway.jsonpath.Predicate;

@Service
public class AnalyzerService 
{
	 @Autowired
	 UserRepository userRepository ;
	
	
	public List<EmployeeDetailsResponse> getAllEmployees() 
	{
		List<EmployeeDetailsResponse> employees = new ArrayList<EmployeeDetailsResponse>();
		userRepository.findAll();
		
		return employees;
	}
	
/*	public EmployeeDetailsResponse getEmployeesById(int UserID)
	{
		return userRepository.findOne(UserID);
	}
	
	
	public EmployeeDetailsResponse getEmployeeById(int id)
	{
		Predicateate<EmployeeDetailsResponse> byId = p -> p.getId().equals(id);
		return filterEmployees(byId);
	}
	
	private EmployeeDetailsResponse filterEmployees(Predicate strategy)
	{
		return getAllEmployees().stream().filter((java.util.function.Predicate<? super EmployeeDetailsResponse>) strategy).findFirst().orElse(null);
	}
*/
	
	
	
	
/*	private EmployeeDetailsResponse mapFromUserToDto(User user) {
		
		EmployeeDetailsResponse employeeDetailsResponse = new EmployeeDetailsResponse();

		employeeDetailsResponse.getUserID(user.getUserID());
		employeeDetailsResponse.getFirstName(user.getFirstName());
		employeeDetailsRequest.getLastName(user.getLastName());
		employeeDetailsRequest.getRole(user.getRole());
		employeeDetailsRequest.getAddressLine1(user.getAddressLine1());
		employeeDetailsRequest.getAddressLine2(user.getAddressLine2());
		employeeDetailsRequest.getAddressLine3(user.getAddressLine3());
		employeeDetailsRequest.getPhoneNumbers(user.getPhoneNumbers());
		
		return employeeDetailsRequest;
	}*/

}
