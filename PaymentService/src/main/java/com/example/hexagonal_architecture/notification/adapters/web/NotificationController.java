package com.example.hexagonal_architecture.notification.adapters.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hexagonal_architecture.notification.application.NotificationService;
import com.example.hexagonal_architecture.notification.domain.model.Notification;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

	private final NotificationService service;

    public NotificationController(NotificationService service) {
        this.service = service;
    }

    @PostMapping("/send")
    public ResponseEntity<Notification> send(@RequestBody Notification notification) {
        return ResponseEntity.ok(service.send(notification));
    }
}
