package com.mouritech.manytomany.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mouritech.manytomany.entity.Orders;
import com.mouritech.manytomany.util.HibernateUtil;

public class OrdersDao {
	public void saveOrders(Orders ordrs) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();
			// save the employee object in to database
			session.save(ordrs);
			// commit transaction
			//transaction.commit();
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
	}

	public Orders getOrders(Long orderid) {
		Transaction transaction = null;
		Orders ordById = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();
			// save the employee object in to database
			//session.saveOrUpdate(emp);
			
			//get entity from database
			ordById = session.get(Orders.class, orderid);
			if(ordById!=null) {
				
				System.out.println("Order details are = " + ordById);
			}
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
		return ordById;
		
	}
}
