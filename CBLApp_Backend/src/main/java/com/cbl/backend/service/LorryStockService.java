package com.cbl.backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbl.backend.dto.LorryStockRequest;
import com.cbl.backend.model.LorryStock;
import com.cbl.backend.model.Product;
import com.cbl.backend.repository.LorryStockRepository;

@Service
public class LorryStockService {
	
	@Autowired
	private LorryStockRepository lorryStockRepository;
	
	public boolean submit(LorryStockRequest lorryStockRequest) {
		LorryStock LorryStock = new LorryStock();
		List<Product> productList = new ArrayList<Product>();
		
		LorryStock.setLorryStockID(lorryStockRequest.getLorryStockID());
		LorryStock.setLorryStockName(lorryStockRequest.getLorryStockName());
		LorryStock.setDateTime(lorryStockRequest.getDateTime());
		
		for(Product product : lorryStockRequest.getProducts()) {
			
			Product Product = new Product();
			
			Product.setProductName(Product.getProductName());
			Product.setUnitSellingPrice(Product.getUnitSellingPrice());
			Product.setUnitBuyingPrice(Product.getUnitBuyingPrice());
			Product.setPieces(Product.getPieces());
			
			productList.add(product);
		}
		
		LorryStock.setProducts(productList);
		lorryStockRepository.save(LorryStock);
		
	return true;
		
}

}
