package com.cbl.backend.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.cbl.backend.model.Product;

public class LorryStockRequest {
	private int lorryStockID;
	private LocalDateTime dateTime;
	private String lorryStockName;
	private List<Product> products;
	public int getLorryStockID() {
		return lorryStockID;
	}
	public void setLorryStockID(int lorryStockID) {
		this.lorryStockID = lorryStockID;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public String getLorryStockName() {
		return lorryStockName;
	}
	public void setLorryStockName(String lorryStockName) {
		this.lorryStockName = lorryStockName;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
}