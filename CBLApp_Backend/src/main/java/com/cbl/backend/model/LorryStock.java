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
@Table(name = "LorryStock")
public class LorryStock {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int LorryStockID;
	@NotEmpty
	@Column
	private LocalDateTime DateTime;
	@NotEmpty
	@Column
	private String LorryStockName;
	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL, mappedBy = "report")
	private List<LorryStock> LorryStock;
	public int getLorryStocktID() {
		return LorryStockID;
	}
	public void setLorryStocktID(int lorryStocktID) {
		LorryStockID = lorryStocktID;
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
	public List<LorryStock> getLorryStock() {
		return LorryStock;
	}
	public void setLorryStock(List<LorryStock> lorryStock) {
		LorryStock = lorryStock;
	}
	
	@Override
	public String toString() {
		return "LorryStock [LorryStockID=" + LorryStockID + ", DateTime=" + DateTime + ", LorryStockName=" + LorryStockName + "]";
	}
}
	
