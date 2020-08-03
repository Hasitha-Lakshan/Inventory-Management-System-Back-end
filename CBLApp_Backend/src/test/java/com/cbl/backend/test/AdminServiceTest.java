package com.cbl.backend.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cbl.backend.dto.DeleteRequest;
import com.cbl.backend.dto.SetAccountStatusRequest;
import com.cbl.backend.dto.UserInfoUpdateRequest;

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
		UserInfoUpdateRequest rq=new UserInfoUpdateRequest();
		rq.setFirstName("firstName");
		rq.setLastName("lastName");
		rq.setRole("role");
		rq.setUsername("ADMIN");
		rq.setAddressLine1("addressLine1");
		rq.setAddressLine2("addressLine2");
		rq.setAddressLine3("addressLine3");
		User user=new User();
		user.setUsername("ADMIN");
		when(repository.findbyUsernameReturnUser(rq.getUsername())).thenReturn(user);
		assertEquals(true,service.updateUserInfo(rq));
	}
	@Test
	public void setAccountStatusTest() {
		SetAccountStatusRequest rq=new SetAccountStatusRequest();
		rq.setUsername("ADMIN");
		rq.setAccountStatus(true);
		
		User user=new User();
		user.setUsername("ADMIN");
		when(repository.findbyUsernameReturnUser(rq.getUsername())).thenReturn(user);
		assertEquals(true,service.setAccountStatus(rq));
		
		
	}
	
	@Test
	public void deleteUser() {
		DeleteRequest rq=new DeleteRequest();
		rq.setUsername("ADMIN");
		
		User user=new User();
		user.setUsername("ADMIN");
		when(repository.findbyUsernameReturnUser(rq.getUsername())).thenReturn(user);
		assertEquals(true,service.deleteUser(rq));
		
		
	}
	@Test
	public void getAllUsers() {
		
		List<User> users=new ArrayList<User>();
		when(repository.findAll()).thenReturn(users);
		assertEquals(0,service.getAllUsers().size());
		
		
	}
}
