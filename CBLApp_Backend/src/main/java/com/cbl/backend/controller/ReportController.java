package com.cbl.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbl.backend.dto.ReportRequest;
import com.cbl.backend.dto.ReportResponse;
import com.cbl.backend.service.ReportService;

@RestController
@RequestMapping("/api/inventoryManager")
public class ReportController {

	@Autowired
	private ReportService reportService;

	@GetMapping("/reports")
	public List<ReportResponse> getAll() {
		return reportService.getAllReports();
	}

	@PostMapping("/report")
	public ResponseEntity<?> saveReport(@RequestBody ReportRequest reportRequest) {

		boolean successful = reportService.saveReport(reportRequest);

		if (successful) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/report/{id}")
	public ResponseEntity<ReportResponse> deleteUserByUsername(@PathVariable int id) {

		boolean isFound = reportService.findReport(id) != null;

		if (isFound) {
			return new ResponseEntity<>(reportService.findReport(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

	}
}