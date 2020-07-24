package com.cbl.backend.model;

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
	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL, mappedBy = "shop")
	private List<PhoneNumber> phoneNumbers;
	

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
	public List<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}
	public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	
	@Override
	public String toString() {
		return "ShopDetailsRequest [shopID=" +shopID +", shopName="+shopName + ", firstName=" + ownerFName + ", lastName=" + ownerLName
				+ ", shopaddress=" + address + ", phoneNumbers=" + phoneNumbers + "]";
	}
}

