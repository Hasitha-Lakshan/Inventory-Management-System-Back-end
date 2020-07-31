package com.cbl.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cbl.backend.model.Invoice;

public interface ReportRepository extends JpaRepository<Invoice, Integer> {

	Invoice findByShopName(String shopName);

	
	

}
