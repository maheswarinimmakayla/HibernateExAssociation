package com.mouritech.onetomanyex.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mouritech.onetomanyex.entity.Customers;
import com.mouritech.onetomanyex.util.HibernateUtil;

public class CustomerDao {
	public void saveCustomers(Customers cus) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();
			// save the employee object in to database
			session.save(cus);
			// commit transaction
//			transaction.commit();
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
	}

	public Customers getCustomers(Long customerid) {
		Transaction transaction = null;
		Customers empById = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();
			// save the employee object in to database
			//session.saveOrUpdate(emp);
			
			//get entity from database
			empById = session.get(Customers.class, customerid);
			if(empById!=null) {
				
				System.out.println("Employee details are = " + empById);
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
