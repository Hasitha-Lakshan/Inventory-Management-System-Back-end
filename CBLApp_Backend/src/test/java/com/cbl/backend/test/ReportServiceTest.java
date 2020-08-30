package com.cbl.backend.test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.time.LocalDateTime;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import com.cbl.backend.dto.ReportRequest;

import com.cbl.backend.model.Product;
import com.cbl.backend.model.Report;
import com.cbl.backend.model.Shops;
import com.cbl.backend.repository.ReportRepository;
import com.cbl.backend.service.ReportService;

@SpringBootTest
public class ReportServiceTest{
	
	@Autowired
	private ReportService service;
	@MockBean
	private ReportRepository repository;
	
	
	@Test
	public void saveReport() {
		
		Report report1 = new Report();
		
		ReportRequest rq  = new ReportRequest();
		
		Product product1 = new Product();
		List<Product> productList1 = new ArrayList<Product>();
		
		product1.setProductName("Cracker");
		product1.setUnitBuyingPrice(10);
		product1.setUnitSellingPrice(20);
		product1.setDate(null);
		product1.setPieces(3);
		product1.setBuyingPrice(10, 3);
		product1.setSellingPrice(20, 3);
		product1.setReport(report1);
		product1.setProfit(product1.getSellingPrice(), product1.getBuyingPrice());
		
		productList1.add(product1);
		
		
		rq.setReportName("Report 01");
		rq.setDate(null);
		rq.setProducts(productList1);
		
		
		when(repository.save(report1)).thenReturn(report1);
		assertEquals(true,service.saveReport(rq));
	} 
	
	
	
	
	@Test
	public void getAllReports() {
		
		List<Report> reports = new ArrayList<Report>();
		
		Report report  = new Report();
		
		Product product = new Product();
		List<Product> productList = new ArrayList<Product>();
		
		product.setProductName("Cracker");
		product.setUnitBuyingPrice(10);
		product.setUnitSellingPrice(20);
		product.setDate(null);
		product.setPieces(3);
		product.setBuyingPrice(10, 3);
		product.setSellingPrice(20, 3);
		product.setReport(report);
		product.setProfit(product.getSellingPrice(), product.getBuyingPrice());
		
		productList.add(product);
		
		report.setReportID(1);
		report.setReportName("Report 01");
		report.setDateTime(null);
		report.setProduct(productList);
		reports.add(report);
		
		when(repository.findAll()).thenReturn(reports);
		assertEquals(1, service.getAllReports().size());
	}
	
	
	@Test
	public void findReport() {

		List<Report> report2 = new ArrayList<Report>();
	/*	Report report2 = new Report(); */

		Report reportf= new Report();
		
		Product product2 = new Product();
		List<Product> productListf = new ArrayList<Product>();
		
		product2.setProductName("Cracker");
		product2.setUnitBuyingPrice(10);
		product2.setUnitSellingPrice(20);
		product2.setDate(null);
		product2.setPieces(3);
		product2.setBuyingPrice(10, 3);
		product2.setSellingPrice(20, 3);
		product2.setReport(reportf);
		product2.setProfit(product2.getSellingPrice(), product2.getBuyingPrice());
		
		productListf.add(product2);
		
		reportf.setReportID(1);
		reportf.setReportName("Report 01");
		reportf.setDateTime(null);
		reportf.setProduct(productListf);
		report2.add(reportf);
		
		int reportid =1 ;
		when(repository.findByReportID(reportid)).thenReturn(reportf);
		assertEquals(1, service.findReport(reportid).getReport_Id());
	
	}
}