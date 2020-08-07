package com.cbl.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cbl.backend.model.Invoice;



@Repository
public interface InvoiceRepository extends JpaRepository< Invoice, Integer> {
    
	Invoice FindByShopName(String shopName);
}
