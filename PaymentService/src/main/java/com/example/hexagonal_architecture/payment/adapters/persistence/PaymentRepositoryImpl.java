package com.example.hexagonal_architecture.payment.adapters.persistence;

import java.util.Optional;
import org.springframework.stereotype.Repository;

import com.example.hexagonal_architecture.payment.domain.model.Payment;
import com.example.hexagonal_architecture.payment.domain.ports.PaymentRepository;

@Repository
public class PaymentRepositoryImpl implements PaymentRepository {

	private final JpaPaymentRepo jpaRepo;

    public PaymentRepositoryImpl(JpaPaymentRepo jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    @Override
    public Payment save(Payment p) {
        PaymentEntity entity = new PaymentEntity();
        entity.setOrderId(p.getOrderId());
        entity.setAmount(p.getAmount());
        entity.setStatus(p.getStatus());

        PaymentEntity saved = jpaRepo.save(entity);
        return new Payment(saved.getId(), saved.getOrderId(), saved.getStatus(), saved.getAmount());
    }

    @Override
    public Optional<Payment> findById(Long id) {
        return jpaRepo.findById(id)
                .map(e -> new Payment(e.getId(), e.getOrderId(), e.getStatus(), e.getAmount()));
    }

}
