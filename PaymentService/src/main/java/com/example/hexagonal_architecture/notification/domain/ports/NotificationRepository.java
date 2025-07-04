package com.example.hexagonal_architecture.notification.domain.ports;

import com.example.hexagonal_architecture.notification.domain.model.Notification;

public interface NotificationRepository {

	Notification save(Notification notification);
}
