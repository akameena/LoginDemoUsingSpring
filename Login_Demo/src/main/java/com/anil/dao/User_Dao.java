package com.anil.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.anil.model.User;

public class User_Dao {
	
	
	public void user_in_db(User user)
	{
		System.out.println("hello1");
		Configuration conf = new Configuration().configure().addAnnotatedClass(User.class);
		System.out.println("hello2");
		ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
		SessionFactory sf = conf.buildSessionFactory(sr);
		
		System.out.println("hello3");
		Session session = sf.openSession();
		System.out.println("hello4");
		Transaction tx = session.beginTransaction();
		System.out.println("hello5");
		session.save(user);
		System.out.println("hello6");
		tx.commit();
		
		
	}

}
