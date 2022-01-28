package com.mouritech.onetooneexample.dao;
import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.mouritech.onetooneexample.model.Product;
import com.mouritech.onetooneexample.util.HibernateUtil;
public class ProductDao {
	public void productSave(Product p) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();
			// save the employee object in to database
			session.save(p);
			// commit transaction
			transaction.commit();
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
	}

	public void getAllProducts() {
		// retrieve the data from database to java program using hibernate
		//Transaction transaction = null;
				try (Session session = HibernateUtil.getSessionFactory().openSession()) {

					List<Product> productList = session.createQuery("from Product", Product.class).list();
					productList.forEach(p -> System.out.println(p));

				} catch (Exception e) {
					e.printStackTrace();
				}
				
		
	}
	public void deleteProduct1(Long productid) {
		Transaction transaction1 = null;
		try (Session session1 = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction1 = session1.beginTransaction();
			Product deleteProduct = session1.get(Product.class, productid);
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
	public void deleteProduct(Class<?> type,Serializable productid) {
		Transaction transaction1 = null;
		try (Session session1 = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction1 = session1.beginTransaction();
			Product p = session1.get(Product.class, productid);
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

	public void updateProduct(Long productid,Long productmobileno) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();
			// save the employee object in to database
			//session.saveOrUpdate(emp);
			
			//get entity from database
			Product updatingProduct = session.get(Product.class, productid);
			System.out.println(updatingProduct);
			//do changes
			updatingProduct.setProductMobileNo(productmobileno);
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

	public void getProductById(Long productid) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();
			// save the employee object in to database
			//session.saveOrUpdate(emp);
			
			//get entity from database
			Product pById = session.get(Product.class, productid);
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

	public void getProductDettailsById(Long productdetailsid) {
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


