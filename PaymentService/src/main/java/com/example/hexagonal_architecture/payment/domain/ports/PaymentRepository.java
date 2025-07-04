package com.example.hexagonal_architecture.payment.domain.ports;

import java.util.Optional;

import com.example.hexagonal_architecture.payment.domain.model.Payment;

public interface PaymentRepository {

	Payment save(Payment payment);
    Optional<Payment> findById(Long id);
}
