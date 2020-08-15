
package com.cbl.backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbl.backend.dto.ReportRequest;
import com.cbl.backend.dto.ReportResponse;
import com.cbl.backend.model.Product;
import com.cbl.backend.model.Report;
import com.cbl.backend.repository.ReportRepository;

@Service
public class ReportService {

	@Autowired
	private ReportRepository reportRepository;

	public List<ReportResponse> getAllReports() {
		List<Report> reports = reportRepository.findAll();

		if (!reports.equals(null)) {
			return reports.stream().map(this::mapFromReportToDto).collect(Collectors.toList());
		} else {
			return null;
		}
	}

	private ReportResponse mapFromReportToDto(Report report) {

		if (!report.equals(null)) {

			ReportResponse reportResponse = new ReportResponse();

			reportResponse.setReport_Id(report.getReportID());
			reportResponse.setDate(report.getDateTime());
			reportResponse.setReportName(report.getReportName());

			List<Product> productlist = new ArrayList<Product>();
			for (Product product : report.getProduct()) {

				Product productdto = new Product();

				productdto.setProductID(product.getProductID());
				productdto.setProductName(product.getProductName());
				productdto.setUnitBuyingPrice(product.getUnitBuyingPrice());
				productdto.setUnitSellingPrice(product.getUnitSellingPrice());
				productdto.setDate(product.getDate());
				productdto.setPieces(product.getPieces());
				productdto.setBuyingPrice(product.getUnitBuyingPrice(), product.getPieces());
				productdto.setSellingPrice(product.getUnitSellingPrice(), product.getPieces());
				productdto.setProfit(product.getSellingPrice(), product.getBuyingPrice());
				productdto.setReport(product.getReport());
				productlist.add(productdto);

			}

			reportResponse.setProduct(productlist);

			return reportResponse;
		} else {
			return null;
		}

	}

	public boolean saveReport(ReportRequest reportRequest) {

		if (!reportRequest.equals(null)) {

			Report report = new Report();

			report.setReportName(reportRequest.getReportName());
			report.setDateTime(reportRequest.getDate());

			List<Product> productlist = new ArrayList<Product>();

			for (Product productDto : reportRequest.getProducts()) {

				Product product = new Product();

				product.setProductName(productDto.getProductName());
				product.setUnitBuyingPrice(productDto.getUnitBuyingPrice());
				product.setUnitSellingPrice(productDto.getUnitSellingPrice());
				product.setDate(productDto.getDate());
				product.setPieces(productDto.getPieces());
				product.setBuyingPrice(productDto.getUnitBuyingPrice(), productDto.getPieces());
				product.setSellingPrice(productDto.getUnitSellingPrice(), productDto.getPieces());
				product.setProfit(product.getSellingPrice(), product.getBuyingPrice());
				product.setReport(report);
				productlist.add(product);

			}

			report.setProduct(productlist);
			reportRepository.save(report);

			return true;

		} else {
			return false;
		}

	}

	public ReportResponse findReport(int reportId) {

		Report report = reportRepository.findByReportID(reportId);

		if (report != null) {
			return this.mapFromReportToDto(report);
		} else {
			return null;
		}
	}
}