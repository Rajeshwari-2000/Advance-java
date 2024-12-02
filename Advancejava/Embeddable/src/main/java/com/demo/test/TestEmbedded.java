package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Address;
import com.demo.beans.Student;



public class TestEmbedded {
	public static void main(String[] args) {

		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		Address addr=new Address(100,"Maharshtra","Pune","411102");
		Student s1=new Student(12,"Rohan",67,addr);
		Session session1=sf.openSession();	
		Transaction tr=session1.beginTransaction();
		session1.save(s1);
		tr.commit();
		session1.close();
		sf.close();

	}
}
