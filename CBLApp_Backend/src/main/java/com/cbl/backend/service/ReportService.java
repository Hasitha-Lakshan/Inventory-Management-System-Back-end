package com.cbl.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbl.backend.dto.UserDetailsResponse;
import com.cbl.backend.model.Report;
import com.cbl.backend.model.User;
import com.cbl.backend.repository.ReportRepository;
import com.cbl.backend.repository.UserRepository;
@Service
public class ReportService {
	
	@Autowired
	private ReportRepository reportRepository;

	public List<Report> getAll() {
		List<Report> list = reportRepository.findAll();
		return list;
	}
	
	public Report save(Report report) {
		return reportRepository.save(report);
	}
	
	public String delete(int id) {
		reportRepository.deleteById(id);
		return "deleted";
	}
	
	
}