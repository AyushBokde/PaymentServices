package com.example.hexagonal_architecture.order_service.application;

import java.util.Optional;
import org.springframework.stereotype.Service;

import com.example.hexagonal_architecture.order_service.domin.model.order;
import com.example.hexagonal_architecture.order_service.domin.ports.orderRepository;

@Service
public class orderService {

	 private final orderRepository repository;

	    public orderService(orderRepository repository) {
	        this.repository = repository;
	    }

	    public order createOrder(order order) {
	        order.setStatus("CREATED");
	        return repository.save(order);
	    }

	    public String trackStatus(Long id) {
	        return repository.findById(id).map(order::getStatus).orElse("NOT_FOUND");
	    }

	    public Optional<order> getOrder(Long id) {
	        return repository.findById(id);
	    }
	    
	    public boolean deleteOrder(Long id) {
	        Optional<order> orderOptional = repository.findById(id);
	        if (orderOptional.isPresent()) {
	            repository.deleteById(id);
	            return true;
	        } else {
	            return false;
	        }
	    }
}