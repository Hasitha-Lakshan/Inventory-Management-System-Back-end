package com.cbl.backend.dto;

import java.util.Date;

public class ReportResponse{
	
	private int report_Id;
	private Date date;
	private String product_name;
	private int unit_buying_price;
	private int unit_selling_price;
	private int quantity;
	private int buying_price;
	private int selling_price;
	private int profit;
	
	public int getReport_Id() {
		return report_Id;
	}

	public void setReport_Id(int report_Id) {
		this.report_Id = report_Id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getUnit_buying_price() {
		return unit_buying_price;
	}

	public void setUnit_buying_price(int unit_buying_price) {
		this.unit_buying_price = unit_buying_price;
	}

	public int getUnit_selling_price() {
		return unit_selling_price;
	}

	public void setUnit_selling_price(int unit_selling_price) {
		this.unit_selling_price = unit_selling_price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getBuying_price() {
		return buying_price;
	}

	public void setBuying_price(int buying_price) {
		this.buying_price = buying_price;
	}

	public int getSelling_price() {
		return selling_price;
	}

	public void setSelling_price(int selling_price) {
		this.selling_price = selling_price;
	}

	public int getProfit() {
		return profit;
	}

	public void setProfit(int profit) {
		this.profit = profit;
	}

	@Override
	public String toString() {
		return "ReportResponse [report_Id=" + report_Id + ", date=" + date + ", product_name=" + product_name
				+ ", unit_buying_price=" + unit_buying_price + ", unit_selling_price=" + unit_selling_price
				+ ", quantity=" + quantity + ", buying_price=" + buying_price + ", selling_price=" + selling_price
				+ ", profit=" + profit + "]";
	}

	
}