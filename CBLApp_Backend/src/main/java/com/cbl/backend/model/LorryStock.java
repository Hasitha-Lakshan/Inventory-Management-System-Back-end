package com.cbl.backend.model;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "LorryStock")
public class LorryStock {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int lorryStockID;
	@NotEmpty
	@Column
	private LocalDateTime dateTime;
	@NotEmpty
	@Column
	private String lorryStockName;
	
	@ManyToMany
	private List<Product> products = new ArrayList<Product>();
	
	@ManyToOne
	private InventoryManager inventoryManager;
	
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	@ManyToOne
	private Lorry lorry;
	
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
	public String getLorryStockName() {
		return lorryStockName;
	}
	public void setLorryStockName(String lorryStockName) {
		this.lorryStockName = lorryStockName;
	}
	public InventoryManager getInventoryManager() {
		return inventoryManager;
	}
	public void setInventoryManager(InventoryManager inventoryManager) {
		this.inventoryManager = inventoryManager;
	}
	public Lorry getLorry() {
		return lorry;
	}
	public void setLorry(Lorry lorry) {
		this.lorry = lorry;
	}
	@Override
	public String toString() {
		return "LorryStock [LorryStockID=" + lorryStockID + ", DatTime=" + dateTime + ", LorryStockName=" +
	lorryStockName + "inventoryManager=" + inventoryManager + "lorry=" + lorry + "product=" + products + "]";
	}
}
