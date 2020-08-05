package com.cbl.backend.exception;

@SuppressWarnings("serial")
public class ShopNotFoundException extends RuntimeException{
	
	public ShopNotFoundException(String message) {
		super(message);
	}
}


