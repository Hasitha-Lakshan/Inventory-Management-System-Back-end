package com.cbl.backend.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbl.backend.dto.AvailableItemsRequest;
import com.cbl.backend.service.AvailableItemsService;

@RestController
@RequestMapping("/api/inventoryManager/")
public class AvailableItemsController {
	
	@Autowired
	private AvailableItemsService AvailableItemsService;
	
	@PostMapping("/submit")
	public boolean submit(@RequestBody AvailableItemsRequest AvailableItemsRequest) {
		
		return AvailableItemsService.submit(AvailableItemsRequest);
}
}