package com.cbl.backend.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.cbl.backend.model.Product;

public class LorryStockRequest {
	private LocalDateTime date;
	private String StockName;
	private List<Product> products;
	

	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	public String getStockName() {
		return StockName;
	}
	public void setStockName(String stockName) {
		StockName = stockName;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
	

}
