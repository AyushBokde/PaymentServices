package com.example.hexagonal_architecture.invoice.adapters.pdf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.springframework.stereotype.Component;

import com.example.hexagonal_architecture.invoice.domain.model.Invoice;
import com.example.hexagonal_architecture.invoice.domain.ports.PdfGeneratorPort;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;



@Component
public class PdfInvoiceGenerator implements PdfGeneratorPort{

	 @Override
	    public ByteArrayInputStream generate(Invoice invoice) {
	        Document document = new Document();
	        ByteArrayOutputStream out = new ByteArrayOutputStream();

	        try {
	            PdfWriter.getInstance(document, out);
	            document.open();
	            document.add(new Paragraph("INVOICE"));
	            document.add(new Paragraph("Invoice ID: " + invoice.getId()));
	            document.add(new Paragraph("Customer: " + invoice.getCustomerName()));
	            document.add(new Paragraph("Amount: ₹" + invoice.getAmount()));
	            document.close();
	        } catch (Exception e) {
	            throw new RuntimeException("Error generating PDF", e);
	        }

	        return new ByteArrayInputStream(out.toByteArray());
	    }
}
