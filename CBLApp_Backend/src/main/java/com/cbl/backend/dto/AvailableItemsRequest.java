package com.cbl.backend.dto;

public class AvailableItemsRequest {
	
	private String ProductName;
	private Float SellingPrice;
	private Float BuyingPrice;
	private Integer Boxes;
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
