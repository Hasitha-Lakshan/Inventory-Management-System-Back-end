package com.cbl.backend.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbl.backend.dto.UserDetailsResponse;
import com.cbl.backend.model.Product;
import com.cbl.backend.model.User;
import com.cbl.backend.repository.ProductRepository;
import com.cbl.backend.repository.UserRepository;
@Service
public class ProductService {
	
	@Autowired
	private ProductRepository userRepository;

	public List<Product> getAll() {
		List<Product> list = userRepository.findAll();
		return list;
	}
	
	public Product save(Product product) {
		return userRepository.save(product);
	}
	
	public String delete(int id) {
		userRepository.deleteById(id);
		return "deleted";
	}

	//get totalprofit part
	public List<Product> getDateSortedProducts(LocalDate startDate,LocalDate endDate){
		List<Product> sorted = null;
		List<Product> list = this.getAll();
		for(int i = 0; i < list.size();i++) {
			Product p = list.get(i);
			if( (p.getDate().isAfter(startDate)) && (p.getDate().isBefore(endDate))) {
				sorted.add(p);
			}
		}
		return sorted;
	}
	
	public float getTotalBuyingPrice(LocalDate startDate,LocalDate endDate) {
		List<Product> sorted = this.getDateSortedProducts(startDate, endDate);
		float totalBuyingPrice = 0;
		for(int i=0;i < sorted.size(); i++) {
			Product p = sorted.get(i);
			totalBuyingPrice = totalBuyingPrice + p.getBuyingPrice();
		}
		return totalBuyingPrice;
	}
	
	
}