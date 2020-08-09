package com.cbl.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbl.backend.dto.SetAccountStatusRequest;
import com.cbl.backend.dto.UserInfoUpdateRequest;
import com.cbl.backend.dto.UserDetailsResponse;
import com.cbl.backend.service.AdminService;

@RestController
@RequestMapping("/api/admin/")
public class AdminController {

	@Autowired
	AdminService adminService;
	@CrossOrigin(origins="*",allowedHeaders="*")
	@GetMapping("/users")
	public ResponseEntity<List<UserDetailsResponse>> getAllUsers() {

		return new ResponseEntity<>(adminService.getAllUsers(), HttpStatus.OK);
	}
	
	@PutMapping("/updateuser")
	public ResponseEntity<?> updateUserInfo(@RequestBody UserInfoUpdateRequest rq) {

		boolean successful = adminService.updateUserInfo(rq);
		if (successful) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	@CrossOrigin(origins="*",allowedHeaders="*")
	@PutMapping("/setaccountstatus")
	public ResponseEntity<?> setAccountStatus(@RequestBody SetAccountStatusRequest rq) {

		boolean successful = adminService.setAccountStatus(rq);
		if (successful) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	@CrossOrigin(origins="*",allowedHeaders="*")
	@DeleteMapping("/deleteuser/{username}")
	public ResponseEntity<?> deleteUserByUsername(@PathVariable String username) {

		boolean successful = adminService.deleteUser(username);
		if (successful) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
