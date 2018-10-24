package com.anil.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.anil.model.User;

public class Login_Dao {
	public boolean check_login_request(String uid,String pass)
	{
		
		Configuration conf = new Configuration().configure().addAnnotatedClass(User.class);
		//ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
		
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		Query q = session.createSQLQuery("select * from User where id=:uid1 and password = :pass");
		q.setString("uid1", uid);
		q.setString("pass",pass);
		
		//Query q = session.createQuery("from user where id="+'uid'+"and password="+'pass');
		if(q.list().size()!=0)
		{
			tx.commit();
			return true;
		}
		
		tx.commit();
		return false;
	}

}
