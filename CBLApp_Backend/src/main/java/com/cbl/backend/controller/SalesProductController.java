package com.cbl.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cbl.backend.dto.RegisterRequest;
import com.cbl.backend.model.SalesProduct;
import com.cbl.backend.service.SalesProductService;

import antlr.collections.List;

@RestController
public class SalesProductController {

	@Autowired
	private final SalesProductService productService;
	
	public SalesProductController(SalesProductService product) {
		this.productService=product;
	}
	
	
	@GetMapping("/product")
	public java.util.List<SalesProduct> getAll() {
		return productService.getAll();
	}
	
	@PostMapping("/product")
	public SalesProduct save(@RequestBody SalesProduct product) {
		return productService.save(product);
	}
	
	@RequestMapping(value = "{pid}", method = RequestMethod.DELETE)
	public String delete(@PathVariable int pid) {
		return "product";
		
	}
}
