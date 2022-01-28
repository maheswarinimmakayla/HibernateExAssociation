package com.mouritech.manytomany;


import java.time.LocalDate;

import com.mouritech.manytomany.dao.OrdersDao;
import com.mouritech.manytomany.entity.Items;
import com.mouritech.manytomany.entity.Orders;

public class MianMethod {
	public static void main(String[] args) {
		// create orders
		Orders ord = new Orders();
		ord.setCustomerId(123L);
		ord.setOrderDate(LocalDate.of(1991, 11, 29));
		ord.setAmount(4004);
		
		
		//create Item
		Items item= new Items();
		item.setIteamName("Biriyani");
		
		//create Item
		Items item1= new Items();
		item1.setItemDescription(" Good Biriyani");
//		Project proj1= new Project();
//		proj1.setProjectName("Online Admission System");
		
		//allocation of Items for orders
//		emp.getProjects().add(proj);
//		emp.getProjects().add(proj1);
		ord.getItems().add(item);
		ord.getItems().add(item1);
		
//		
//		//adding orders reference in the items
//		proj.getEmployees().add(emp);
//		proj1.getEmployees().add(emp);
		item.getOrders().add(ord);
		item1.getOrders().add(ord);
		
//		
//		EmployeeDao edao = new EmployeeDao();
//		edao.saveEmployee(emp);

		OrdersDao orddao = new OrdersDao();
		orddao.saveOrders(ord);
	}
}
