package com.cbl.backend.exception;

@SuppressWarnings("serial")
public class InvoiceNotFoundException extends RuntimeException {
	
	
	public InvoiceNotFoundException(String message) {
		super(message);
	}

}
