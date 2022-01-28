package com.mouritech.onetomanyex;

import java.time.LocalDate;

import com.mouritech.onetomanyex.dao.CustomerDao;
import com.mouritech.onetomanyex.dao.OrdersDao;
import com.mouritech.onetomanyex.entity.Customers;
import com.mouritech.onetomanyex.entity.Orders;

public class OneToOneExample {
public static void main(String[] args) {
	CustomerDao cusDao = new CustomerDao();
	OrdersDao ordDao = new OrdersDao();
	
	Customers cus = new Customers(12L, "R");
//	empDao.saveEmployee(emp);
	
	//create some departments
	Orders ord = new Orders(123L,124L,LocalDate.of(2022, 1, 21),200);
	cus.getOrders().add(ord);
	
	cusDao.saveCustomers(cus);
	
	
	
	System.out.println("Employee By ID  =" +cusDao.getCustomers(12L));

}
}
