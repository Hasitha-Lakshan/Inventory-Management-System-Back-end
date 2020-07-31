package com.cbl.backend.dto;

import java.util.Date;

import com.cbl.backend.model.Report;

public class ProductResponse{
	
	private int productID;
	private String productName;
	private int buyingPriceOf1;
	private int sellingPriceOf1;
	private Date date;
	private int pieces;
	private int buyingPrice;
	private int sellingPrice;
	private int profit=sellingPrice-buyingPrice;
	private Report report;
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
	public int getBuyingPriceOf1() {
		return buyingPriceOf1;
	}
	public void setBuyingPriceOf1(int buyingPriceOf1) {
		this.buyingPriceOf1 = buyingPriceOf1;
	}
	public int getSellingPriceOf1() {
		return sellingPriceOf1;
	}
	public void setSellingPriceOf1(int sellingPriceOf1) {
		this.sellingPriceOf1 = sellingPriceOf1;
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
	public Report getReport() {
		return report;
	}
	public void setReport(Report report) {
		this.report = report;
	}
	@Override
	public String toString() {
		return "ProductResponse [productID=" + productID + ", productName=" + productName + ", buyingPriceOf1="
				+ buyingPriceOf1 + ", sellingPriceOf1=" + sellingPriceOf1 + ", date=" + date + ", pieces=" + pieces
				+ ", buyingPrice=" + buyingPrice + ", sellingPrice=" + sellingPrice + ", profit=" + profit + ", report="
				+ report + "]";
	}
	
	
	
	
}