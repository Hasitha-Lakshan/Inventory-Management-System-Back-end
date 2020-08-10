package com.cbl.backend.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbl.backend.dto.SalesProductResponse;
import com.cbl.backend.dto.UserDetailsResponse;
import com.cbl.backend.model.SalesProduct;
import com.cbl.backend.model.User;
import com.cbl.backend.repository.ProductRepository;
import com.cbl.backend.repository.UserRepository;
@Service
public class SalesProductService {
	
	@Autowired
	private ProductRepository userRepository;

	public List<SalesProduct> getAll() {
		List<SalesProduct> list = userRepository.findAll();
		return list;
	}
	
	public SalesProduct save(SalesProduct product) {
		return userRepository.save(product);
	}
	
	public String delete(int id) {
		userRepository.deleteById(id);
		return "deleted";
	}
	
	
	// Search in a Date range part
	
	public List<SalesProduct> getDateSortedProducts(LocalDate startDate,LocalDate endDate){
		List<SalesProduct> sorted = null;
		List<SalesProduct> list = this.getAll();
		for(int i = 0; i < list.size();i++) {
			SalesProduct p = list.get(i);
			if( (p.getDate().isAfter(startDate)) && (p.getDate().isBefore(endDate))) {
				sorted.add(p);
			}
		}
		return sorted;
	}
	
	
	// Total buying price
	
	public float getTotalBuyingPrice(LocalDate startDate,LocalDate endDate) {
		List<SalesProduct> sorted = this.getDateSortedProducts(startDate, endDate);
		float totalBuyingPrice = 0;
		for(int i=0;i < sorted.size(); i++) {
			SalesProduct p = sorted.get(i);
			totalBuyingPrice = totalBuyingPrice + p.getBuyingPrice();
		}
		return totalBuyingPrice;
	}

	
}
