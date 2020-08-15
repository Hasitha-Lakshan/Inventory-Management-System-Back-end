package com.cbl.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cbl.backend.dto.LorryStockRequest;
import com.cbl.backend.service.LorryStockService;

public class LorryStockController {
	@Autowired
	private LorryStockService lorryStockService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
	@PutMapping("/updateproduct/{id}")
	public ResponseEntity<?> updateproduct(@PathVariable int id, @RequestBody LorryStockRequest rq) {

		boolean successful = lorryStockService.updateProduct(id, rq);
		if (successful) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
