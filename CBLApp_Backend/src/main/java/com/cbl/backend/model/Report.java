package com.cbl.backend.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Report {
	
	@ManyToOne
	private Invoice invoice;

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	
	
	

}
