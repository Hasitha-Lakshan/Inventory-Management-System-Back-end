package com.cbl.backend.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cbl.backend.dto.RegisterRequest;
import com.cbl.backend.model.PhoneNumber;
import com.cbl.backend.model.User;
import com.cbl.backend.repository.UserRepository;
import com.cbl.backend.service.AuthService;

@SpringBootTest
public class AuthServiceTest {

	@Autowired
	AuthService authService;

	@MockBean
	private UserRepository userRepository;

	@Test
	public void signupTest() {

		User user = new User();
		RegisterRequest registerRequest = new RegisterRequest();
		PhoneNumber phoneNumber = new PhoneNumber();
		List<PhoneNumber> phoneList = new ArrayList<PhoneNumber>();

		phoneNumber.setPhoneType("Home");
		phoneNumber.setPhoneNumber("0111111111");
		phoneNumber.setUser(user);
		phoneList.add(phoneNumber);

		registerRequest.setFirstName("test_firstName");
		registerRequest.setLastName("test_lastName");
		registerRequest.setRole("Admin");
		registerRequest.setAddressLine1("test_addressLine1");
		registerRequest.setAddressLine2("test_addressLine2");
		registerRequest.setAddressLine3("test_addressLine3");
		registerRequest.setUsername("test_username");
		registerRequest.setPassword("test_password");
		registerRequest.setPhoneNumbers(phoneList);

		when(userRepository.save(user)).thenReturn(user);
		assertEquals(true, authService.signup(registerRequest));
	}
}