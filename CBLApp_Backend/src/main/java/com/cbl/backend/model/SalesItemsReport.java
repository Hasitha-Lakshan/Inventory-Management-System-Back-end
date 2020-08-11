package com.cbl.backend.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "SalesItemsReport")
public class SalesItemsReport{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int salesItemsReportID;
	@NotEmpty
	@Column
	private String salesItemsReportName;
	@NotEmpty
	@Column
	private LocalDateTime dateTime;
  
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "salesItemsReportID")
	private List<SalesProduct> salesProduct;

	public int getSalesItemsReportID() {
		return salesItemsReportID;
	}

	public void setSalesItemsReportID(int salesItemsReportID) {
		this.salesItemsReportID = salesItemsReportID;
	}
	
	public String getSalesItemsReportName() {
		return salesItemsReportName;
	}

	public void setSalesItemsReportName(String salesItemsReportName) {
		this.salesItemsReportName = salesItemsReportName;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public List<SalesProduct> getSalesProduct() {
		return salesProduct;
	}

	public void setSalesProduct(List<SalesProduct> salesProduct) {
		this.salesProduct = salesProduct;
	}
 
//	@Override
//	public String toString() {
//		return "ReportResponse [salesItemsReport_Id=" + salesItemsReport_Id + ", date=" + date + ", salesProduct_name=" + salesProduct_name
//				+ ", unit_buying_price=" + unit_buying_price + ", unit_selling_price=" + unit_selling_price + ", quantity="
//				+ quantity + ", buying_price=" + buying_price + ", selling_price=" + selling_price + ", profit="
//				+ profit + ", ]";
//	}

		
		
	
}