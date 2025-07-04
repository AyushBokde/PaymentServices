package com.example.hexagonal_architecture.payment.domain.model;

public class Payment {

	private Long id;
    private Long orderId;
    private String status;
    private Double amount;

    public Payment() {}
    public Payment(Long id, Long orderId, String status, Double amount) {
        this.id = id;
        this.orderId = orderId;
        this.status = status;
        this.amount = amount;
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Payment [id=" + id + ", orderId=" + orderId + ", status=" + status + ", amount=" + amount + "]";
	}
    
    
}
