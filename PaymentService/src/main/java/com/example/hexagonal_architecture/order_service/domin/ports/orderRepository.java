package com.example.hexagonal_architecture.order_service.domin.ports;


import java.util.Optional;

import com.example.hexagonal_architecture.order_service.domin.model.order;



public interface orderRepository {

	order save(order order);
    Optional<order> findById(Long id);
	void deleteById(Long id);
    
}
