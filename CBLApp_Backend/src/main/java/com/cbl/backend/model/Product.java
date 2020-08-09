package com.cbl.backend.model;

import java.time.LocalDate;
//import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Product")
public class Product{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productID;
	@NotEmpty
	@Column
	private String productName;
	@NotEmpty
	@Column
	private float unitBuyingPrice;
	@NotEmpty
	@Column
	private float unitSellingPrice;
	@NotEmpty
	@Column
	private LocalDate date;
	@Column
	private int pieces;
	@Column
	private float buyingPrice;
	@Column
	private float sellingPrice;
	@Column
	private float profit;
	
	//@ManyToOne
	@ManyToOne
	@JoinColumn(name = "reportID")
	@JsonIgnore
	private Report reportID;
	
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
	public void setBuyingPrice(float b) {
		this.buyingPrice = this.unitBuyingPrice*this.pieces;
	}
	public float getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(float s) {
		this.sellingPrice = this.unitSellingPrice*this.pieces;
	}
	public float getProfit() {
		return profit;
	}
	public void setProfit(float p) {
		this.profit = this.sellingPrice-this.buyingPrice;
	}
	public Report getReportID() {
		return reportID;
	}
	public void setReportID(Report reportID) {
		this.reportID = reportID;
	}
	
	
	
	
	
}