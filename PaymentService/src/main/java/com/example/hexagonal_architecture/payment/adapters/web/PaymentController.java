package com.example.hexagonal_architecture.payment.adapters.web;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hexagonal_architecture.payment.application.PaymentService;
import com.example.hexagonal_architecture.payment.domain.model.Payment;

@RestController
@RequestMapping("/payments")
public class PaymentController {

	 private final PaymentService service;

	    public PaymentController(PaymentService service) {
	        this.service = service;
	    }

	    @PostMapping("/create")
	    public ResponseEntity<Payment> create(@RequestBody Payment payment) {
	        return ResponseEntity.ok(service.create(payment));
	    }

	    @PutMapping("/{id}/confirm")
	    public ResponseEntity<Payment> confirm(@PathVariable Long id) {
	        return ResponseEntity.ok(service.confirm(id));
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Payment> details(@PathVariable Long id) {
	        Optional<Payment> p = service.getDetails(id);
	        return p.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	    }
}
