package com.cbl.backend.dto;

import java.time.LocalDate;
import java.util.Date;

public class SalesProductResponse {
	
	private int salesProductID;
	private String salesProductName;
	private float unitBuyingPrice;
	private float unitSellingPrice;
	private LocalDate date;
	private int pieces;
 	private float buyingPrice;
	private float sellingPrice;
	private float profit;
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
	public void setDate(LocalDate date) {
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
	public void setBuyingPrice(float buyingPrice) {
		this.buyingPrice = buyingPrice;
	}
	public float getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(float sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public float getProfit() {
		return profit;
	}
	public void setProfit(float profit) {
		this.profit = profit;
	}
	 
	@Override
	public String toString() {
		return "ProductResponse [salesProductID=" + salesProductID + ", salesProductName=" + salesProductName + ", date=" + date + 
				", unitBuyingPrice=" + unitBuyingPrice + ", unitSellingPrice=" + unitSellingPrice + ",pieces=" + pieces + 
				", buyingPrice=" + buyingPrice + ", sellingPrice=" + sellingPrice + ", profit=" + profit +" ]";
	} 
	

	
	 
}
