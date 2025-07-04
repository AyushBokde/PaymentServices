package com.example.hexagonal_architecture.notification.adapters.persistence;

import org.springframework.data.jpa.repository.JpaRepository;



public interface JpaNotificationRepo extends JpaRepository<NotificationEntity, Long>{

}
