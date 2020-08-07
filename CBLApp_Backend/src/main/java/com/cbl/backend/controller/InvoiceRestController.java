package com.cbl.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbl.backend.dto.UserDetailsResponse;
import com.cbl.backend.model.Invoice;
import com.cbl.backend.reports.service.ReportService;
import com.cbl.backend.repository.InvoiceRepository;
import com.cbl.backend.service.InvoiceService;

@RestController
@RequestMapping("/api/cashCollector/")
public class InvoiceRestController {
	
	@Autowired
    private InvoiceService invoiceService;
	
	
	
	@PostMapping("/savereport")
    public Invoice addReport(@RequestBody Invoice invoice){
        return service.saveReport(invoice);
    }
    @PostMapping("/savereports")
    public List<Invoice> addReport(@RequestBody List<Invoice> invoice){
        return service.saveReport(invoice);
    }
    
    @GetMapping("/users")
	public ResponseEntity<List<UserDetailsResponse>> getAllUsers(){
		
		return new ResponseEntity<>(adminService.getAllUsers(), HttpStatus.OK);
	}

    @GetMapping("/get-invoice-reports")
    public ResponseEntity<List<InvoiceDetailsResponse>> getAllInvoiceReports(){
    	return new ResponseEntity<>(invoiceService.getReports(), HttpStatus.OK)
    }
    public List<Invoice> getAllReports(){
        return service.getReports();
    }
    @GetMapping("/findreportbyid/{id}")
    public Invoice findReportbyId(@PathVariable int id){
        return service.getReportById(id);
    }
    @GetMapping("/findreportbyshopname/{name}")
    public Invoice findReportByName(@PathVariable String name){
        return service.getReportByShopName(name);
    }

    @PutMapping("/update")
    public Invoice updateReport(@RequestBody Invoice invoice){
        return service.updateReport(invoice);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteReport(@PathVariable int id){
        return service.deleteReport(id);
    }
	
	
	 
	

}
