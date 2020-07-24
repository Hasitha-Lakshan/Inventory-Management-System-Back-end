package com.cbl.backend.dto;

import java.util.List;

import com.cbl.backend.model.PhoneNumber;

public class ShopDetailsResponse {

	private int shopID;
	private String shopName;
	private String ownerFName;
	private String ownerLName;
	private String address;
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
