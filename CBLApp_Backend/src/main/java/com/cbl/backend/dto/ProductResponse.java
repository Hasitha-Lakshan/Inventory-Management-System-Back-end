package com.cbl.backend.dto;

import java.time.LocalDate;
import java.util.Date;

public class ProductResponse {
	
	private int productID;
	private String productName;
	private float unitBuyingPrice;
	private float unitSellingPrice;
	private LocalDate date;
	private int pieces;
	private float buyingPrice=unitBuyingPrice*pieces;
	private float sellingPrice=unitSellingPrice*pieces;
	private float profit=sellingPrice-buyingPrice;
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
		return "ProductResponse [productID=" + productID + ", productName=" + productName + ", unitBuyingPrice="
				+ unitBuyingPrice + ", unitSellingPrice=" + unitSellingPrice + ", date=" + date + ", pieces=" + pieces
				+ ", buyingPrice=" + buyingPrice + ", sellingPrice=" + sellingPrice + ", profit=" + profit + "]";
	}
	
	
	
}