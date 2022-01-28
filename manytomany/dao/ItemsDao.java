package com.mouritech.manytomany.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mouritech.manytomany.entity.Items;
import com.mouritech.manytomany.util.HibernateUtil;

public class ItemsDao {
	public void saveItems(Items item) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();
			// save the employee object in to database
			session.save(item);
			// commit transaction
			transaction.commit();
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
	}

	public Items getItem(Long itemid) {
		Transaction transaction = null;
		Items itemById = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();
			// save the employee object in to database
			//session.saveOrUpdate(emp);
			
			//get entity from database
			itemById = session.get(Items.class, itemid);
			if(itemById!=null) {
				
				System.out.println("Item details are = " + itemById);
			}
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
		return itemById;
		
	}
}
