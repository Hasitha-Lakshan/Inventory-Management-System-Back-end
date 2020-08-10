package com.cbl.backend.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cbl.backend.dto.SetAccountStatusRequest;
import com.cbl.backend.dto.UserInfoUpdateRequest;
import com.cbl.backend.model.PhoneNumber;
import com.cbl.backend.model.User;
import com.cbl.backend.repository.UserRepository;
import com.cbl.backend.service.AdminService;

@SpringBootTest
public class AdminServiceTest {

	@Autowired
	private AdminService service;
	@MockBean
	private UserRepository repository;

	@Test
	public void updateUserInfotest() {
		UserInfoUpdateRequest rq = new UserInfoUpdateRequest();
		User user = new User();
		rq.setFirstName("firstName");
		rq.setLastName("lastName");
		rq.setRole("role");
		rq.setUsername("ADMIN");
		rq.setAddressLine1("addressLine1");
		rq.setAddressLine2("addressLine2");
		rq.setAddressLine3("addressLine3");
		PhoneNumber phoneNumber = new PhoneNumber();
		List<PhoneNumber> phoneList = new ArrayList<PhoneNumber>();

		phoneNumber.setPhoneType("Home");
		phoneNumber.setPhoneNumber("0111111111");
		phoneNumber.setUser(user);
		phoneList.add(phoneNumber);

		rq.setPhoneNumbers(phoneList);

		user.setFirstName("firstName");
		user.setLastName("lastName");
		user.setRole("role");
		user.setUsername("ADMIN");
		user.setAddressLine1("addressLine1");
		user.setAddressLine2("addressLine2");
		user.setAddressLine3("addressLine3");
		user.setPhoneNumbers(phoneList);
		when(repository.findByusername(rq.getUsername())).thenReturn(user);
		assertEquals(true, service.updateUserInfo(rq));
	}

	@Test
	public void setAccountStatusTest() {
		SetAccountStatusRequest rq = new SetAccountStatusRequest();
		rq.setUsername("ADMIN");
		rq.setAccountStatus(true);

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
		user.setAccountStatus(false);

		when(repository.findByusername(rq.getUsername())).thenReturn(user);
		assertEquals(true, service.setAccountStatus(rq));
		System.out.println(user.isAccountStatus());

	}

	@Test
	public void deleteUser() {

		User user = new User();

		PhoneNumber phoneNumber = new PhoneNumber();
		List<PhoneNumber> phoneList = new ArrayList<PhoneNumber>();

		phoneNumber.setPhoneType("Home");
		phoneNumber.setPhoneNumber("0111111111");
		phoneNumber.setUser(user);
		phoneList.add(phoneNumber);

		user.setUserID(1);
		user.setFirstName("firstName");
		user.setLastName("lastName");
		user.setRole("Admin");
		user.setAddressLine1("addressLine1");
		user.setAddressLine2("addressLine2");
		user.setAddressLine3("addressLine3");
		user.setUsername("username");
		user.setPassword("password");
		user.setPhoneNumbers(phoneList);
		user.setAccountStatus(false);

		when(repository.findByusername("username")).thenReturn(user);
		assertEquals(true, service.deleteUser("username"));

	}

	@Test
	public void getAllUsers() {

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
		assertEquals(1, service.getAllUsers().size());

	}
}
