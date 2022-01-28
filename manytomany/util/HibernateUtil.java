package com.mouritech.manytomany.util;

import java.util.Properties;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.mouritech.manytomany.entity.Orders;
import org.hibernate.service.ServiceRegistry;

import com.mouritech.manytomany.entity.Items;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			try {
				Configuration cfg = new Configuration();
				
				//Hibernate settings equivalent to hibernate.cfg.xml properties
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				settings.put(Environment.URL,"jdbc:mysql://localhost:3306/mouritech_hibernateexamples");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS,"root");
				settings.put(Environment.DIALECT,"org.hibernate.dialect.MySQL5Dialect");
				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				settings.put(Environment.HBM2DDL_AUTO, "create");
				
				cfg.setProperties(settings);
				cfg.addAnnotatedClass(Orders.class);
				cfg.addAnnotatedClass(Items.class);
				
				serviceRegistry = new StandardServiceRegistryBuilder()
													.applySettings(cfg.getProperties()).build();
				System.out.println("Hibernate Java Configuration Service Registry Created....");
				sessionFactory = cfg.buildSessionFactory(serviceRegistry);
				return sessionFactory;
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}

	public static void shutdown() {
		if(serviceRegistry != null) {
			StandardServiceRegistryBuilder.destroy(serviceRegistry);
		}
	}
}
