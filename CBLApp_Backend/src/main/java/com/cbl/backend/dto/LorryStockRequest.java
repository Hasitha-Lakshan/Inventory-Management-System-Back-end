package com.cbl.backend.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.cbl.backend.model.Product;

public class LorryStockRequest {
	private int LorryStockID;
	private LocalDateTime DateTime;
	private String LorryStockName;
	private List<Product> Products;
	
	
	public int getLorryStockID() {
		return LorryStockID;
	}
	public void setLorryStockID(int lorryStockID) {
		LorryStockID = lorryStockID;
	}
	public LocalDateTime getDateTime() {
		return DateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		DateTime = dateTime;
	}
	public String getLorryStockName() {
		return LorryStockName;
	}
	public void setLorryStockName(String lorryStockName) {
		LorryStockName = lorryStockName;
	}
	public List<Product> getProduct() {
		return Products;
	}
	public void setProduct(List<Product> product) {
		Products = product;
	}
	
}
