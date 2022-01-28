package com.mouritech.onetoonesample.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import  com.mouritech.onetoonesample.model.Stock;
import com.mouritech.onetoonesample.util.HibernateUtil;

public class StockDao {
	public void stockSave(Stock s) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();
			// save the employee object in to database
			session.save(s);
			// commit transaction
			transaction.commit();
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
	}

	public void getAllStocks() {
		// retrieve the data from database to java program using hibernate
		//Transaction transaction = null;
				try (Session session = HibernateUtil.getSessionFactory().openSession()) {

					List<Stock> productList = session.createQuery("from Stock", Stock.class).list();
					productList.forEach(p -> System.out.println(p));

				} catch (Exception e) {
					e.printStackTrace();
				}
				
		
	}
	public void deleteStock1(Long stockid) {
		Transaction transaction1 = null;
		try (Session session1 = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction1 = session1.beginTransaction();
			Stock deleteProduct = session1.get(Stock.class, stockid);
			System.out.println(deleteProduct);
			if(deleteProduct!=null) {
				session1.delete(deleteProduct);
				System.out.println("Stock deleted successfully");
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
	public void deleteProduct(Class<?> type,Serializable stockid) {
		Transaction transaction1 = null;
		try (Session session1 = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction1 = session1.beginTransaction();
			Stock s = session1.get(Stock.class, stockid);
			System.out.println(s);
			if(s!=null) {
				session1.remove(s);
				System.out.println("stockid deleted successfully");
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

	public void updateStcok(Long stockid,Long stockCode) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();
			// save the employee object in to database
			//session.saveOrUpdate(emp);
			
			//get entity from database
			Stock updatingStock = session.get(Stock.class, stockid);
			System.out.println(updatingStock);
			//do changes
			updatingStock.setStockCode(stockCode);
			//update the Employee object
			session.saveOrUpdate(updatingStock);
			// commit transaction
			transaction.commit();
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
		
	}

	public void getStockById(Long stockid) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();
			// save the employee object in to database
			//session.saveOrUpdate(emp);
			
			//get entity from database
			Stock pById = session.get(Stock.class, stockid);
			if(pById!=null) {
				
				System.out.println("Product details are = " + pById);
			}
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
		
	}

	public void getStockDettailsById(int stackId) {
		// TODO Auto-generated method stub
		
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
