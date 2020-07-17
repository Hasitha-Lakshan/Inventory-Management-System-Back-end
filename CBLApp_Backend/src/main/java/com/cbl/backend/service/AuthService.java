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
		
		employee.setF_name(registerRequest.getFristName());
		employee.setL_name(registerRequest.getLastName());
		employee.setRol(registerRequest.getRol());
		employee.setAdd_line_1(registerRequest.getAddressLine1());
		employee.setAdd_line_2(registerRequest.getAddressLine2());
		employee.setAdd_line_3(registerRequest.getAddressLine3());
		employee.setUsername(registerRequest.getUsername());
		employee.setPass(encodePassword(registerRequest.getPassword()));
		
		int i=0;
		
		for(PhoneNumber pn : registerRequest.getPhoneNumbers())
		{
			PhoneNumber phoneNumber = new PhoneNumber();
			
			phoneNumber.setP_type(pn.getP_type());
			phoneNumber.setP_num(pn.getP_num());
			phoneNumber.setEmp(employee);
			
			phoneList.add(i,phoneNumber);
			i++;
		}
		
		employee.setP_nums(phoneList);

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
