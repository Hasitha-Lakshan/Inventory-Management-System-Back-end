package com.cbl.backend.exception;

public class ShopNotFoundException extends RuntimeException{
	
	public ShopNotFoundException(String message) {
		super(message);
	}
}

