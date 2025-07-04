package com.example.hexagonal_architecture.order_service.persistence;

import org.springframework.data.jpa.repository.JpaRepository;



public interface jpaOrderRepo extends JpaRepository<orderEntity, Long> {

	

}
