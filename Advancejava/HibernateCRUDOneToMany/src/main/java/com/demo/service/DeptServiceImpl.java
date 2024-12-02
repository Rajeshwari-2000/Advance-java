package com.demo.service;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Department;
import com.demo.beans.Employee;
import com.demo.dao.DeptDao;
import com.demo.dao.DeptDaoImpl;

public class DeptServiceImpl implements DeptService {
	 DeptDao ddao;

	 public DeptServiceImpl() {
	 	super();
	 	this.ddao = new DeptDaoImpl();
	 }

	@Override
	public void addnewDepartment() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter deptid");
		int deptid=sc.nextInt();
		System.out.println("Enter dname");
		String dnm=sc.next();
		System.out.println("Enter location");
		String dloc=sc.next();
		Department d=new Department(deptid,dnm,dloc,null);
		ddao.saveDepartment(d);
		
	}

	@Override
	public boolean deleteByDeptId(int deptid) {
		return ddao.removeByDeptId(deptid);
	}

	@Override
	public boolean modifyByDeptId(int deptid2, String dname, String dloc, int eid1) {
		return ddao.updateByDeptId(deptid2,dname,dloc,eid1);
	}

	@Override
	public List<Department> findAllDept() {
		return ddao.getAllDept();
	}

	@Override
	public Department findById(int deptid) {
		return ddao.getById(deptid);
	}

	

}
