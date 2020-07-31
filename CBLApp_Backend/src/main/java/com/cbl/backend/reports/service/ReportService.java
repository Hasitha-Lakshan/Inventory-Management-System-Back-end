package com.cbl.backend.reports.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbl.backend.model.Invoice;
import com.cbl.backend.repository.ReportRepository;

@Service
public class ReportService {
	
	@Autowired
	private ReportRepository repository;
	
	public Invoice saveReport(Invoice invoice) {
		return repository.save(invoice);
	}
	
	public List<Invoice> saveReport(List<Invoice> invoice){
		return repository.saveAll(invoice);
	}
	
	public List<Invoice> getReports(){
		return repository.findAll();
	}
	
	public Invoice getReportById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public Invoice getReportByShopName(String name) {
		return repository.findByShopName(name);
	}
	
	public String deleteReport(int id){
        repository.deleteById(id);
        return "Report removed" +id;
    }

    public Invoice updateReport(Invoice invoice){
        Invoice existingReport=repository.findById(invoice.getInvoiceId()).orElse(null);

        existingReport.setShopName(invoice.getShopName());
        existingReport.setIssuedDate(invoice.getIssuedDate());
        existingReport.setExpireDate(invoice.getExpireDate());
        existingReport.setStatus(invoice.isStatus());
        existingReport.setValue(invoice.getValue());
        existingReport.setCheque(invoice.getCheque());
        existingReport.setCash(invoice.getCash());
        existingReport.setCredits(invoice.getCredits());
        
       
        return repository.save(existingReport);
    }
	

}
