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
@Table(name = "Reports")
public class Reports{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reportsID;
	@NotEmpty
	@Column
	private LocalDateTime dateTime;
	@NotEmpty
	@Column
	private String reportsName;
	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL, mappedBy = "reports")
	private List<Reports> report;

	public int getReportsID() {
		return reportsID;
	}

	public void setReportsID(int reportsID) {
		this.reportsID = reportsID;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public String getReportsName() {
		return reportsName;
	}

	public void setReportsName(String reportsName) {
		this.reportsName = reportsName;
	}

	@Override
	public String toString() {
		return "Report [reportsID=" + reportID + ", dateTime=" + dateTime + ", reportsName=" + reportsName + "]";
	}

	
	
		
	
}