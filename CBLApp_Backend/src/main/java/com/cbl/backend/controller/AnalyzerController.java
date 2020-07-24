package com.cbl.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cbl.backend.dto.EmployeeDetailsResponse;
import com.cbl.backend.dto.UserDetailsResponse;
import com.cbl.backend.model.User;
import com.cbl.backend.service.AnalyzerService;


@RestController
@RequestMapping("api/analyzer/")
public class AnalyzerController 
{
	@Autowired
	private AnalyzerService analyzerService;
	
	@GetMapping("/employees")
	public ResponseEntity<List<EmployeeDetailsResponse>> getAllEmployees(){
		
		return new ResponseEntity<>(analyzerService.getAllEmployees(), HttpStatus.OK);
	}
	
	
	
	
	
	
	/*@GetMapping("/employees")
	public List<EmployeeDetailsResponse> getAllEmployees()  
	{
		return analyzerService.getAllEmployees();
	}
	
	/*@RequestMapping(value="/employee/{id}",method=RequestMethod.GET)
	public Optional<User> getEmployee(@PathVariable("id") Integer userID)
	{
		return analyzerService.getEmployee(userID);
	}*/
	
}
