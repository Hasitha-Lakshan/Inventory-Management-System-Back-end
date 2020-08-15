package com.cbl.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cbl.backend.model.LorryStock;

public interface LorryStockRepository extends JpaRepository<LorryStock, Integer>{
	LorryStock findByLorryStockID(int lorryStockID);
}
