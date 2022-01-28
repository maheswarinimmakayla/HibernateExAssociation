package com.mouritech.onetomanyex.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customerid")
private Long customerId;
	@Column(name = "customername")
private String customerName;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Orders> orders = new ArrayList<Orders>();
	
	public List<Orders> getOrders() {
		return orders;
	}
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	public Customers() {
		
	}
	public Customers(Long customerId, String customerName) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
	}
	public Customers(String customerName) {
		super();
		this.customerName = customerName;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	@Override
	public String toString() {
		return "Customers [customerId=" + customerId + ", customerName=" + customerName + "]";
	}
	

}
