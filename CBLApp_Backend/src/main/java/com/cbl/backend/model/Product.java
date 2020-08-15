package com.cbl.backend.model;

import java.time.LocalDate;
//import java.util.Date;

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
@Table(name = "Products")
public class Product {

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

	@ManyToOne
	@JoinColumn(name = "reportID")
	@JsonIgnore
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

	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

	public float getBuyingPrice() {
		return buyingPrice;
	}

	public void setBuyingPrice(float unitBuyingPrice, int pieces) {
		this.buyingPrice = unitBuyingPrice * pieces;
	}

	public float getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(float unitSellingPrice, int pieces) {
		this.sellingPrice = unitSellingPrice * pieces;
	}

	public float getProfit() {
		return profit;
	}

	public void setProfit(float sellingPrice, float buyingPrice) {
		this.profit = sellingPrice - buyingPrice;
	}
}