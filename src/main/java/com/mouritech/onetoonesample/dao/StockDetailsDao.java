package com.mouritech.onetoonesample.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import  com.mouritech.onetoonesample.model.Stock;
import com.mouritech.onetoonesample.model.Stock_Details;
import com.mouritech.onetoonesample.util.HibernateUtil;


public class StockDetailsDao {
	public void stockDetailsSave(Stock_Details sd) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();
			// save the employee object in to database
			session.save(sd);
			// commit transaction
			transaction.commit();
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
	}

	public void getAllStockDetails() {
		// retrieve the data from database to java program using hibernate
		//Transaction transaction = null;
				try (Session session = HibernateUtil.getSessionFactory().openSession()) {

					List<Stock_Details> productList = session.createQuery("from Stock_Details", Stock_Details.class).list();
					productList.forEach(p -> System.out.println(p));

				} catch (Exception e) {
					e.printStackTrace();
				}
				
		
	}
	public void deleteProductDetails1(int stackid) {
		Transaction transaction1 = null;
		try (Session session1 = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction1 = session1.beginTransaction();
			Stock_Details deleteProduct = session1.get(Stock_Details.class, stackid);
			System.out.println(deleteProduct);
			if(deleteProduct!=null) {
				session1.delete(deleteProduct);
				System.out.println("Product deleted successfully");
			}
			
			/*
			 * Employee emp2 = new Employee(); emp2.setEmpId(empid); session1.delete(emp2);
			 * System.out.println("Employee deleted"); transaction1.commit();
			 */
			transaction1.commit();
			
		}catch (Exception e) {
			if (transaction1 != null) {
				transaction1.rollback();
			}

			e.printStackTrace();
		}
		
	}
	public void deleteProductDetilas(Class<Stock_Details> type,Serializable stackid) {
		Transaction transaction1 = null;
		try (Session session1 = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction1 = session1.beginTransaction();
			Stock_Details p = session1.get(Stock_Details.class, stackid);
			System.out.println(p);
			if(p!=null) {
				session1.remove(p);
				System.out.println("product deleted successfully");
			}
			
			/*
			 * Employee emp2 = new Employee(); emp2.setEmpId(empid); session1.delete(emp2);
			 * System.out.println("Employee deleted"); transaction1.commit();
			 */
			transaction1.commit();
			
		}catch (Exception e) {
			if (transaction1 != null) {
				transaction1.rollback();
			}

			e.printStackTrace();
		}
		
	}

	public void updateProductDetilas(Long stackid,String compName) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();
			// save the employee object in to database
			//session.saveOrUpdate(emp);
			
			//get entity from database
			Stock_Details updatingProduct = session.get(Stock_Details.class, stackid);
			System.out.println(updatingProduct);
			//do changes
			updatingProduct.setCompName(compName);
			//update the Employee object
			session.saveOrUpdate(updatingProduct);
			// commit transaction
			transaction.commit();
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
		
	}

	public void getStockDettailsById(int stackid) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();
			// save the employee object in to database
			//session.saveOrUpdate(emp);
			
			//get entity from database
			Stock_Details pById = session.get(Stock_Details.class, stackid);
			if(pById!=null) {
				
				System.out.println("productdetails details are = " + pById);
			}
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
		
	

	//@SuppressWarnings({ "unchecked", "deprecation" })
//	public void deleteByName(String empName) {
//		Transaction transaction1 = null;
//		try (Session session1 = HibernateUtil.getSessionFactory().openSession()) {
//			
//			// start the transaction
//			transaction1 = session1.beginTransaction();
//			//String deleteSql = "Delete from Employee Where empName = :empName";
//			Query<Product> deleteQuery = session1.createQuery
//					("delete from Employee where empName = :empName");
//			deleteQuery.setParameter("empName",empName);
//			int deleteStatus = deleteQuery.executeUpdate();
//			System.out.println(deleteStatus);
//			transaction1.commit();
//			
//		}catch (Exception e) {
//			if (transaction1 != null) {
//				transaction1.rollback();
//			}
//
//			e.printStackTrace();
//		}
	
	}
}
