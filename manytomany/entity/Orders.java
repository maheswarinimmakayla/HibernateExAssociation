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
@Table(name = "order_data")
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Long orderId;
	@Column(name = "customer_id")
	private Long customerId;
	@Column(name = "order_date")
	private LocalDate orderDOB;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name ="orders_items", joinColumns = { @JoinColumn(name = "item_id") }, inverseJoinColumns = {
			@JoinColumn(name = "order_id") })
	Set<Items> items = new HashSet<Items>();

	public Orders() {
		// TODO Auto-generated constructor stub
	}

	public Orders(Long customerId, LocalDate orderDOB, Set<Items> items) {
		super();
		this.customerId = customerId;
		this.orderDOB = orderDOB;
		this.items = items;
	}

	public Orders(Long orderId, Long customerId, LocalDate orderDOB, Set<Items> items) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.orderDOB = orderDOB;
		this.items = items;
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

	public LocalDate getOrderDOB() {
		return orderDOB;
	}

	public void setOrderDOB(LocalDate orderDOB) {
		this.orderDOB = orderDOB;
	}

	public Set<Items> getItems() {
		return items;
	}

	public void setItems(Set<Items> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", customerId=" + customerId + ", orderDOB=" + orderDOB + ", items="
				+ items + "]";
	}

	
}
