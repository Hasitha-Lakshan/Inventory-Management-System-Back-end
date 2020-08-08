package com.cbl.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbl.backend.dto.LorryInfoUpdateRequest;
import com.cbl.backend.dto.LorryRequest;
import com.cbl.backend.dto.LorryResponse;
import com.cbl.backend.service.LorryService;

@RestController
@RequestMapping("/api/inventoryManager/distribution/")
public class LorryController {

	@Autowired
	private LorryService lorryService;

	@PostMapping("/addlorry")
	public boolean add(@RequestBody LorryRequest lorryRequest) {

		return lorryService.add(lorryRequest);
	}

	@GetMapping("/lorries")
	public ResponseEntity<List<LorryResponse>> getAllLorries() {

		return new ResponseEntity<>(lorryService.getAllLorries(), HttpStatus.OK);
	}

	@PutMapping("/updatelorry/{id}")
	public ResponseEntity<?> updateLorryInfo(@PathVariable int id, @RequestBody LorryInfoUpdateRequest rq) {

		boolean successful = lorryService.updateLorryInfo(id, rq);
		if (successful) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}