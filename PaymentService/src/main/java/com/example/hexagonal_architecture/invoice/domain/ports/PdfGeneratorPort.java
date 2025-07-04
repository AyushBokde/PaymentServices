package com.example.hexagonal_architecture.invoice.domain.ports;

import java.io.ByteArrayInputStream;

import com.example.hexagonal_architecture.invoice.domain.model.Invoice;

public interface PdfGeneratorPort {

	ByteArrayInputStream generate(Invoice invoice);
}
