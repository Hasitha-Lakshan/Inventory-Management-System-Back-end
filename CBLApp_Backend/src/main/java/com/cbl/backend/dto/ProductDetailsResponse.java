package com.cbl.backend.dto;

import com.cbl.backend.model.Invoice;
import com.cbl.backend.model.User;


public class ProductDetailsResponse {
	
	private int ProductId;
	private String ProductName;
	private String Date;
	private boolean Buying_Priceof1;
	private boolean Selling_Priceof1;
	private int NumberOfReceived;
	private boolean BuyingPrice;
	private int Boxes;
	private int Pieces;
	private boolean Profit;
	private User user;
	private Invoice InvoiceId;
	public int getProductId() {
		return ProductId;
	}
	public void setProductId(int productId) {
		ProductId = productId;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public boolean isBuying_Priceof1() {
		return Buying_Priceof1;
	}
	public void setBuying_Priceof1(boolean buying_Priceof1) {
		Buying_Priceof1 = buying_Priceof1;
	}
	public boolean isSelling_Priceof1() {
		return Selling_Priceof1;
	}
	public void setSelling_Priceof1(boolean selling_Priceof1) {
		Selling_Priceof1 = selling_Priceof1;
	}
	public int getNumberOfReceived() {
		return NumberOfReceived;
	}
	public void setNumberOfReceived(int numberOfReceived) {
		NumberOfReceived = numberOfReceived;
	}
	public boolean isBuyingPrice() {
		return BuyingPrice;
	}
	public void setBuyingPrice(boolean buyingPrice) {
		BuyingPrice = buyingPrice;
	}
	public int getBoxes() {
		return Boxes;
	}
	public void setBoxes(int boxes) {
		Boxes = boxes;
	}
	public int getPieces() {
		return Pieces;
	}
	public void setPieces(int pieces) {
		Pieces = pieces;
	}
	public boolean isProfit() {
		return Profit;
	}
	public void setProfit(boolean profit) {
		Profit = profit;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Invoice getInvoiceId() {
		return InvoiceId;
	}
	public void setInvoiceId(Invoice invoiceId) {
		InvoiceId = invoiceId;
	}
	
	
	
	

}
