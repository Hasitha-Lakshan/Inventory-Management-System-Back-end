package com.cbl.backend.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "LorryStock")
public class LorryStock {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int LorryStockID;
	@NotEmpty
	@Column
	private LocalDateTime DateTime;
	@NotEmpty
	@Column(unique = true)
	private String LorryStockName;

	@ManyToOne
	private Lorry lorry;
	
	
	
	public int getLorryStockID() {
		return LorryStockID;
	}
	public void setLorryStockID(int lorryStockID) {
		LorryStockID = lorryStockID;
	}
	public LocalDateTime getDateTime() {
		return DateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		DateTime = dateTime;
	}
	public String getLorryStockName() {
		return LorryStockName;
	}
	public void setLorryStockName(String lorryStockName) {
		LorryStockName = lorryStockName;
	}
	
	
	public Lorry getLorry() {
		return lorry;
	}
	public void setLorry(Lorry lorry) {
		this.lorry = lorry;
	}
	
	
	@Override
	public String toString() {
		return "LorryStock [LorryStockID=" + LorryStockID + ", DatTime=" + DateTime + ", LorryStockName=" +
	LorryStockName + ",lorry=" + lorry + "]";
	}
	
}
