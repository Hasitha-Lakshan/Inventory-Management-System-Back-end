package com.cbl.backend.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.cbl.backend.model.Report;

public class ReportRequest{
	
	private int reportID;
	private LocalDateTime dateTime;
	private String reportName;
	private List<Report> report;
	
	
	public int getReportID() {
		return reportID;
	}
	public void setReportID(int reportID) {
		this.reportID = reportID;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public String getReportName() {
		return reportName;
	}
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	public List<Report> getReport() {
		return report;
	}
	public void setReport(List<Report> report) {
		this.report = report;
	}
	
	
}