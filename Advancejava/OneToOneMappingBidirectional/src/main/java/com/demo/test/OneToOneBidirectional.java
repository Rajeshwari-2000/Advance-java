package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Course;

public class OneToOneBidirectional {

	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		  Session sess1=sf.openSession(); 
		  Transaction tr1=sess1.beginTransaction();
		  Course c=sess1.get(Course.class, 1); 
		  if(c!=null) { 
			  sess1.delete(c); 
			 }
		  sess1.save(c);
		  tr1.commit(); 
		  sess1.close();
		 
		sf.close();
		

	}

}
