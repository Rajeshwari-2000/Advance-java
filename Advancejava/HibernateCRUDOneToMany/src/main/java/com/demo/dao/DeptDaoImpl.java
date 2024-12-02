package com.demo.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.demo.beans.Department;
import com.demo.beans.Employee;

public class DeptDaoImpl implements DeptDao{
	static SessionFactory sf;
	static {
		sf=HibernateUtil.getMyConnection();
	}
	@Override
	public void saveDepartment(Department d) {
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		sess.save(d);
		tr.commit();
		sess.close();

	}
	@Override
	public boolean removeByDeptId(int deptid) {
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		Department d=sess.get(Department.class, deptid);
		boolean status=false;
		if(d!=null) {
			sess.delete(d);
			status=true;
		}
		tr.commit();
		sess.close();
		return status;
	}
	@Override
	public boolean updateByDeptId(int deptid2, String dname, String dloc, int eid1) {
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		Department d=sess.get(Department.class, deptid2);
		boolean status=false;
		if(d!=null) {
			d.setDname(dname);
			d.setDloc(dloc);
		//Employee e=sess.get(Employee.class,eid1);
		//	d.setElist(e);
			sess.update(d);
			status=true;
		}		
		tr.commit();
		sess.close();
		return status;
	}
	@Override
	public List<Department> getAllDept() {
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		Query q=sess.createQuery("from Employee");
		List<Department> dlist=q.getResultList();
		tr.commit();
		sess.close();
		return dlist;

	}
	@Override
	public Department getById(int deptid) {
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		Department d=sess.get(Department.class, deptid);
		tr.commit();
		sess.close();
		return d;
	}
}
