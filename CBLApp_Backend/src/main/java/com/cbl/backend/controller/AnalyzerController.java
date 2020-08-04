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
import org.springframework.web.bind.annotation.RestController;

import com.cbl.backend.dto.EmployeeDetailResponse;
import com.cbl.backend.model.User;
import com.cbl.backend.repository.UserRepository;
import com.cbl.backend.service.AnalyzerService;

@RestController
@RequestMapping("api/analyzer")
public class AnalyzerController {
	UserRepository repo;

	@Autowired
	AnalyzerService analyzerService;

	@GetMapping("/employees")
	public ResponseEntity<List<EmployeeDetailResponse>> getAllEmployees() {

		return new ResponseEntity<>(analyzerService.getAllEmployees(), HttpStatus.OK);
	}

	@RequestMapping(value = "/employee/{userID}", method = RequestMethod.GET)
	public Optional<User> getEmployee(@PathVariable("userID") int userID) {
		return analyzerService.getEmployee(userID);
	}

	/*
	 * @RequestMapping(value="/employee/{userID}",method=RequestMethod.GET) public
	 * Optional<User> getEmployee(@PathVariable("userID") int userID) { return
	 * analyzerService.getEmployee(userID); }
	 */

}
