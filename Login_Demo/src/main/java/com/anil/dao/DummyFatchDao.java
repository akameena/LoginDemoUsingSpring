package com.anil.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.anil.model.Dummy_Data;

public class DummyFatchDao {

	public List<Dummy_Data> fatchDummy(int pid) {
		int pidc=pid;
		
		pid = (pid-1)*100;
		// TODO Auto-generated method stub
		Configuration conf = new Configuration().configure().addAnnotatedClass(Dummy_Data.class);
		//ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		Query q;
		System.out.println("_______________________________________");
		
			q = session.createQuery("from dummy_data");
			q.setFirstResult(pid);
			q.setMaxResults(100);
		
		List <Dummy_Data>list = q.list();
		System.out.println(list.size());
		
		session.beginTransaction().commit();
		return list;
	}

}
