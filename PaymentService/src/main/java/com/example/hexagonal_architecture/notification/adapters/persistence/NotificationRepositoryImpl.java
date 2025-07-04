package com.example.hexagonal_architecture.notification.adapters.persistence;

import org.springframework.stereotype.Repository;


import com.example.hexagonal_architecture.notification.domain.model.Notification;
import com.example.hexagonal_architecture.notification.domain.ports.NotificationRepository;

@Repository
public class NotificationRepositoryImpl implements NotificationRepository{

	
	private final JpaNotificationRepo jpaRepo;

    public NotificationRepositoryImpl(JpaNotificationRepo jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    @Override
    public Notification save(Notification n) {
        NotificationEntity entity = new NotificationEntity();
        entity.setRecipient(n.getRecipient());
        entity.setSubject(n.getSubject());
        entity.setMessage(n.getMessage());
        NotificationEntity saved = jpaRepo.save(entity);
        return new Notification(saved.getId(), saved.getRecipient(), saved.getSubject(), saved.getMessage());
    }
}
