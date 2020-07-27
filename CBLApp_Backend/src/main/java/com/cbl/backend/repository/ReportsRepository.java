package com.cbl.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cbl.backend.model.Reports;

@Repository 
public interface ReportsRepository extends JpaRepository<Reports, Integer>{
	
	Optional<Reports> findByReportsdate (String product_name);
}