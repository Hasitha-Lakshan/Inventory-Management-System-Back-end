package com.cbl.backend.dto;

import java.util.Date;

public class SalesProductResponse {
	
	private int salesProductID;
	private String salesProductName;
	private int unitBuyingPrice;
	private int unitSellingPrice;
	private Date date;
	private int pieces;
	private int boxes;
	private int buyingPrice;
	private int sellingPrice;
	private int profit=sellingPrice-buyingPrice;
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
	public int getUnitBuyingPrice() {
		return unitBuyingPrice;
	}
	public void setUnitBuyingPrice(int unitBuyingPrice) {
		this.unitBuyingPrice = unitBuyingPrice;
	}
	public int getUnitSellingPrice() {
		return unitSellingPrice;
	}
	public void setUnitSellingPrice(int unitSellingPrice) {
		this.unitSellingPrice = unitSellingPrice;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getPieces() {
		return pieces;
	}
	public void setPieces(int pieces) {
		this.pieces = pieces;
	}
	public int getProfit() {
		return profit;
	}
	public void setProfit(int profit) {
		this.profit = profit;
	}
	public int getBoxes() {
		return boxes;
	}
	public void setBoxes(int boxes) {
		this.boxes = boxes;
	}
	@Override
	public String toString() {
		return "ProductResponse [salesProductID=" + salesProductID + ", salesProductName=" + salesProductName + ", date=" + date + 
				", unitBuyingPrice=" + unitBuyingPrice + ", unitSellingPrice=" + unitSellingPrice + ",pieces=" + pieces + 
				", boxes="+ boxes + ", buyingPrice=" + buyingPrice + ", sellingPrice=" + sellingPrice + ", profit=" + profit +" ]";
	} 
	

	
	 
}