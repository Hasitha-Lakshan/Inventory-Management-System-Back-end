package com.cbl.backend.dto;

import java.time.LocalDate;
import java.util.Date;

public class SalesProductRequest {
	
	private int salesProductID;
	private String salesProductName;
	private float unitBuyingPrice;
	private float unitSellingPrice;
	private LocalDate date;
	private int pieces;
	private float buyingPrice;
	private float sellingPrice;
	private float profit=sellingPrice-buyingPrice;
//	private SalesItemsReport salesItemsReport;
	
	public int getSalesProductID() {
		return salesProductID;
	}
	public void setSalesProductID(int salesProductID) {
		this.salesProductID = salesProductID;
	}
	public String getSalesProductName() {
		return salesProductName;
	}
	public void setSalesProductName(String salesProductName) {
		this.salesProductName = salesProductName;
	}
	public float getUnitBuyingPrice() {
		return unitBuyingPrice;
	}
	public void setUnitBuyingPrice(float unitBuyingPrice) {
		this.unitBuyingPrice = unitBuyingPrice;
	}
	public float getUnitSellingPrice() {
		return unitSellingPrice;
	}
	public void setUnitSellingPrice(float unitSellingPrice) {
		this.unitSellingPrice = unitSellingPrice;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setLocalDate(LocalDate date) {
		this.date = date;
	}
	public int getPieces() {
		return pieces;
	}
	public void setPieces(int pieces) {
		this.pieces = pieces;
	}
	public float getBuyingPrice() {
		return buyingPrice;
	}
	public void setBuyingPrice() {
		this.buyingPrice = this.unitBuyingPrice*this.pieces;
	}
	public float getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice() {
		this.sellingPrice =this.unitSellingPrice*this.pieces;
	}
	public float getProfit() {
		return profit;
	}
	public void setProfit() {
		this.profit = this.sellingPrice-this.buyingPrice;
	}
	
	
	 
}
