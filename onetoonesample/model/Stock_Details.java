package com.mouritech.onetoonesample.model;
import java.time.LocalDate;
import java.time.LocalDate;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.mouritech.onetoonesample.model.Stock;

@Entity
@Table(name = "Stock_Details")
public class Stock_Details {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "stockid")
    private int stackId;
	@Column(name = "compname")
	private String  compName;
	@Column(name = "compdesc")
	private String compDesc;
	@Column(name = "remarks")
	private String remarks;
	@Column(name = "listeddate")
	private LocalDate listedDate;
	  
   
	
	public Stock_Details(int stackId, String compName, String compDesc, String remarks, LocalDate listedDate) {
		super();
		this.stackId = stackId;
		this.compName = compName;
		this.compDesc = compDesc;
		this.remarks = remarks;
		this.listedDate = listedDate;
	}
	public Stock_Details(String compName, String compDesc, String remarks, LocalDate listedDate) {
		super();
		this.compName = compName;
		this.compDesc = compDesc;
		this.remarks = remarks;
		this.listedDate = listedDate;
	}
	public int getStackId() {
		return stackId;
	}
	public void setStackId(int stackId) {
		this.stackId = stackId;
	}
	public String getCompName() {
		return compName;
	}
	public void setCompName(String compName) {
		this.compName = compName;
	}
	public String getCompDesc() {
		return compDesc;
	}
	public void setCompDesc(String compDesc) {
		this.compDesc = compDesc;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public LocalDate getListedDate() {
		return listedDate;
	}
	public void setListedDate(LocalDate listedDate) {
		this.listedDate = listedDate;
	}
	
	@Override
	public String toString() {
		return "Stock_Details [stackId=" + stackId + ", compName=" + compName + ", compDesc=" + compDesc + ", remarks="
				+ remarks + ", listedDate=" + listedDate + "]";
	}
	
}
