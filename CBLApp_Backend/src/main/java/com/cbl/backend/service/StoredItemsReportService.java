package com.cbl.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cbl.backend.dto.StoredItemsReportResponse;
import com.cbl.backend.model.StoredItemsReport;
import com.cbl.backend.repository.StoredItemsReportRepository;

@Service
public class StoredItemsReportService{
	
	@Autowired
	private StoredItemsReportRepository storedItemsReportRepository;
	
	public List<StoredItemsReportResponse> getAllReports(){
		
		List<StoredItemsReport> reports = storedItemsReportRepository.findAll();
		
		return reports.stream().map(this::mapFromReportToDo).collect(Collectors.toList());
		
	}
	
	private StoredItemsReportResponse mapFromReportToDo(StoredItemsReport storedItemsReport) {
		
		StoredItemsReportResponse storedItemsReportRequest = new StoredItemsReportResponse();
		
		storedItemsReportRequest.setDate(storedItemsReport.getDate());
		storedItemsReportRequest.setProduct_name(storedItemsReport.getProduct_name());
		storedItemsReportRequest.setOne_buying_price(storedItemsReport.getOne_buying_price());
		storedItemsReportRequest.setOne_selling_price(storedItemsReport.getOne_selling_price());
		storedItemsReportRequest.setQuantity(storedItemsReport.getQuantity());
		storedItemsReportRequest.setBuying_price(storedItemsReport.getBuying_price());
		storedItemsReportRequest.setSelling_price(storedItemsReport.getSelling_price());
		storedItemsReportRequest.setProfit(storedItemsReport.getProfit());
		
		return storedItemsReportRequest;
	}
	
}