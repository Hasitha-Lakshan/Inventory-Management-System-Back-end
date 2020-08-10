package com.cbl.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.cbl.backend.model.LorryStock;
import com.cbl.backend.model.User;

@Repository
public interface LorryStockRepository extends JpaRepository<LorryStock, Integer>{
	Optional<LorryStock> findByLorryStockID(int lorryStockID);	
}