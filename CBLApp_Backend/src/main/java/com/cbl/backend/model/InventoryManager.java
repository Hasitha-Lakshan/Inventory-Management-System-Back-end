package com.cbl.backend.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "InventoryManagers")
public class InventoryManager {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int inventoryManagerID;
	@OneToOne
	@JoinColumn(name = "userID")
	@JsonIgnore
	private User user;
	
	@OneToMany(mappedBy = "inventoryManager")
	private List<Lorry> lorry =new ArrayList<Lorry>();
	
	public int getInventoryManagerID() {
		return inventoryManagerID;
	}
	public void setInventoryManagerID(int inventoryManagerID) {
		this.inventoryManagerID = inventoryManagerID;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Lorry> getLorry() {
		return lorry;
	}
	public void setLorry(List<Lorry> lorry) {
		this.lorry = lorry;
	}
	@Override
	public String toString() {
		return "InventoryManager [inventoryManagerID=" + inventoryManagerID + ", user=" + user + ",, lorry=" + lorry + "]";
	}
}
