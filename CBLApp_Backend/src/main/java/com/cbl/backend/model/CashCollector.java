package com.cbl.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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

	@Override
	public String toString() {
		return "CashCollector [cashCollectorID=" + cashCollectorID + ", user=" + user + "]";
	}
}
