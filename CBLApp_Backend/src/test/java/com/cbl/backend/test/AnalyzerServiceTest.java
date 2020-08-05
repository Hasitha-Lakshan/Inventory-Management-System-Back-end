package com.cbl.backend.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cbl.backend.model.PhoneNumber;
import com.cbl.backend.model.User;
import com.cbl.backend.repository.UserRepository;
import com.cbl.backend.service.AnalyzerService;

@SpringBootTest
public class AnalyzerServiceTest {
	@Autowired
	private AnalyzerService service;

	@MockBean
	private UserRepository repository;

	@Test
	public void getAllEmployees() {
		List<User> users = new ArrayList<User>();

		User user = new User();

		PhoneNumber phoneNumber = new PhoneNumber();
		List<PhoneNumber> phoneList = new ArrayList<PhoneNumber>();

		phoneNumber.setPhoneType("Home");
		phoneNumber.setPhoneNumber("0111111111");
		phoneNumber.setUser(user);
		phoneList.add(phoneNumber);

		user.setFirstName("firstName");
		user.setLastName("lastName");
		user.setRole("Admin");
		user.setAddressLine1("addressLine1");
		user.setAddressLine2("addressLine2");
		user.setAddressLine3("addressLine3");
		user.setUsername("username");
		user.setPassword("password");
		user.setPhoneNumbers(phoneList);
		users.add(user);
		when(repository.findAll()).thenReturn(users);
		assertEquals(1, service.getAllEmployees().size());
	}

	@Test
	public void getEmployeeTest() {

		User user = new User();
		PhoneNumber phoneNumber = new PhoneNumber();
		List<PhoneNumber> phoneList = new ArrayList<PhoneNumber>();

		user.setUserID(1);
		user.setFirstName("firstName");
		user.setLastName("lastName");
		user.setRole("Admin");
		user.setAddressLine1("addressLine1");
		user.setAddressLine2("addressLine2");
		user.setAddressLine3("addressLine3");
		user.setUsername("username");
		user.setPassword("password");
		phoneNumber.setPhoneType("Home");
		phoneNumber.setPhoneNumber("0111111111");
		
		phoneList.add(phoneNumber);
		user.setPhoneNumbers(phoneList);
		phoneNumber.setUser(user);

		int userID = 1;

		when(repository.findByUserID(userID)).thenReturn(user);
		assertEquals(1, service.getEmployee(userID).getUserID());

	}
}