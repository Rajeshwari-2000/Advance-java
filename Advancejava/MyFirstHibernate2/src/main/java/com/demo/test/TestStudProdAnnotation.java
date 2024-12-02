package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Product;
import com.demo.beans.Student;

public class TestStudProdAnnotation {

	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Student s1=new Student("Anil","4444",97);
		Student s2=new Student("Vandana","5555",97);
		Product p1=new Product("table",23,4000);
		Product p2=new Product("chair",45,3000);
	
		Session session1=sf.openSession();
		Transaction tr1=session1.beginTransaction();
		Student ss1=session1.get(Student.class,1);
		System.out.println(ss1);
		System.out.println("before get method");
		
		Product pp1=session1.load(Product.class,2);
		System.out.println("After get method");
		
		System.out.println(pp1.getPname());
		session1.save(s1);
		session1.save(s2);
		session1.save(p1);
		session1.save(p2);
		tr1.commit();
		session1.close();
		sf.close();
		
		
		

	}

}
