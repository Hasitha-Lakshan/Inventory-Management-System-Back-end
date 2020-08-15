<<<<<<< HEAD
package com.cbl.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cbl.backend.model.SalesItemsReport;

@Repository 
public interface ReportRepository extends JpaRepository<SalesItemsReport, Integer>{
	
=======
package com.cbl.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cbl.backend.model.Report;

@Repository 
public interface ReportRepository extends JpaRepository<Report, Integer>{
	
	Report findByReportID(int reportID);
>>>>>>> 2846202df6ab3f42c1f825654bf42426e7a3baaf
}