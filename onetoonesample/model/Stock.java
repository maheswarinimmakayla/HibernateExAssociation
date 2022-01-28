package com.mouritech.onetoonesample.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Stock")
public class Stock {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "stockid")
	private int stockId;
	@Column(name = "stockname")
	private String stockName;
	@Column(name = "stockcode")
	private Long stockCode;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "stockid")
	private Stock_Details stock_detils;
	
	public Stock_Details getStock_detils() {
		return stock_detils;
	}
	public void setStock_detils(Stock_Details stock_detils) {
		this.stock_detils = stock_detils;
	}
	public Stock() {
		super();
		this.stockName = stockName;
		this.stockCode = stockCode;
	}
	public Stock(int stockId, String stockName, Long stockCode) {
		super();
		this.stockId = stockId;
		this.stockName = stockName;
		this.stockCode = stockCode;
	}
	
	public Stock(String stockName, long stockCode) {
		this.stockName = stockName;
		this.stockCode = stockCode;
	}
	public int getStockId() {
		return stockId;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public Long getStockCode() {
		return stockCode;
	}
	public void setStockCode(Long stockCode) {
		this.stockCode = stockCode;
	}
	@Override
	public String toString() {
		return "Stock [stockId=" + stockId + ", stockName=" + stockName + ", stockCode=" + stockCode + "]";
	}

}
