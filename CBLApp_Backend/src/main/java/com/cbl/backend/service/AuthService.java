package com.cbl.backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cbl.backend.dto.AuthenticationResponse;
import com.cbl.backend.dto.LoginRequest;
import com.cbl.backend.dto.RegisterRequest;
import com.cbl.backend.model.Admin;
import com.cbl.backend.model.Analyzer;
import com.cbl.backend.model.CashCollector;
import com.cbl.backend.model.InventoryManager;
import com.cbl.backend.model.PhoneNumber;
import com.cbl.backend.model.User;
import com.cbl.backend.repository.AdminRepository;
import com.cbl.backend.repository.AnalyzerRepository;
import com.cbl.backend.repository.CashCollectorRepository;
import com.cbl.backend.repository.InventoryManagerRepository;
import com.cbl.backend.repository.UserRepository;
import com.cbl.backend.security.JwtProvider;

@Service
public class AuthService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	AnalyzerRepository analyzerRepository;
	
	@Autowired
	InventoryManagerRepository inventoryManagerRepository;
	
	@Autowired
	CashCollectorRepository cashCollectorRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtProvider jwtProvider;
	
	public boolean signup(RegisterRequest registerRequest) {

		Optional<User> checkUser= userRepository.findByUsername(registerRequest.getUsername());
		
		if(checkUser.isPresent() || registerRequest.getPassword() == null) {
			return false;
		}
		else {
			
			User user = new User();
			List<PhoneNumber> phoneList = new ArrayList<PhoneNumber>();
			
			user.setFirstName(registerRequest.getFirstName());
			user.setLastName(registerRequest.getLastName());
			user.setRole(registerRequest.getRole());
			user.setAddressLine1(registerRequest.getAddressLine1());
			user.setAddressLine2(registerRequest.getAddressLine2());
			user.setAddressLine3(registerRequest.getAddressLine3());
			user.setUsername(registerRequest.getUsername());
			user.setPassword(encodePassword(registerRequest.getPassword()));
			
			for(PhoneNumber phonenumber : registerRequest.getPhoneNumbers()) {
				
				PhoneNumber phoneNumber = new PhoneNumber();
				
				phoneNumber.setPhoneType(phonenumber.getPhoneType());
				phoneNumber.setPhoneNumber(phonenumber.getPhoneNumber());
				phoneNumber.setUser(user);
				phoneList.add(phoneNumber);
			}
			
			user.setPhoneNumbers(phoneList);
			userRepository.save(user);
			
			if(user.getRole().equals("ADMIN")){
				
				Admin admin = new Admin();
				admin.setUser(user);
				adminRepository.save(admin);
			}
			else if(user.getRole().equals("ANALYZER")) {
				
				Analyzer analyzer = new Analyzer();
				analyzer.setUser(user);
				analyzerRepository.save(analyzer);
			}
			else if(user.getRole().equals("INVENTORY_MANAGER")) {
				
				InventoryManager inventoryManager = new InventoryManager();
				inventoryManager.setUser(user);
				inventoryManagerRepository.save(inventoryManager);
			}
			else if(user.getRole().equals("CASH_COLLECTOR")) {
				
				CashCollector cashCollector = new CashCollector();
				cashCollector.setUser(user);
				cashCollectorRepository.save(cashCollector);
			}
			
			return true;
		}
	}

	private String encodePassword(String password) {

		return passwordEncoder.encode(password);
	}

	public AuthenticationResponse login(LoginRequest loginRequest) {
		
		AuthenticationResponse authenticationResponse = new AuthenticationResponse();
		
		Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authenticate);
		authenticationResponse.setAuthenticationToken(jwtProvider.generateToken(authenticate));
		authenticationResponse.setUsername(loginRequest.getUsername());
		authenticationResponse.setRole(this.getUserRole(loginRequest.getUsername()));
		
		return authenticationResponse;
	}
	
	private String getUserRole(String username ) {
		
		User user = userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("No user found" + username));
		
		return user.getRole();
	}
}
