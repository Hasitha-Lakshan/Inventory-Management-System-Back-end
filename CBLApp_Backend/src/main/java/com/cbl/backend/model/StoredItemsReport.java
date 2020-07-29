package com.cbl.backend.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="StoredItemsReport")
public class StoredItemsReport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int report_Id;
	@NotEmpty
	@Column
	private Date date;
	@NotEmpty
	@Column
	private String product_name;
	@NotEmpty
	@Column
	private int one_buying_price;
	@NotEmpty
	@Column
	private int one_selling_price;
	@NotEmpty
	@Column
	private int quantity;
	@NotEmpty
	@Column
	private int buying_price;
	@NotEmpty
	@Column
	private int selling_price;
	@NotEmpty
	@Column
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


	public int getOne_buying_price() {
		return one_buying_price;
	}


	public void setOne_buying_price(int one_buying_price) {
		this.one_buying_price = one_buying_price;
	}


	public int getOne_selling_price() {
		return one_selling_price;
	}


	public void setOne_selling_price(int one_selling_price) {
		this.one_selling_price = one_selling_price;
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
		return "StoredItemsReport [report_Id=" + report_Id + ", date=" + date + ", product_name=" + product_name
				+ ", one_buying_price=" + one_buying_price + ", one_selling_price=" + one_selling_price + ", quantity="
				+ quantity + ", buying_price=" + buying_price + ", selling_price=" + selling_price + ", profit="
				+ profit + "]";
	}


}