package com.anil.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.anil.model.Dummy_Data;
import com.anil.model.User;

public class DummyDao {
	public Session openConnection()
	{
		Configuration conf = new Configuration().configure().addAnnotatedClass(Dummy_Data.class);
		ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
		SessionFactory sf = conf.buildSessionFactory(sr);
		Session session = sf.openSession();
		return session;
		
	}
	
	public void saveDummy(Dummy_Data duser,Session session) {
		session.save(duser);
	}
	
	public void closeConnection(Session session)
	{
		session.beginTransaction().commit();
	}
}
