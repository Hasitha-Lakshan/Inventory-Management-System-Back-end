package com.cbl.backend.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cbl.backend.dto.InvoiceSaveRequest;
import com.cbl.backend.dto.InvoiceUpdateRequest;
import com.cbl.backend.model.Invoice;
import com.cbl.backend.repository.InvoiceRepository;
import com.cbl.backend.service.InvoiceService;

@SpringBootTest
public class InvoiceServiceTest {
	
	
	
	@Autowired
	InvoiceService invoiceService;

	@MockBean
	private InvoiceRepository invoiceRepository;
	
	
	@Test
	public void saveReportTest() {
		Invoice invoice = new Invoice();
		InvoiceSaveRequest invoiceSaveRequest = new InvoiceSaveRequest();
		
		
		invoiceSaveRequest.setShopName("test saman");
		invoiceSaveRequest.setIssuedDate(new Date());
		invoiceSaveRequest.setExpireDate(new Date());
		invoiceSaveRequest.setValue(5000);
		invoiceSaveRequest.setCheque(1000);
		invoiceSaveRequest.setCash(2000);
		
		when(invoiceRepository.save(invoice)).thenReturn(invoice);
		assertEquals(true,invoiceService.saveReport(invoiceSaveRequest));
	}

	

	@Test
	public void getReportsTest() {
		List<Invoice> invoices = new ArrayList<Invoice>();
		Invoice invoice = new Invoice();
		
		invoice.setShopName("test saman");
		invoice.setIssuedDate(new Date());
		invoice.setExpireDate(new Date());
		invoice.setValue(5000);
		invoice.setCheque(1000);
		invoice.setCash(2000);
		
		invoices.add(invoice);
		
		when(invoiceRepository.findAll()).thenReturn(invoices);
		assertEquals(1,invoiceService.getReports().size());
	}
	
	@Test
	public void updateInvoiceReportTest() {
		InvoiceUpdateRequest invoiceUpdateRequest = new InvoiceUpdateRequest();
		
		invoiceUpdateRequest.setShopName("test saman");
		invoiceUpdateRequest.setExpireDate(new Date());
		invoiceUpdateRequest.setValue(5000);
		invoiceUpdateRequest.setCheque(1000);
		invoiceUpdateRequest.setCash(2000);
		
		Invoice invoice = new Invoice();
		
		invoice.setInvoiceId(1);
		invoice.setShopName("test sama new");
		invoice.setIssuedDate(new Date());
		invoice.setExpireDate(new Date());
		invoice.setValue(20000);
		invoice.setCheque(1000);
		invoice.setCash(2000);
		
		invoiceRepository.save(invoice);
		
		when(invoiceRepository.findByInvoiceId(invoice.getInvoiceId())).thenReturn(invoice);
		assertEquals(false,invoiceService.updateInvoiceReport(invoice.getInvoiceId(),invoiceUpdateRequest));
		
		
		
	}
	
}