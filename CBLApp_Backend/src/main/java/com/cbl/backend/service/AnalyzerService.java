package com.cbl.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbl.backend.dto.EmployeeDetailResponse;
import com.cbl.backend.model.User;
import com.cbl.backend.repository.UserRepository;

@Service
public class AnalyzerService {
	@Autowired
	private UserRepository userRepo;

	public List<EmployeeDetailResponse> getAllEmployees() {

		List<User> users = userRepo.findAll();

		return users.stream().map(this::mapFromUserToDto).collect(Collectors.toList());
	}

	private EmployeeDetailResponse mapFromUserToDto(User user) {

		EmployeeDetailResponse employeeDetailResponse = new EmployeeDetailResponse();

		employeeDetailResponse.setUserID(user.getUserID());
		employeeDetailResponse.setFirstName(user.getFirstName());
		employeeDetailResponse.setLastName(user.getLastName());
		employeeDetailResponse.setRole(user.getRole());
		employeeDetailResponse.setAddressLine1(user.getAddressLine1());
		employeeDetailResponse.setAddressLine2(user.getAddressLine2());
		employeeDetailResponse.setAddressLine3(user.getAddressLine3());
		employeeDetailResponse.setPhoneNumbers(user.getPhoneNumbers());

		return employeeDetailResponse;
	}

	public EmployeeDetailResponse getEmployee(int userID) {

		User user = userRepo.findByUserID(userID);

		if (user != null) {
			return this.mapFromUserToDto(user);
		}

		else {
			return null;
		}

	}

}
