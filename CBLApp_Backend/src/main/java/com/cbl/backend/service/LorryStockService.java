package com.cbl.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cbl.backend.dto.LorryStockRequest;
import com.cbl.backend.model.Product;
import com.cbl.backend.model.LorryStock;
import com.cbl.backend.repository.LorryStockRepository;

public class LorryStockService {
	
	@Autowired
	private LorryStockRepository lorryStockRepository;
	
	public boolean updateProduct(int id , LorryStockRequest lorryStockRequest) {

		if (!lorryStockRequest.equals(null)) {

			LorryStock lorryStock = new LorryStock();

			lorryStock.setStockName(lorryStockRequest.getStockName());
			lorryStock.setDateTime(lorryStockRequest.getDate());

			List<Product> productlist = new ArrayList<Product>();

			for (Product productInfo : lorryStockRequest.getProducts()) {

				Product product = new Product();

				product.setProductName(productInfo.getProductName());
				product.setUnitBuyingPrice(productInfo.getUnitBuyingPrice());
				product.setUnitSellingPrice(productInfo.getUnitSellingPrice());
				product.setDate(productInfo.getDate());
				product.setPieces(productInfo.getPieces());
				product.setBuyingPrice(productInfo.getUnitBuyingPrice(), productInfo.getPieces());
				product.setSellingPrice(productInfo.getUnitSellingPrice(), productInfo.getPieces());
				product.setProfit(product.getSellingPrice(), product.getBuyingPrice());
				product.setLorryStock(lorryStock);
				productlist.add(product);

			}

			lorryStock.setProduct(productlist);
			lorryStockRepository.save(lorryStock);

			return true;

		} else {
			return false;
		}

	}

}
