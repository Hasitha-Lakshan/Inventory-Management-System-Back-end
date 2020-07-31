package com.cbl.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbl.backend.dto.AuthenticationResponse;
import com.cbl.backend.dto.LoginRequest;
import com.cbl.backend.dto.RegisterRequest;
import com.cbl.backend.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@PostMapping("/signup")
	public boolean signup(@RequestBody RegisterRequest registerRequest) {
		
		return authService.signup(registerRequest);
	}
	
	@PostMapping("/login")
	public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) {
		
		return authService.login(loginRequest);
	}
}
