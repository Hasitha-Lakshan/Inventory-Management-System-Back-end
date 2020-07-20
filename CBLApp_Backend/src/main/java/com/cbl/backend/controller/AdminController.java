package com.cbl.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbl.backend.dto.UserDetailsRequest;
import com.cbl.backend.service.AdminService;

@RestController
@RequestMapping("/api/admin/")
public class AdminController {
	
	@Autowired
	AdminService adminService;

	@GetMapping("/users")
	public ResponseEntity<List<UserDetailsRequest>> getAllUsers(){
		
		return new ResponseEntity<>(adminService.getAllUsers(), HttpStatus.OK);
	}
}
