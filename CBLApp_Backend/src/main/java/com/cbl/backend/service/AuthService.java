package com.cbl.backend.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbl.backend.dto.RegisterRequest;
import com.cbl.backend.model.Employee;
import com.cbl.backend.model.PhoneNumber;
import com.cbl.backend.repository.EmployeeRepository;

@Service
public class AuthService {

	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public void signup(RegisterRequest registerRequest) {

		Employee employee = new Employee();
		PhoneNumber phoneNumber = new PhoneNumber();
		
		employee.setF_name(registerRequest.getFristName());
		employee.setL_name(registerRequest.getLastName());
		employee.setRol(registerRequest.getRol());
		employee.setAdd_line_1(registerRequest.getAddressLine1());
		employee.setAdd_line_2(registerRequest.getAddressLine2());
		employee.setAdd_line_3(registerRequest.getAddressLine3());
		employee.setU_name(registerRequest.getUserName());
		employee.setPass(registerRequest.getPassword());
		
		List<PhoneNumber> phoneList = new ArrayList<>();
		
		for(PhoneNumber pn : registerRequest.getPhoneNumbers())
		{
			phoneNumber.setP_type(pn.getP_type());
			phoneNumber.setP_num(pn.getP_num());
			phoneNumber.setEmp(employee);
			
			phoneList = (Arrays.asList(phoneNumber)); // need to read all data into array list
		}
		
		employee.setP_nums(phoneList);

		employeeRepository.save(employee);
		
	}

	
	
}
