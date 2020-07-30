package com.cbl.backend.model;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.JoinColumn;
	import javax.persistence.ManyToOne;
	import javax.persistence.Table;
	import javax.validation.constraints.NotEmpty;

	import com.fasterxml.jackson.annotation.JsonIgnore;


	@Entity
	@Table(name = "Product")
	public class Product {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int ProductId;
		@NotEmpty
		@Column
		private String ProductName;
		@NotEmpty
		@Column
		private String Date;
		@NotEmpty
		@Column
		private boolean Buying_Priceof1;
		@NotEmpty
		@Column
		private boolean Selling_Priceof1;
		@NotEmpty
		@Column
		private int NumberOfReceived;
		@NotEmpty
		@Column
		private boolean BuyingPrice;
		@NotEmpty
		@Column
		private int Boxes;
		@NotEmpty
		@Column
		private int Pieces;
		@NotEmpty
		@Column
		private boolean Profit;
		@ManyToOne
		@JoinColumn(name = "userID")
		@JsonIgnore
		private User user;
		@ManyToOne
		@JoinColumn(name = "InvoiceId")
		@JsonIgnore
		private Invoice InvoiceId;
		
		public int getProductId() {
			return ProductId;
		}
		public void setProductId(int productId) {
			ProductId = productId;
		}
		public String getProductName() {
			return ProductName;
		}
		public void setProductName(String productName) {
			ProductName = productName;
		}
		public String getDate() {
			return Date;
		}
		public void setDate(String date) {
			Date = date;
		}
		public boolean isBuying_Priceof1() {
			return Buying_Priceof1;
		}
		public void setBuying_Priceof1(boolean buying_Priceof1) {
			Buying_Priceof1 = buying_Priceof1;
		}
		public boolean isSelling_Priceof1() {
			return Selling_Priceof1;
		}
		public void setSelling_Priceof1(boolean selling_Priceof1) {
			Selling_Priceof1 = selling_Priceof1;
		}
		public int getNumberOfReceived() {
			return NumberOfReceived;
		}
		public void setNumberOfReceived(int numberOfReceived) {
			NumberOfReceived = numberOfReceived;
		}
		public boolean isBuyingPrice() {
			return BuyingPrice;
		}
		public void setBuyingPrice(boolean buyingPrice) {
			BuyingPrice = buyingPrice;
		}
		public int getBoxes() {
			return Boxes;
		}
		public void setBoxes(int boxes) {
			Boxes = boxes;
		}
		public int getPieces() {
			return Pieces;
		}
		public void setPieces(int pieces) {
			Pieces = pieces;
		}
		public boolean isProfit() {
			return Profit;
		}
		public void setProfit(boolean profit) {
			Profit = profit;
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public Invoice getInvoiceId() {
			return InvoiceId;
		}
		public void setInvoiceId(Invoice invoiceId) {
			InvoiceId = invoiceId;
		}
		@Override
		public String toString() {
			return "Product [ProductId=" + ProductId + ", ProductName=" + ProductName + ", Date=" + Date
					+ ", Buying_Priceof1=" + Buying_Priceof1 + ", Selling_Priceof1=" + Selling_Priceof1
					+ ", NumberOfReceived=" + NumberOfReceived + ", BuyingPrice=" + BuyingPrice + ", Boxes=" + Boxes
					+ ", Pieces=" + Pieces + ", Profit=" + Profit + ", user=" + user + ", getProductId()=" + getProductId()
					+ ", getProductName()=" + getProductName() + ", getDate()=" + getDate() + ", isBuying_Priceof1()="
					+ isBuying_Priceof1() + ", isSelling_Priceof1()=" + isSelling_Priceof1() + ", getNumberOfReceived()="
					+ getNumberOfReceived() + ", isBuyingPrice()=" + isBuyingPrice() + ", getBoxes()=" + getBoxes()
					+ ", getPieces()=" + getPieces() + ", isProfit()=" + isProfit() + ", getUser()=" + getUser()
					+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
					+ "]";
		}
		
		
		
		
		
		
	}

