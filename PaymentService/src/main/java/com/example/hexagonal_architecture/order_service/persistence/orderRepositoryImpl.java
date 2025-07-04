package com.example.hexagonal_architecture.order_service.persistence;


import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.hexagonal_architecture.order_service.domin.model.order;
import com.example.hexagonal_architecture.order_service.domin.ports.orderRepository;


@Repository
public class orderRepositoryImpl implements orderRepository {

	private final jpaOrderRepo jpaRepo;

    public orderRepositoryImpl(jpaOrderRepo jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    @Override
    public order save(order order) {
        orderEntity entity = new orderEntity();
        entity.setDetails(order.getDetails());
        entity.setStatus(order.getStatus());
        orderEntity saved = jpaRepo.save(entity);
        return new order(saved.getId(), saved.getStatus(), saved.getDetails());
    }

    @Override
    public Optional<order> findById(Long id) {
        return jpaRepo.findById(id).map(e -> new order(e.getId(), e.getStatus(), e.getDetails()));
    }

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}


}
