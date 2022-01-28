package com.mouritech.manytomany.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mouritech.manytomany.entity.Orders;
import com.mouritech.manytomany.util.HibernateUtil;

public class OrdersDao {
	public void saveOrders(Orders order) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();
			// save the employee object in to database
			session.save(order);
			// commit transaction
			transaction.commit();
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
	}

	public Orders getOrders(Long orderid) {
		Transaction transaction = null;
		Orders empById = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();
			// save the employee object in to database
			//session.saveOrUpdate(emp);
			
			//get entity from database
			empById = session.get(Orders.class, orderid);
			if(empById!=null) {
				
				System.out.println("Order details are = " + empById);
			}
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
		return empById;
		
	}
}
