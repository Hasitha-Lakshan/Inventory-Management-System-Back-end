package com.cbl.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cbl.backend.dto.RegisterRequest;
import com.cbl.backend.model.SalesItemsReport;
import com.cbl.backend.service.SalesItemsReportService;

import antlr.collections.List;

@RestController
public class SalesItemsReportController {

	@Autowired
	private final SalesItemsReportService reportService;
	
	public SalesItemsReportController(SalesItemsReportService report) {
		this.reportService=report;
	}
	
	
	@GetMapping("/report")
	public java.util.List<SalesItemsReport> getAll() {
		return reportService.getAll();
	}
	
	@PostMapping("/report")
	public SalesItemsReport save(@RequestBody SalesItemsReport report) {
		return reportService.save(report);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable int id) {
		return "report";
		
	}
}
