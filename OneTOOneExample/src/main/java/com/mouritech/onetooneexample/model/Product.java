package com.mouritech.onetooneexample.model;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name = "Product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "productid")
  private Long productId;
	@Column(name = "productname")
  private String productName;
	@Column(name = "productprice")
  private Double productPrice;
	@Column(name = "productcategory")
  private String productCategory;
	@Column(name = "productmobileno")
	
  private Long productMobileNo;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_detail_id")
	private Product_Details product_details;
  
  public Product() {
	  
   }
  public Product(Long productId, String productName, Double productPrice, String productCategory, Long productMobileNo) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCategory = productCategory;
		this.productMobileNo = productMobileNo;
	}

	public Product(String productName, Double productPrice, String productCategory, Long productMobileNo) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCategory = productCategory;
		this.productMobileNo = productMobileNo;
	}
	  

public Long getProductId() {
	return productId;
}

public void setProductId(Long productId) {
	this.productId = productId;
}

public String getProductName() {
	return productName;
}

public void setProductName(String productName) {
	this.productName = productName;
}

public Double getProductPrice() {
	return productPrice;
}

public void setProductPrice(Double productPrice) {
	this.productPrice = productPrice;
}

public String getProductCategory() {
	return productCategory;
}

public void setProductCategory(String productCategory) {
	this.productCategory = productCategory;
}

public Long getProductMobileNo() {
	return productMobileNo;
}

public void setProductMobileNo(Long productMobileNo) {
	this.productMobileNo = productMobileNo;
}


public Product_Details getProduct_details() {
	return product_details;
}
public void setProduct_details(Product_Details product_details) {
	this.product_details = product_details;
}
@Override
public String toString() {
	return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
			+ ", productCategory=" + productCategory + ", productMobileNo=" + productMobileNo + "]";
}



  
}
