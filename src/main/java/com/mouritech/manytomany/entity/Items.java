package com.mouritech.manytomany.entity;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
@Table(name = "item_info")
public class Items {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "itemid")
private Long itemId;
	@Column(name = "itemname")
private String iteamName;
	@Column(name = "itemdescription")
private  String itemDescription;
	
	@ManyToMany(mappedBy = "items",cascade = {CascadeType.ALL})
	private Set<Orders> orders = new HashSet<Orders>();
	
	public Items() {
		
	}
	
	public Items(String iteamName, String itemDescription) {
		super();
		this.iteamName = iteamName;
		this.itemDescription = itemDescription;
	}
	public Items(long itemId, String iteamName, String itemDescription) {
		super();
		this.itemId = itemId;
		this.iteamName = iteamName;
		this.itemDescription = itemDescription;
	}
	public long getItemId() {
		return itemId;
	}
	public void setItemId(long itemId) {
		this.itemId = itemId;
	}
	public String getIteamName() {
		return iteamName;
	}
	public void setIteamName(String iteamName) {
		this.iteamName = iteamName;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	@Override
	public String toString() {
		return "Items [itemId=" + itemId + ", iteamName=" + iteamName + ", itemDescription=" + itemDescription + "]";
	}
	public Set<Orders> getOrders() {
		return orders;
	}


	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}


	
}
