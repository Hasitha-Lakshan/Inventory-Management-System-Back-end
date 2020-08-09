package com.cbl.backend.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "invoices")
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int invoiceId;
	private String shopName;
	private Date issuedDate;
	private Date expireDate;
	private boolean status;
	private int value;
	private int cheque;
	private int cash;
	private int credits;

	@JoinColumn(name = "cashCollectorId")
	@ManyToOne
	private CashCollector cashCollector;

	@JoinColumn(name = "shopId")
	@ManyToOne
	private Shops shops;

	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public Date getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
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

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public CashCollector getCashCollector() {
		return cashCollector;
	}

	public void setCashCollector(CashCollector cashCollector) {
		this.cashCollector = cashCollector;
	}

	public Shops getShops() {
		return shops;
	}

	public void setShops(Shops shops) {
		this.shops = shops;
	}

	@Override
	public String toString() {
		return "Invoice [invoiceId=" + invoiceId + ", shopName=" + shopName + ", issuedDate=" + issuedDate
				+ ", expireDate=" + expireDate + ", status=" + status + ", value=" + value + ", cheque=" + cheque
				+ ", cash=" + cash + ", credits=" + credits + ", cashCollector=" + cashCollector + ", shops=" + shops
				+ "]";
	}

}
