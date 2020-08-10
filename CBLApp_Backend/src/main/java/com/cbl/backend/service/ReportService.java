
package com.cbl.backend.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbl.backend.dto.ProductResponse;
import com.cbl.backend.dto.ReportResponse;
import com.cbl.backend.dto.UserDetailsResponse;
import com.cbl.backend.model.PhoneNumber;
import com.cbl.backend.model.Product;
import com.cbl.backend.model.Report;
import com.cbl.backend.model.User;
import com.cbl.backend.repository.ProductRepository;
import com.cbl.backend.repository.ReportRepository;
import com.cbl.backend.repository.UserRepository;
@Service
public class ReportService {
	
	@Autowired
	private ReportRepository reportRepository;

	
	
	public List<ReportResponse> getAllReports() {
		List<Report> reports = reportRepository.findAll();
		return reports.stream().map(this::mapFromReportToDto).collect(Collectors.toList());
	}
	
	private ReportResponse mapFromReportToDto(Report report) {
		
		ReportResponse reportResponse = new ReportResponse();
		
		reportResponse.setReport_Id(report.getReportID());
		reportResponse.setDate(report.getDateTime());
		reportResponse.setReportName(report.getReportName());
		
		List<Product> productlist = new ArrayList<Product>();
		
		for(Product product : reportResponse.getProduct()) {
			
			Product product1 = new Product();
			
			product1.setProductID(product.getProductID());
			product1.setProductName(product.getProductName());
			product1.setUnitBuyingPrice(product.getUnitBuyingPrice());
			product1.setUnitSellingPrice(product.getUnitSellingPrice());
			product1.setDate(product.getDate());
			product1.setPieces(product.getPieces());
			product1.setBuyingPrice(product.getBuyingPrice());
			product1.setSellingPrice(product.getSellingPrice());
			product1.setProfit(product.getProfit());
			productlist.add(product1);
			
		}
		
		reportResponse.setProduct(productlist);
		
		System.out.println("AUA");
		return reportResponse;
	}
	
	
	public Report save(Report report) {
		return reportRepository.save(report);
	}
	
	public String delete(int id) {
		reportRepository.deleteById(id);
		return "deleted";
	}
	
	//Not sure	
	/*
	@Autowired
	private ProductRepository productRepository;

	public List<ProductResponse> getAllProducts() {
		
		List<Product> products = productRepository.findAll();
		
		return products.stream().map(this::mapFromProductToDto).collect(Collectors.toList());
	}

	private ProductResponse mapFromProductToDto(Product product) {
		
		ProductResponse productResponse = new ProductResponse();

		productResponse.setProductID(product.getProductID());
		productResponse.setDate(product.getDate());
		productResponse.setProductName(product.getProductName());
		productResponse.setUnitBuyingPrice(product.getUnitBuyingPrice());
		productResponse.setUnitSellingPrice(product.getUnitSellingPrice());
		productResponse.setPieces(product.getPieces());
		
		productResponse.setBuyingPrice(product.getBuyingPrice());
		productResponse.setSellingPrice(product.getSellingPrice());
		productResponse.setProfit(product.getProfit());

		
		return productResponse;
	}
	
*/
	
	
	
	
	
}