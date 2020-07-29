package com.cbl.backend.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cbl.backend.model.StoredItemsReport;

@Repository 
public interface StoredItemsReportRepository extends JpaRepository<StoredItemsReport, Integer>{
	
	Optional<StoredItemsReport> findByDate (Date date);
}