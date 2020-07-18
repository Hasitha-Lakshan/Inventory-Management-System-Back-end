package com.cbl.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbl.backend.dto.UserDetailsRequest;
import com.cbl.backend.model.Employee;
import com.cbl.backend.repository.EmployeeRepository;
import java.util.stream.Collectors;

@Service
public class AdminService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public List<UserDetailsRequest> getAllUsers() {
		
		List<Employee> employees = employeeRepository.findAll();
		
		return employees.stream().map(this::mapFromEmployeeToDto).collect(Collectors.toList());
	}
	
	private UserDetailsRequest mapFromEmployeeToDto(Employee employee) {
		
		UserDetailsRequest userDetailsRequest = new UserDetailsRequest();
		
		userDetailsRequest.setFirstName(employee.getFirstName());
		userDetailsRequest.setLastName(employee.getLastName());
		userDetailsRequest.setRole(employee.getRole());
		userDetailsRequest.setUsername(employee.getUsername());
		userDetailsRequest.setPassword(employee.getPassword());
		//userDetailsRequest.setPhoneNumbers(employee.getPhoneNumbers());
		userDetailsRequest.setAddressLine1(employee.getAddressLine1());
		userDetailsRequest.setAddressLine2(employee.getAddressLine2());
		userDetailsRequest.setAddressLine3(employee.getAddressLine3());
		
		return userDetailsRequest;
	}
}
