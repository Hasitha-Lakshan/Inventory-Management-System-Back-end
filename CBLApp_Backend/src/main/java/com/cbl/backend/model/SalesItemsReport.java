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
	private LocalDateTime dateTime;
	@NotEmpty
	@Column
	private String salesItemsReportName;
	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL, mappedBy = "salesItemsReport")
	private List<SalesItemsReport> salesItemsReport;

	public int getSalesItemsReportID() {
		return salesItemsReportID;
	}

	public void setSalesItemsReportID(int salesItemsReportID) {
		this.salesItemsReportID = salesItemsReportID;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public String getSalesItemsReportName() {
		return salesItemsReportName;
	}

	public void setSalesItemsReportName(String salesItemsReportName) {
		this.salesItemsReportName = salesItemsReportName;
	}

	@Override
	public String toString() {
		return "SalesItemsReport [salesItemsReportID=" + salesItemsReportID + ", dateTime=" + dateTime + ", salesItemsReportName=" + salesItemsReport + "]";
	}

	
	
	
		
	
}