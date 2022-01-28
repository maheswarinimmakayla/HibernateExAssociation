package com.mouritech.manytomany.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name ="order")
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderid")
	private Long orderId;
	@Column(name = "customerid")
	private Long customerId;
	@Column(name = "orderdate")
	private  LocalDate orderDate;
	@Column(name = "amount")
	private int amount;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "item_orders",joinColumns = {@JoinColumn(name = "orderid")},
					inverseJoinColumns = {@JoinColumn(name = "itemid")})
	Set<Items> items = new HashSet<Items>();
	
	
	public Set<Items> getItems() {
		return items;
	}

	public void setItems(Set<Items> items) {
		this.items = items;
	}
	public Orders() {
		
	}

	public Orders(Long customerId, LocalDate orderDate, int amount) {
		super();
		this.customerId = customerId;
		this.orderDate = orderDate;
		this.amount = amount;
	}
	
	public Orders(Long orderId, Long customerId, LocalDate orderDate, int amount) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.orderDate = orderDate;
		this.amount = amount;
	}

	

	

	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	
	
	
}
