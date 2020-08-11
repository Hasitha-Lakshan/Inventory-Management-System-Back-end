package com.cbl.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.cbl.backend.model.Analyzer;
import com.cbl.backend.model.User;

@Repository
public interface AnalyzerRepository extends JpaRepository<Analyzer, Integer>{
	public Analyzer findByuser(User user);
	public void deleteByuser(User user);
	
}
