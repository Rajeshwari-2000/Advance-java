package com.demo.test;



import java.time.LocalDate;

import java.util.HashSet;

import java.util.Set;



import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.demo.beans.Department;
import com.demo.beans.Employee;

public class TestOnetoManyBidirectional {
	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Transaction tr = null;
		Session sess = null;
		try {
			sess = sf.openSession();
			tr = sess.beginTransaction();

			Department d1 = new Department();
			d1.setDeptid(1);
			d1.setDname("IT");
			d1.setDloc("Floor3");


			Department d2 = new Department();
			d2.setDeptid(2);
			d2.setDname("Elec");
			d2.setDloc("Floor4");

			Employee e1 = new Employee(101, "shanu", 1234, LocalDate.of(2024, 11, 15), d1);
			Employee e2 = new Employee(102, "manish", 4567, LocalDate.of(2024, 10, 28), d1);
			Employee e3 = new Employee(103, "hrishi", 9867, LocalDate.of(2024, 8, 15), d2);
			Employee e4 = new Employee(104, "prathmesh", 4521, LocalDate.of(2024, 5, 11), d2);

			Set<Employee> s1 = new HashSet<>();

			s1.add(e1);
			s1.add(e2);
			d1.setElist(s1);

			Set<Employee> s2 = new HashSet<>();

			s2.add(e3);
			s2.add(e4);
			d2.setElist(s2);

			sess.save(d1);
			sess.save(d2);
			sess.save(e1);
			sess.save(e2);
			sess.save(e3);
			sess.save(e4);
			tr.commit(); 

		} catch (Exception e) {
			if (tr != null) {
				tr.rollback();
			}
			e.printStackTrace();

		} finally {
			if (sess != null) {
				sess.close(); 
			}
			sf.close(); 
		}
	}
}