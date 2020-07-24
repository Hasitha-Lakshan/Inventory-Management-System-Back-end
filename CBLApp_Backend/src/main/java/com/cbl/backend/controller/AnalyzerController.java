package com.cbl.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cbl.backend.dto.EmployeeDetailsResponse;

import com.cbl.backend.service.AnalyzerService;

@RestController
@RequestMapping("api/analyzer/")
public class AnalyzerController 
{
	@Autowired
	AnalyzerService analyzerService = new AnalyzerService();
	
	@GetMapping("/employees")
	public List<EmployeeDetailsResponse> getAllEmployees()  
	{
		return analyzerService.getAllEmployees();
	}
	
	//@RequestMapping(value="",method=RequestMethod.GET)
/*	@GetMapping("/employees/UserID")
	public EmployeeDetailsResponse getEmployees(@PathVariable("UserID") int UserID)
	{
		return this.analyzerService.getEmployeesById(UserID);
	}
	
		@GetMapping("/employee/{id}")
	 public ResponseEntity<EmployeeDetailsResponse> getEmployeeById(@PathVariable("id") int UserID)
	  {
	  		EmployeeDetailsResponse employee = analyzerService.getEmployeeById(UserID);
	 		If(employee == null)
	  		{
	 			return new ResponseEntity<EmployeeDetailsResponse> (HttpStatus.NOT_FOUND);
			}
	 		return new ResponseEntity<EmployeeDetailsResponse> (employee,HttpStatus.OK);
	  }*/
	
}
