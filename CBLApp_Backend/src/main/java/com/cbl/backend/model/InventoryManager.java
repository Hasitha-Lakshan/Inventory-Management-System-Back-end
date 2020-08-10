package com.cbl.backend.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "InventoryManagers")
public class InventoryManager {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int inventoryManagerID;
	//@OneToOne
	//@JoinColumn(name = "userID")
	//@JsonIgnore
	//private User user;
	
	@OneToMany(mappedBy = "inventoryManager")
	private List<Lorry> lorry =new ArrayList<Lorry>();
	
	@OneToMany(mappedBy = "inventoryManager")
	private List<LorryStock> lorryStock =new ArrayList<LorryStock>();
	
	public int getInventoryManagerID() {
		return inventoryManagerID;
	}
	public void setInventoryManagerID(int inventoryManagerID) {
		this.inventoryManagerID = inventoryManagerID;
	}
	//public User getUser() {
		//return user;
	//}
	//public void setUser(User user) {
		//this.user = user;
	//}//
	public List<Lorry> getLorry() {
		return lorry;
	}
	public void setLorry(List<Lorry> lorry) {
		this.lorry = lorry;
	}
	
	public List<LorryStock> getLorryStock() {
		return lorryStock;
	}
	public void setLorryStock(List<LorryStock> lorryStock) {
		this.lorryStock = lorryStock;
	}
	
	@Override
	public String toString() {
		return "InventoryManager [inventoryManagerID=" + inventoryManagerID + "lorry=" + lorry + "LorryStock=" + lorryStock + "]";
	}
}