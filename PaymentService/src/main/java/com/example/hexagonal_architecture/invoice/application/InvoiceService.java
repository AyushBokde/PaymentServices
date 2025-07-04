package com.example.hexagonal_architecture.invoice.application;

import java.io.ByteArrayInputStream;

import org.springframework.stereotype.Service;

import com.example.hexagonal_architecture.invoice.domain.model.Invoice;
import com.example.hexagonal_architecture.invoice.domain.ports.PdfGeneratorPort;

@Service
public class InvoiceService {

	 private final PdfGeneratorPort pdfGenerator;

	    public InvoiceService(PdfGeneratorPort pdfGenerator) {
	        this.pdfGenerator = pdfGenerator;
	    }

	    public ByteArrayInputStream generateInvoice(Invoice invoice) {
	        return pdfGenerator.generate(invoice);
	    }
}
