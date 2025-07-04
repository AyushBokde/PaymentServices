package com.example.hexagonal_architecture.order_service.adapters.web;


import java.util.Optional;


import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hexagonal_architecture.order_service.application.orderService;
import com.example.hexagonal_architecture.order_service.domin.model.order;


@RestController
@RequestMapping("/orders")
public class orderController {
	
	private final orderService service;

    public orderController(orderService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<order> create(@RequestBody order order) {
    	order savedOrder = service.createOrder(order);
        return ResponseEntity.ok(savedOrder);
    }

    @GetMapping("/{id}/status")
    public ResponseEntity<String> track(@PathVariable Long id) {
        return ResponseEntity.ok(service.trackStatus(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<order> get(@PathVariable Long id) {
        Optional<order> order = service.getOrder(id);
        return order.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<order> update(@PathVariable Long id, @RequestBody order updatedOrder) {
        Optional<order> orderOptional = service.getOrder(id);
        if (orderOptional.isPresent()) {
            order order = orderOptional.get();
            order.setDetails(updatedOrder.getDetails());
            order.setStatus(updatedOrder.getStatus());
            order savedOrder = service.createOrder(order); // reuse createOrder to save
            return ResponseEntity.ok(savedOrder);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
}