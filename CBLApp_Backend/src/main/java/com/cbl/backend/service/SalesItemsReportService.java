package com.cbl.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbl.backend.dto.UserDetailsResponse;
import com.cbl.backend.model.SalesItemsReport;
import com.cbl.backend.model.User;
import com.cbl.backend.repository.ReportsRepository;
import com.cbl.backend.repository.UserRepository;
@Service
public class SalesItemsReportService {
	
	@Autowired
	private ReportsRepository userRepository;

	public List<SalesItemsReport> getAll() {
		List<SalesItemsReport> list = userRepository.findAll();
		return list;
	}
	
	public SalesItemsReport save(SalesItemsReport report) {
		return userRepository.save(report);
	}
	
	public String delete(int id) {
		userRepository.deleteById(id);
		return "deleted";
	}
	
	
}
