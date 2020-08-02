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
@Table(name="SalesProduct")
public class SalesProduct{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int salesProductID;
	@NotEmpty
	@Column
	private String salesProductName;
	@NotEmpty
	@Column
	private int unitBuyingPrice;
	@NotEmpty
	@Column
	private int unitSellingPrice;
	@NotEmpty
	@Column
	private Date date;
	@Column
	private int pieces;
	@Column
	private int boxes;
	@Column
	private int buyingPrice;
	@Column
	private int sellingPrice;
	@Column
	private int profit=sellingPrice-buyingPrice;

	
	@ManyToOne
	@JoinColumn(name = "salesItemsReportID")
	@JsonIgnore
	//private SalesItemsReport;
	
	
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
	
	
}