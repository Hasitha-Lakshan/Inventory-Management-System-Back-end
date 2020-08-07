package com.cbl.backend.model;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
	@Column(unique = true)
	private String LorryStockName;
	@OneToMany
	private List<Product> Products;
	@ManyToOne
	private InventoryManager inventoryManager;
	@ManyToOne
	private Lorry Lorry;
	
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
	public List<Product> getProduct() {
		return Products;
	}
	public void setProduct(List<Product> products) {
		Products = products;
	}
	public InventoryManager getInventoryManager() {
		return inventoryManager;
	}
	public void setInventoryManager(InventoryManager inventoryManager) {
		this.inventoryManager = inventoryManager;
	}
	public Lorry getLorry() {
		return Lorry;
	}
	public void setLorry(Lorry lorry) {
		Lorry = lorry;
	}
	@Override
	public String toString() {
		return "LorryStock [LorryStockID=" + LorryStockID + ", DatTime=" + DateTime + ", LorryStockName=" +
	LorryStockName + ", Products=" + Products+", lorry=" + Lorry + ", inventoryManager=" + inventoryManager+"]";
	}
}
