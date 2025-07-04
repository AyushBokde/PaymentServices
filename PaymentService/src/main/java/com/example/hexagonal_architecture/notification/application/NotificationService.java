package com.example.hexagonal_architecture.notification.application;

import org.springframework.stereotype.Service;

import com.example.hexagonal_architecture.notification.domain.model.Notification;
import com.example.hexagonal_architecture.notification.domain.ports.NotificationRepository;

@Service
public class NotificationService {

	private final NotificationRepository repository;

    public NotificationService(NotificationRepository repository) {
        this.repository = repository;
    }

    public Notification send(Notification notification) {
        // Simulate notification logic (log, print, or integrate email service here)
        System.out.println("Sending notification to: " + notification.getRecipient());
        return repository.save(notification);
    }
}
