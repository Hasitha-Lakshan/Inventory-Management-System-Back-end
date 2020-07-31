package com.cbl.backend.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Product")

public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productID;
	@NotEmpty
	@Column
	private String productName;
	@NotEmpty
	@Column
	private int buyingPriceOf1;
	@NotEmpty
	@Column
	private int sellingPriceOf1;
	@NotEmpty
	@Column
	private Date date;
	@Column
	private int boxes;
	@Column
	private int pieces;
	@Column
	private int buyingPrice;
	@Column
	private int sellingPrice;
	@Column
	private int profit=sellingPrice-buyingPrice;
	
	@ManyToOne
	@JoinColumn(name = "LorryStockID")
	@JsonIgnore
	private LorryStock LorryStock;
	
	
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
	public int getBoxes() {
		return boxes;
	}
	public void setBoxes(int boxes) {
		this.boxes = boxes;
	}
	
	
	
}
	


