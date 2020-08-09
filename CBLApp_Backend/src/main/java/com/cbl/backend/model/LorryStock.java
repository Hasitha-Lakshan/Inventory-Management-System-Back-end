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
	@Column(name="DateTime")
	private LocalDateTime DateTime;
	@NotEmpty
	@Column(name="LorryStockName")
	private String LorryStockName;
	
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
	
	public Lorry getLorry() {
		return lorry;
	}
	public void setLorry(Lorry lorry) {
		this.lorry = lorry;
	}
	public InventoryManager getInventoryManager() {
		return inventoryManager;
	}
	public void setInventoryManager(InventoryManager inventoryManager) {
		this.inventoryManager = inventoryManager;
	}
	public int getLorryStockID() {
		return lorryStockID;
	}
	public void setLorryStockID(int lorryStockID) {
		this.lorryStockID = lorryStockID;
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
	
	
	@Override
	public String toString() {
		return "LorryStock [LorryStockID=" + lorryStockID + ", DatTime=" + DateTime + ", LorryStockName=" +
	LorryStockName + "inventoryManager=" + inventoryManager + "lorry=" + lorry + "product=" + products + "]";
	}
}
