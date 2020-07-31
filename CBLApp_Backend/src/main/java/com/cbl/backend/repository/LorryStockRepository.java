package com.cbl.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cbl.backend.model.LorryStock;

@Repository
public interface LorryStockRepository extends JpaRepository<LorryStock, Integer>{
	
	Optional<LorryStock> findByStockName (String StockName);
	
}