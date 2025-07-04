package com.example.hexagonal_architecture.notification.domain.model;

public class Notification {

	 private Long id;
	    private String recipient;
	    private String subject;
	    private String message;

	    public Notification() {}

	    public Notification(Long id, String recipient, String subject, String message) {
	        this.id = id;
	        this.recipient = recipient;
	        this.subject = subject;
	        this.message = message;
	    }

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

		@Override
		public String toString() {
			return "Notification [id=" + id + ", recipient=" + recipient + ", subject=" + subject + ", message="
					+ message + "]";
		}

		
	    
}
