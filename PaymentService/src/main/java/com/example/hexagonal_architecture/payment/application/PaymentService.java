package com.example.hexagonal_architecture.payment.application;

import java.util.Optional;
import org.springframework.stereotype.Service;

import com.example.hexagonal_architecture.payment.domain.model.Payment;
import com.example.hexagonal_architecture.payment.domain.ports.PaymentRepository;

@Service
public class PaymentService {

	 private final PaymentRepository repository;

	    public PaymentService(PaymentRepository repository) {
	        this.repository = repository;
	    }

	    public Payment create(Payment payment) {
	        payment.setStatus("PENDING");
	        return repository.save(payment);
	    }

	    public Payment confirm(Long id) {
	        Optional<Payment> opt = repository.findById(id);
	        if (opt.isPresent()) {
	            Payment p = opt.get();
	            p.setStatus("CONFIRMED");
	            return repository.save(p);
	        }
	        throw new RuntimeException("Payment not found");
	    }

	    public Optional<Payment> getDetails(Long id) {
	        return repository.findById(id);
	    }
}
