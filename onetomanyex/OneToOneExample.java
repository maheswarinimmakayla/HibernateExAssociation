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
	
	Customers cus = new Customers(12L, "Rajitha");
	Customers cus1 = new Customers(13L, "mahi");
//	empDao.saveEmployee(emp);
	
	//create some departments
	Orders ord = new Orders(123L,12L,LocalDate.of(2022, 1, 2),200);
	Orders ord1 = new Orders(124L,13L,LocalDate.of(2022, 3, 2),200);
	cus.getOrders().add(ord);
	cus.getOrders().add(ord1);
	
	cusDao.saveCustomers(cus);
	cusDao.saveCustomers(cus1);
	
	
	
	

}
}
