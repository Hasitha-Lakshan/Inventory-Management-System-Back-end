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
@Table(name="Report")
public class Report {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int report_ID;
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
	
	
	@Override
	public String toString() {
		return "Report [report_ID=" + report_ID + ", date=" + date + ", product_name=" + product_name + ", one_buying_price=" + one_buying_price
				+ ", one_selling_price=" + one_selling_price + ", quantity=" + quantity + ", addressLine3=" + buying_price
				+ ", selling_price=" + selling_price + "]";
	}
	
}