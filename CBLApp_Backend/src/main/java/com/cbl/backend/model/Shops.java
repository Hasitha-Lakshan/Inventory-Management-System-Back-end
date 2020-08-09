package com.cbl.backend.model;

import java.util.ArrayList;
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
@Table(name = "Shops")
public class Shops {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int shopID;
	@NotEmpty
	@Column
	private String shopName;
	@NotEmpty
	@Column
	private String ownerFName;
	@NotEmpty
	@Column
	private String ownerLName;
	@NotEmpty
	@Column
	private String address;
	@NotEmpty
	@Column
	private String phoneNumber;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy="shops")
	private List<Invoice> invoices = new ArrayList<Invoice>();
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getShopID() {
		return shopID;
	}
	public void setShopID(int shopID) {
		this.shopID = shopID;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getOwnerFName() {
		return ownerFName;
	}
	public void setOwnerFName(String ownerFName) {
		this.ownerFName = ownerFName;
	}
	public String getOwnerLName() {
		return ownerLName;
	}
	public void setOwnerLName(String ownerLName) {
		this.ownerLName = ownerLName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	public List<Invoice> getInvoices() {
		return invoices;
	}
	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}
	
	@Override
	public String toString() {
		return "Shops [shopID=" + shopID + ", shopName=" + shopName + ", ownerFName=" + ownerFName + ", ownerLName="
				+ ownerLName + ", address=" + address + ", phoneNumber=" + phoneNumber + ", invoices=" + invoices + "]";
	}
}

