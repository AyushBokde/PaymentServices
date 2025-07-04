package com.example.hexagonal_architecture.notification.adapters.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "notifications")
public class NotificationEntity {

	    @Id 
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String recipient;
	    private String subject;
	    private String message;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getRecipient() {
			return recipient;
		}
		public void setRecipient(String recipient) {
			this.recipient = recipient;
		}
		public String getSubject() {
			return subject;
		}
		public void setSubject(String subject) {
			this.subject = subject;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
	    
	    
}
