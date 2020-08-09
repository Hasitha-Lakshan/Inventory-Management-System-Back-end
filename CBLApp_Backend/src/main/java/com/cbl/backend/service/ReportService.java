package com.cbl.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbl.backend.dto.ProductResponse;
import com.cbl.backend.dto.ReportResponse;
import com.cbl.backend.dto.UserDetailsResponse;
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

	public List<Report> getAll() {
		List<Report> list = reportRepository.findAll();
		return list;
	}
	
	public Report save(Report report) {
		return reportRepository.save(report);
	}
	
	public String delete(int id) {
		reportRepository.deleteById(id);
		return "deleted";
	}
	
	//Not sure	
	@Autowired
	private ProductRepository productRepository;

	public List<ProductResponse> getAllPoducts() {
		
		List<Product> users = productRepository.findAll();
		
		return users.stream().map(this::mapFromProductToDto).collect(Collectors.toList());
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
	
}