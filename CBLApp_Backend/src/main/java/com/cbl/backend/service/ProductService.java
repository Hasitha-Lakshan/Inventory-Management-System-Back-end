package com.cbl.backend.service;

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
	
	
}