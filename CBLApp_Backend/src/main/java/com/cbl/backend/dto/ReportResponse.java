package com.cbl.backend.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.cbl.backend.model.Product;

public class ReportResponse {

	private int report_Id;
	private LocalDateTime date;
	private String reportName;
	private List<Product> product;

	public int getReport_Id() {
		return report_Id;
	}

	public void setReport_Id(int report_Id) {
		this.report_Id = report_Id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "ReportResponse [report_Id=" + report_Id + ", date=" + date + ", reportName=" + reportName + "]";
	}
}