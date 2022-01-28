package com.mouritech.manytomany.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mouritech.manytomany.entity.Items;
import com.mouritech.manytomany.util.HibernateUtil;

public class ItemsDao {
	public void saveItems(Items items) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();
			// save the employee object in to database
			session.save(items);
			// commit transaction
			transaction.commit();
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
	}

	public Items getItems(Long itemid) {
		Transaction transaction = null;
		Items projectById = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();
			// save the employee object in to database
			//session.saveOrUpdate(emp);
			
			//get entity from database
			projectById = session.get(Items.class, itemid);
			if(projectById!=null) {
				
				System.out.println("Employee details are = " + projectById);
			}
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
		return projectById;
		
	}
}
