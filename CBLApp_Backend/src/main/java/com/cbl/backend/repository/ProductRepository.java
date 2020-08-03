package com.cbl.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cbl.backend.model.SalesProduct;

@Repository 
public interface ProductRepository extends JpaRepository<SalesProduct, Integer>{
	
}