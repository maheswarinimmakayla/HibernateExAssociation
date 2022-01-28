package com.mouritech.onetomanyex.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Orders")

public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderid")
private Long orderId;
	@Column(name = "customerid")
private Long customerId;
	@Column(name = "orderDate")
private LocalDate orderDate;
	@Column(name = "ammount")
private int ammount;
	public Orders() {
		
	}
	public Orders(Long customerId, LocalDate orderDate, int ammount) {
		super();
		this.customerId = customerId;
		this.orderDate = orderDate;
		this.ammount = ammount;
	}
	public Orders(Long orderId, Long customerId, LocalDate orderDate, int ammount) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.orderDate = orderDate;
		this.ammount = ammount;
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
	public int getAmmount() {
		return ammount;
	}
	public void setAmmount(int ammount) {
		this.ammount = ammount;
	}
	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", customerId=" + customerId + ", orderDate=" + orderDate + ", ammount="
				+ ammount + "]";
	}
	

}
