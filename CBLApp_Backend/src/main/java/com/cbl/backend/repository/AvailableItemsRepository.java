package com.cbl.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cbl.backend.model.AvailableItems;

@Repository
public interface AvailableItemsRepository extends JpaRepository<AvailableItems, Integer>{

	Optional<AvailableItems> findByProductName(String ProductName);
}



