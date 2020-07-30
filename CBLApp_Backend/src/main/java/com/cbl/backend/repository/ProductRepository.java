package com.cbl.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cbl.backend.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	Optional<Product> findByProductName(String username);
}



