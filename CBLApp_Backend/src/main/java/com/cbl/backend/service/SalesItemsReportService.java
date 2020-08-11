package com.cbl.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


import com.cbl.backend.dto.SalesItemsReportResponse;
import com.cbl.backend.dto.UserDetailsResponse;
import com.cbl.backend.model.SalesItemsReport;
import com.cbl.backend.model.SalesProduct;
import com.cbl.backend.model.User;
import com.cbl.backend.repository.ReportRepository;
import com.cbl.backend.repository.ProductRepository;
import com.cbl.backend.repository.UserRepository;
@Service
public class SalesItemsReportService {
	
	@Autowired
	private ReportRepository reportRepository;

	public List<SalesItemsReport> getAll() {
		List<SalesItemsReport> list = reportRepository.findAll();
		return list;
	}
	
	public SalesItemsReport save(SalesItemsReport report) {
		return reportRepository.save(report);
	}
	
	public String delete(int id) {
		reportRepository.deleteById(id);
		return "deleted";
	}
	
	@Autowired
	private ProductRepository productRepository;

	public List<SalesProduct> getAllPoducts() {
		
		List<SalesProduct> users = productRepository.findAll();

 				return users.stream().map(this::mapFromSalesProductToDto).collect(Collectors.toList());
	}

	private SalesProduct mapFromSalesProductToDto(SalesProduct salesProduct) {
		
		SalesProduct salesProductResponse = new SalesProduct();

		salesProductResponse.setSalesProductID(salesProduct.getSalesProductID());
		salesProductResponse.setDate(salesProduct.getDate());
		salesProductResponse.setSalesProductName(salesProduct.getSalesProductName());
		salesProductResponse.setUnitBuyingPrice(salesProduct.getUnitBuyingPrice());
		salesProductResponse.setUnitSellingPrice(salesProduct.getUnitSellingPrice());
		salesProductResponse.setPieces(salesProduct.getPieces());
		
		salesProductResponse.setBuyingPrice(salesProduct.getBuyingPrice());
		salesProductResponse.setSellingPrice(salesProduct.getSellingPrice());
		salesProductResponse.setProfit(salesProduct.getProfit());

		
		return salesProductResponse;
	}
}
