package com.cbl.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cbl.backend.model.LorryStock;


@Repository
public interface AvailableItemsRepository extends JpaRepository<LorryStock, Integer>{

	Optional<LorryStock> findByProductName(String ProductName);
}



