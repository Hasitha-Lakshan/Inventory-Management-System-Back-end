package com.cbl.backend.reports.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbl.backend.entity.Report;
import com.cbl.backend.repository.ReportRepository;

@Service
public class ReportService {
	
	@Autowired
	private ReportRepository repository;
	
	public Report saveReport(Report report) {
		return repository.save(report);
	}
	
	public List<Report> saveReport(List<Report> report){
		return repository.saveAll(report);
	}
	
	public List<Report> getReports(){
		return repository.findAll();
	}
	
	public Report getReportById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public Report getReportByShopName(String name) {
		return repository.findByShopName(name);
	}
	
	public String deleteReport(int id){
        repository.deleteById(id);
        return "Report removed" +id;
    }

    public Report updateReport(Report report){
        Report existingReport=repository.findById(report.getInvoiceId()).orElse(null);

        existingReport.setShopName(report.getShopName());
        existingReport.setIssuedDate(report.getIssuedDate());
        existingReport.setExpireDate(report.getExpireDate());
        existingReport.setStatus(report.isStatus());
        existingReport.setValue(report.getValue());
        existingReport.setCheque(report.getCheque());
        existingReport.setCash(report.getCash());
        existingReport.setCredits(report.getCredits());
        

        return repository.save(existingReport);
    }
	

}
