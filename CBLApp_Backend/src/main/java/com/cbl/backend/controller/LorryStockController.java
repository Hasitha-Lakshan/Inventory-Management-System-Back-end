package com.cbl.backend.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbl.backend.dto.LorryStockRequest;
import com.cbl.backend.service.LorryStockService;

@RestController
@RequestMapping("/api/inventoryManager/")
public class LorryStockController {
	
	@Autowired
	private LorryStockService LorryStockService;
	
	@PostMapping("/submit")
	public boolean submit(@RequestBody LorryStockRequest LorryStockRequest) {
		
		return LorryStockService.submit(LorryStockRequest);
	
	}	
}