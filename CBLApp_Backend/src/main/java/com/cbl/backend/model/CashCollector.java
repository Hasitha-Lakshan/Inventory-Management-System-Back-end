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
@Table(name = "CashCollectors")
public class CashCollector {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cashCollectorID;
	@OneToOne
	@JoinColumn(name = "userID")
	@JsonIgnore
	private User user;

	@OneToOne
	@JoinColumn(name = "lorryID")
	@JsonIgnore
	private Lorry lorry;

	@OneToMany(mappedBy = "cashCollector")
	@JsonIgnore
	private List<Invoice> invoices = new ArrayList<Invoice>();

	public int getCashCollectorID() {
		return cashCollectorID;
	}

	public void setCashCollectorID(int cashCollectorID) {
		this.cashCollectorID = cashCollectorID;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Lorry getLorry() {
		return lorry;
	}

	public void setLorry(Lorry lorry) {
		this.lorry = lorry;
	}

	public List<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}

	@Override
	public String toString() {
		return "CashCollector [cashCollectorID=" + cashCollectorID + ", user=" + user + ", lorry=" + lorry
				+ ", invoices=" + invoices + "]";
	}
}
