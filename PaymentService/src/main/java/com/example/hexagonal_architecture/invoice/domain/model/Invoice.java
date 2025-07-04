package com.example.hexagonal_architecture.invoice.domain.model;

public class Invoice {

	private Long id;
    private String customerName;
    private Double amount;

    public Invoice() {}

    public Invoice(Long id, String customerName, Double amount) {
        this.id = id;
        this.customerName = customerName;
        this.amount = amount;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Invoice [id=" + id + ", customerName=" + customerName + ", amount=" + amount + "]";
	}
    
    
}
