package com.cbl.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Invoice")
public class Invoice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int InvoiceId;

	public int getInvoiceId() {
		return InvoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		InvoiceId = invoiceId;
	}

	@Override
	public String toString() {
		return "Invoice [InvoiceId=" + InvoiceId + ", getInvoiceId()=" + getInvoiceId() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
