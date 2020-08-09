package com.cbl.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbl.backend.dto.InvoiceDetailsResponse;
import com.cbl.backend.dto.InvoiceSaveRequest;
import com.cbl.backend.dto.InvoiceUpdateRequest;
import com.cbl.backend.model.Invoice;
import com.cbl.backend.repository.InvoiceRepository;

@Service
public class InvoiceService {

	@Autowired
	private InvoiceRepository repository;

	public boolean saveReport(InvoiceSaveRequest invoiceSaveRequest) {

		Invoice invoice = new Invoice();

		invoice.setShopName(invoiceSaveRequest.getShopName());
		invoice.setIssuedDate(invoiceSaveRequest.getIssuedDate());
		invoice.setExpireDate(invoiceSaveRequest.getExpireDate());
		invoice.setValue(invoiceSaveRequest.getValue());
		invoice.setCheque(invoiceSaveRequest.getCheque());
		invoice.setCash(invoiceSaveRequest.getCash());
		invoice.setCredits(invoice.getValue() - (invoice.getCash() + invoice.getCheque()));

		if (invoice.getCredits() == 0) {
			invoice.setStatus(true);
		} else {
			invoice.setStatus(false);
		}
		this.repository.save(invoice);
		return true;
		

	}


	/*
	 * public List<Invoice> saveReport(List<Invoice> invoice){ return
	 * repository.saveAll(invoice); }
	 */

	private InvoiceDetailsResponse mapFromInvoiceToDto(Invoice invoice) {

		InvoiceDetailsResponse invoiceResponse = new InvoiceDetailsResponse();

		invoiceResponse.setInvoiceId(invoice.getInvoiceId());
		invoiceResponse.setShopName(invoice.getShopName());
		invoiceResponse.setIssuedDate(invoice.getIssuedDate());
		invoiceResponse.setExpireDate(invoice.getExpireDate());
		invoiceResponse.setStatus(invoice.isStatus());
		invoiceResponse.setValue(invoice.getValue());
		invoiceResponse.setCheque(invoice.getCheque());
		invoiceResponse.setCash(invoice.getCash());
		invoiceResponse.setCredits(invoice.getCredits());

		return invoiceResponse;
	}

	public List<InvoiceDetailsResponse> getReports() {
		List<Invoice> invoices = repository.findAll();

		return invoices.stream().map(this::mapFromInvoiceToDto).collect(Collectors.toList());
	}

	public InvoiceDetailsResponse getReportById(int id) {

		Invoice invoice = repository.findById(id).orElse(null);
		if (invoice != null) {
			return this.mapFromInvoiceToDto(invoice);
		} else {
			return null;
		}

	}

	/*
	 * public Invoice getReportByShopName(String name) { // return
	 * repository.findByShopName(name); // }
	 */

	/*
	 * public String deleteReport(int id){ repository.deleteById(id); return
	 * "Report removed" +id; }
	 */

	public boolean updateInvoiceReport(int id, InvoiceUpdateRequest invoiceUpdateRequest) {
		Invoice existingReport = repository.findById(id).orElse(null);

		if (existingReport != null) {
			existingReport.setShopName(invoiceUpdateRequest.getShopName());
			existingReport.setExpireDate(invoiceUpdateRequest.getExpireDate());

			existingReport.setValue(invoiceUpdateRequest.getValue());
			existingReport.setCheque(invoiceUpdateRequest.getCheque());
			existingReport.setCash(invoiceUpdateRequest.getCash());
			existingReport.setCredits(invoiceUpdateRequest.getValue()
					- (invoiceUpdateRequest.getCheque() + invoiceUpdateRequest.getCash()));
			if (existingReport.getCredits() == 0) {
				existingReport.setStatus(true);
			} else {
				existingReport.setStatus(false);
			}

			repository.save(existingReport);
			return true;

		} else {
			return false;
		}

	}

}
