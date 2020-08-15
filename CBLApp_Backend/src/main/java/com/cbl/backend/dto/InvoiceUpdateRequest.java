package com.cbl.backend.dto;

import java.util.Date;

public class InvoiceUpdateRequest {
	
	private String shopName;
	private Date expireDate;
	private int value;
	private int cheque;
	private int cash;
	
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public Date getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getCheque() {
		return cheque;
	}
	public void setCheque(int cheque) {
		this.cheque = cheque;
	}
	public int getCash() {
		return cash;
	}
	public void setCash(int cash) {
		this.cash = cash;
	}
	
	
	

}
