package com.example.hexagonal_architecture.order_service.domin.model;


public class order {

	private Long id;
    private String status;
    private String details;

    public order() {}

    public order(Long id, String status, String details) {
        this.id = id;
        this.status = status;
        this.details = details;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", status=" + status + ", details=" + details + "]";
	}
    
    
}
