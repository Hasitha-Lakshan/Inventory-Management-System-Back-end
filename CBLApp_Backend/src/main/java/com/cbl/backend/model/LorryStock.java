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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "LorryStocks")
public class LorryStock {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int lorryStockID;
	@NotEmpty
	@Column
	private LocalDateTime dateTime;
	@NotEmpty
	@Column(unique = true)
	private String stockName;
	
	@ManyToOne
	private InventoryManager inventoryManager;

	@ManyToOne
	private Lorry lorry;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "lorryStocks")
	private List<Product> product;

	
	public int getLorryStockID() {
		return lorryStockID;
	}



	public void setLorryStockID(int lorryStockID) {
		this.lorryStockID = lorryStockID;
	}



	public LocalDateTime getDateTime() {
		return dateTime;
	}



	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
	


	public String getStockName() {
		return stockName;
	}



	public void setStockName(String stockName) {
		this.stockName = stockName;
	}



	public InventoryManager getInventoryManager() {
		return inventoryManager;
	}



	public void setInventoryManager(InventoryManager inventoryManager) {
		this.inventoryManager = inventoryManager;
	}



	public List<Product> getProduct() {
		return product;
	}



	public void setProduct(List<Product> product) {
		this.product = product;
	}



	public Lorry getLorry() {
		return lorry;
	}



	public void setLorry(Lorry lorry) {
		this.lorry = lorry;
	}



	@Override
	public String toString() {
		return "LorryStock [lorryStockID=" + lorryStockID + ", dateTime=" + dateTime + ", stockName=" + stockName
				+ ", inventoryManager=" + inventoryManager + ", lorry=" + lorry + ", product=" + product + "]";
	}


	
}
