package com.cbl.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbl.backend.dto.ShopDetailsResponse;
import com.cbl.backend.service.ShopService;

@RestController
@RequestMapping("/api/inventoryManager/")
public class ShopController {
	
	@Autowired
	ShopService shopService;

	@GetMapping("/shops")
	public ResponseEntity<List<ShopDetailsResponse>> getAllShops(){
		
		return new ResponseEntity<>(shopService.getAllShops(), HttpStatus.OK);
	}
}
