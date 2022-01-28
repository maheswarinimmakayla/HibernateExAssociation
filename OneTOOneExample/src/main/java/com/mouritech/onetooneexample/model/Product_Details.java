package com.mouritech.onetooneexample.model;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "Product_Details")
public class Product_Details {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "productdetailsid")
private Long productDetailsId;
@Column(name = "productfirstname")
private String productFarstName;
@Column(name = "productlastname")
private String productLastName;


public Product_Details(Long productDetailsId, String productFarstName, String productLastName, String hobby) {
	super();
	this.productDetailsId = productDetailsId;
	this.productFarstName = productFarstName;
	this.productLastName = productLastName;

}

public Product_Details(String productFarstName, String productLastName) {
	super();
	this.productFarstName = productFarstName;
	this.productLastName = productLastName;

}

public Long getProductDetailsId() {
	return productDetailsId;
}

public void setProductDetailsId(Long productDetailsId) {
	this.productDetailsId = productDetailsId;
}

public String getProductFarstName() {
	return productFarstName;
}

public void setProductFarstName(String productFarstName) {
	this.productFarstName = productFarstName;
}

public String getProductLastName() {
	return productLastName;
}

public void setProductLastName(String productLastName) {
	this.productLastName = productLastName;
}





}
