package com.example.hexagonal_architecture.invoice.adapters.web;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hexagonal_architecture.invoice.application.InvoiceService;
import com.example.hexagonal_architecture.invoice.domain.model.Invoice;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

	private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }


	@PostMapping(value = "/generate", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<byte[]> generate(@RequestBody Invoice invoice) {
	    ByteArrayInputStream pdf = invoiceService.generateInvoice(invoice);
    try {
        byte[] pdfBytes = IOUtils.toByteArray(pdf);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=invoice.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfBytes);
    } catch (IOException e) {
        throw new RuntimeException("Error reading PDF", e);
    }
}
}
