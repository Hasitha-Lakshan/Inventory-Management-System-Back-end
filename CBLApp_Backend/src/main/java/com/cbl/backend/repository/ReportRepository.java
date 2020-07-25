package com.cbl.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cbl.backend.model.Report;

@Repository 
public interface ReportRepository extends JpaRepository<Report, Integer>{
	
	Optional<Report> findByReportdate (String product_name);
}