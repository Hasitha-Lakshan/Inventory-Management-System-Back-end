package com.cbl.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "AvailableItems")

public class AvailableItems {
	
	@NotEmpty
	@Column
	private String ProductName;
	@NotEmpty
	@Column
	private Float SellingPrice;
	@NotEmpty
	@Column
	private Float BuyingPrice;
	@Column
	private Integer Boxes;
	@Column
	private Integer Pieces;
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public Float getSellingPrice() {
		return SellingPrice;
	}
	public void setSellingPrice(Float sellingPrice) {
		SellingPrice = sellingPrice;
	}
	public Float getBuyingPrice() {
		return BuyingPrice;
	}
	public void setBuyingPrice(Float buyingPrice) {
		BuyingPrice = buyingPrice;
	}
	public Integer getBoxes() {
		return Boxes;
	}
	public void setBoxes(Integer boxes) {
		Boxes = boxes;
	}
	public Integer getPieces() {
		return Pieces;
	}
	public void setPieces(Integer pieces) {
		Pieces = pieces;
	}
	
}
