package com.cbl.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbl.backend.dto.InvoiceDetailsResponse;
import com.cbl.backend.dto.InvoiceSaveRequest;
import com.cbl.backend.dto.InvoiceUpdateRequest;
import com.cbl.backend.service.InvoiceService;

@RestController
@RequestMapping("/api/cashCollector/")
public class InvoiceRestController {

	@Autowired
	private InvoiceService invoiceService;

	@PostMapping("/savereport")
	public boolean addReport(@RequestBody InvoiceSaveRequest invoiceSaveRequest) {
		return invoiceService.saveReport(invoiceSaveRequest);
	}
//    @PostMapping("/savereports")
//    public List<Invoice> addReport(@RequestBody List<Invoice> invoice){
//        return invoiceService.saveReport(invoice);
//    }

	@GetMapping("/get-invoice-reports")
	public ResponseEntity<List<InvoiceDetailsResponse>> getAllInvoiceReports() {
		return new ResponseEntity<>(invoiceService.getReports(), HttpStatus.OK);
	}

	@GetMapping("/findreportbyid/{id}")
	public ResponseEntity<InvoiceDetailsResponse> findReportbyId(@PathVariable int id) {
		return new ResponseEntity<>(invoiceService.getReportById(id), HttpStatus.OK);
	}
//    @GetMapping("/findreportbyshopname/{name}")
//    public Invoice findReportByName(@PathVariable String name){
//        return service.getReportByShopName(name);
//    }

	@PutMapping("/update-invoice/{id}")
	public ResponseEntity<?> updateReport(@PathVariable int id,
			@RequestBody InvoiceUpdateRequest invoiceUpdateRequest) {

		boolean successful = invoiceService.updateInvoiceReport(id, invoiceUpdateRequest);
		if (successful) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

//    @DeleteMapping("/delete/{id}")
//    public String deleteReport(@PathVariable int id){
//        return service.deleteReport(id);
//    }

}
