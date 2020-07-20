package com.cbl.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbl.backend.dto.UserDetailsRequest;
import com.cbl.backend.dto.UserInfoUpdateRequest;
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
	
	
	@PutMapping("/updateuser")
	public ResponseEntity updateUserInfo(@RequestBody UserInfoUpdateRequest rq) {
		
		UserInfoUpdateRequest Obj = adminService.updateUserInfo(rq);
		if(Obj!=null) {
			return new ResponseEntity<>(rq, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(rq, HttpStatus.BAD_REQUEST);
		}
		
			
		
	} 
	
	@PutMapping("/setaccountstatus/{id}")
	public ResponseEntity swapAccountStatus(@PathVariable int id) {
			
		boolean succesful = adminService.swapAccountStatus(id);
		if(succesful) {
			return new ResponseEntity<>(succesful, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(succesful, HttpStatus.BAD_REQUEST);
		}
	}	
	
	@DeleteMapping("/deleteuser/{id}")
	public ResponseEntity deleteUserById(@PathVariable int id) {
			
		boolean succesful = adminService.deleteUserById(id);
		if(succesful) {
			return new ResponseEntity<>(succesful, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(succesful, HttpStatus.BAD_REQUEST);
		}
	}	
	

}
