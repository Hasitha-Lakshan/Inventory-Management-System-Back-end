package com.cbl.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbl.backend.dto.ShopDetailsResponse;
import com.cbl.backend.model.Shops;
import com.cbl.backend.repository.ShopRepository;

@Service
public class ShopService {
	
	@Autowired
	private ShopRepository shopRepository;


	public List<ShopDetailsResponse> getAllShops() {
		
		List<Shops> shop = shopRepository.findAll();
		
		return shop.stream().map(this::mapFromShopToDto).collect(Collectors.toList());
	}

	private ShopDetailsResponse mapFromShopToDto(Shops shop) {
		
		ShopDetailsResponse shopDetailsRequest = new ShopDetailsResponse();

		shopDetailsRequest.setShopID(shop.getShopID());
		shopDetailsRequest.setShopName(shop.getShopName());
		shopDetailsRequest.setOwnerFName(shop.getOwnerFName());
		shopDetailsRequest.setOwnerLName(shop.getOwnerLName());
		shopDetailsRequest.setAddress(shop.getAddress());
		shopDetailsRequest.setPhoneNumbers(shop.getPhoneNumbers());
		
		return shopDetailsRequest;
	}
}
