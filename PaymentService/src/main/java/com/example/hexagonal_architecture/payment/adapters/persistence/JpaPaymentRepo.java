package com.example.hexagonal_architecture.payment.adapters.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPaymentRepo extends JpaRepository<PaymentEntity, Long>  {

}
