package com.cbl.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cbl.backend.dto.LoginRequest;
import com.cbl.backend.dto.RegisterRequest;
import com.cbl.backend.model.Employee;
import com.cbl.backend.model.PhoneNumber;
import com.cbl.backend.repository.EmployeeRepository;
import com.cbl.backend.security.JwtProvider;

@Service
public class AuthService {

	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtProvider jwtProvider;
	
	public void signup(RegisterRequest registerRequest) {

		Employee employee = new Employee();
		List<PhoneNumber> phoneList = new ArrayList<>();
		
		employee.setFirstName(registerRequest.getFirstName());
		employee.setLastName(registerRequest.getLastName());
		employee.setRole(registerRequest.getRole());
		employee.setAddressLine1(registerRequest.getAddressLine1());
		employee.setAddressLine2(registerRequest.getAddressLine2());
		employee.setAddressLine3(registerRequest.getAddressLine3());
		employee.setUsername(registerRequest.getUsername());
		employee.setPassword(encodePassword(registerRequest.getPassword()));
		
		int i=0;
		
		for(PhoneNumber phonenumber : registerRequest.getPhoneNumbers())
		{
			PhoneNumber phoneNumber = new PhoneNumber();
			
			phoneNumber.setPhoneType(phonenumber.getPhoneType());
			phoneNumber.setPhoneNumber(phonenumber.getPhoneNumber());
			phoneNumber.setEmployee(employee);
			
			phoneList.add(i,phoneNumber);
			i++;
		}
		
		employee.setPhoneNumbers(phoneList);

		employeeRepository.save(employee);
		
	}

	private String encodePassword(String password) {

		return passwordEncoder.encode(password);
	}

	public String login(LoginRequest loginRequest) {
		
		Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authenticate);
		return jwtProvider.generateToken(authenticate);
	}
	
	
	
}
