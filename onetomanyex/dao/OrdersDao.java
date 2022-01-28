package com.mouritech.onetomanyex.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mouritech.onetomanyex.entity.Orders;
import com.mouritech.onetomanyex.util.HibernateUtil;

public class OrdersDao {
	public void saveEmployee(Orders ords) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();
			// save the employee object in to database
			session.save(ords);
			// commit transaction
			transaction.commit();
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
	}

	public Orders getDepartment(Long orderid) {
		Transaction transaction = null;
		Orders deptById = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();
			// save the employee object in to database
			//session.saveOrUpdate(emp);
			
			//get entity from database
			deptById = session.get(Orders.class, orderid);
			if(deptById!=null) {
				
				System.out.println("Employee details are = " + deptById);
			}
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
		return deptById;
		
	}
}
