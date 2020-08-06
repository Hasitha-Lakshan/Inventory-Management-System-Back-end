package com.cbl.backend.dto;

import java.time.LocalDate;
import java.util.Date;

public class ProductResponse {
	
	private int productID;
	private String productName;
	private int unitBuyingPrice;
	private int unitSellingPrice;
	private LocalDate date;
	private int pieces;
	private int buyingPrice=unitBuyingPrice*pieces;
	private int sellingPrice=unitSellingPrice*pieces;
	private int profit=sellingPrice-buyingPrice;
//	private SalesItemsReport salesItemsReport;
	
	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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

	public int getBuyingPrice() {
		return buyingPrice;
	}

	public void setBuyingPrice(int buyingPrice) {
		this.buyingPrice = buyingPrice;
	}

	public int getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(int sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public int getProfit() {
		return profit;
	}

	public void setProfit(int profit) {
		this.profit = profit;
	}

	@Override
	public String toString() {
		return "ProductResponse [productID=" + productID + ", productName=" + productName + ", unitBuyingPrice="
				+ unitBuyingPrice + ", unitSellingPrice=" + unitSellingPrice + ", date=" + date + ", pieces=" + pieces
				+ ", buyingPrice=" + buyingPrice + ", sellingPrice=" + sellingPrice + ", profit="
				+ profit + "]";
	} 
	

	
	 
}