package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Customer;
import com.demo.beans.Employee;

public class TestMappedSuperClass {
	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Employee e =new Employee(121,"xxx","333","hr","mgr");
		Customer c =new Customer(131,"yyy","333","baner","Rajesh");
		
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		
		sess.save(e);
		sess.save(c);
		tr.commit();
		sess.close();
		sf.close();
		

	}
}
