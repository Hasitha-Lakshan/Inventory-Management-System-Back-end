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
@Table(name = "Report")
public class Report{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reportID;
	@NotEmpty
	@Column
	private String reportName;
	@NotEmpty
	@Column
	private LocalDateTime dateTime;
	
	//@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL, mappedBy = "report")
	//private List<Report> report;
	
	public int getReportID() {
		return reportID;
	}
	public void setReportID(int reportID) {
		this.reportID = reportID;
	}
	public String getReportName() {
		return reportName;
	}
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
	//@Override
	//public String toString() {
	//	return "Report [reportID=" + reportID + ", reportName=" + reportName + ", dateTime=" + dateTime + "]";
	//}
	
}