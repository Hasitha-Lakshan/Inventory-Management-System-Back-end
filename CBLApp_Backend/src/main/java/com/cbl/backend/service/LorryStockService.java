package com.cbl.backend.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbl.backend.dto.LorryStockRequest;
import com.cbl.backend.model.LorryStock;
import com.cbl.backend.model.Product;

@Service
public class LorryStockService {
	
	@Autowired
	private LorryStock LorryStock;
	
	public boolean submit(LorryStockRequest lorryStockRequest) {
		List<Product> productList = new ArrayList<Product>();
		
		Product Product = new Product();
		
		Product.setProductName(Product.getProductName());
		Product.setBuyingPriceOf1(Product.getBuyingPriceOf1());
		Product.setSellingPriceOf1(Product.getSellingPriceOf1());
		Product.setPieces(Product.getPieces());
		
		productList.add(Product);
		
		LorryStock.setProduct(productList);
	return true;
		
}

}

