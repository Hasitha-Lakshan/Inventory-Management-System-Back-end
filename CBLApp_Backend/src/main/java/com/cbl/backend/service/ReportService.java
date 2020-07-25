package com.cbl.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbl.backend.dto.ReportResponse;
import com.cbl.backend.model.Report;
import com.cbl.backend.repository.ReportRepository;

@Service
public class ReportService{
	
	@Autowired
	private ReportRepository reportRepository;
	
	public List<ReportResponse> getAllReports(){
		
		List<Report> reports = reportRepository.findAll();
		
		return reports.stream().map(this::mapFromReportToDo).collect(Collectors.toList());
		
	}
	
	private ReportResponse mapFromReportToDo(Report report) {
		
		ReportResponse reportRequest = new ReportResponse();
		
		reportRequest.setDate(report.getDate());
		reportRequest.setProduct_name(report.getProduct_name());
		reportRequest.setOne_buying_price(report.getOne_buying_price());
		reportRequest.setOne_selling_price(report.getOne_selling_price());
		reportRequest.setQuantity(report.getQuantity());
		reportRequest.setBuying_price(report.getBuying_price());
		reportRequest.setSelling_price(report.getSelling_price());
		reportRequest.setProfit(report.getProfit());
		
		return reportRequest;
	}
	
}