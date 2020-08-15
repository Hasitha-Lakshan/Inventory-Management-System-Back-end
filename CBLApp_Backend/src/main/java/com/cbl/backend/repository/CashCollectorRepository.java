package com.cbl.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.cbl.backend.model.CashCollector;
import com.cbl.backend.model.User;

@Repository
public interface CashCollectorRepository extends JpaRepository<CashCollector, Integer>{
	public CashCollector findByuser(User user);
	public void deleteByuser(User user);
}
