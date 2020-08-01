package com.cbl.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cbl.backend.model.SalesItemsReport;

@Repository 
public interface ReportsRepository extends JpaRepository<SalesItemsReport, Integer>{
	
}