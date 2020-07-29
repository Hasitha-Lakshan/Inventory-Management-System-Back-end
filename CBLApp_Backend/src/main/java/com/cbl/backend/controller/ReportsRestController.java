package com.cbl.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cbl.backend.entity.Report;
import com.cbl.backend.reports.service.ReportService;
import com.cbl.backend.repository.ReportRepository;

@RestController
@CrossOrigin(origins = "*")
public class ReportsRestController {
	
	@Autowired
    private ReportService service;
	
	@PostMapping("/savereport")
    public Report addReport(@RequestBody Report report){
        return service.saveReport(report);
    }
    @PostMapping("/savereports")
    public List<Report> addReport(@RequestBody List<Report> report){
        return service.saveReport(report);
    }

    @GetMapping("/getreports")
    public List<Report> getAllReports(){
        return service.getReports();
    }
    @GetMapping("/findreportbyid/{id}")
    public Report findReportbyId(@PathVariable int id){
        return service.getReportById(id);
    }
    @GetMapping("/findreportbyshopname/{name}")
    public Report findReportByName(@PathVariable String name){
        return service.getReportByShopName(name);
    }

    @PutMapping("/update")
    public Report updateReport(@RequestBody Report report){
        return service.updateReport(report);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteReport(@PathVariable int id){
        return service.deleteReport(id);
    }
	
	
	 
	

}
