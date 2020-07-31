package com.cbl.backend.service;

import com.cbl.backend.dto.AvailableItemsRequest;
import com.cbl.backend.model.Product;

public class AvailableItemsService {
	
	public boolean submit(AvailableItemsRequest AvailableItemsRequest) {

		Product Product = new Product();
		
	        Product.setProductName(Product.getProductName());
	        Product.setSellingPriceOf1(Product.getSellingPriceOf1());
	        Product.setBuyingPriceOf1(Product.getBuyingPriceOf1());
	        Product.setBoxes(Product.getBoxes());
	        Product.setPieces(Product.getPieces());
			return true;
		
}


}
