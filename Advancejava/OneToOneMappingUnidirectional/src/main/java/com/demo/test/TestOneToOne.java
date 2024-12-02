package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Course;
import com.demo.beans.Faculty;

public class TestOneToOne {
	public static void main(String[] args) {
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session sess2=sf.openSession();
		Transaction tr= sess2.beginTransaction();
		
		Course c= new Course("java",90);
		Faculty f=new Faculty("xxx","yyy",c);
		
		sess2.save(c);
		sess2.save(f);
		
		tr.commit();
		sess2.close();
	
		sf.close();
	}

}
