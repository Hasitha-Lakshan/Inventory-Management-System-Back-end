package com.cbl.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cbl.backend.entity.Report;

public interface ReportRepository extends JpaRepository<Report, Integer> {

	Report findByShopName(String name);

	
	

}
