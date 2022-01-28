package com.mouritech.onetoonesample;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.mouritech.onetoonesample.dao.StockDao;
import com.mouritech.onetoonesample.model.Stock;
import com.mouritech.onetoonesample.model.Stock_Details;

public class HibernateOneToOneMainmethod {
	public static void main(String[] args) {
	String date = "29-01-2022";
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	LocalDate listedDate = LocalDate.parse(date,formatter);
	
	Stock st = new Stock("pen",343L);
    
    Stock_Details std = new Stock_Details("sony","sony","bestcompany",listedDate);
    st.setStock_detils(std);
    
    StockDao sdao = new StockDao();
    sdao.stockSave(st);
    
}
	



}
