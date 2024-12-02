package com.demo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.demo.beans.Department;
import com.demo.beans.Employee;
import com.demo.dao.EmployeeDao;
import com.demo.dao.EmployeeDaoImpl;



public class EmployeeServiceImpl implements EmployeeService{
	EmployeeDao edao;

	public EmployeeServiceImpl() {
		super();
		this.edao = new EmployeeDaoImpl();

	}

	public void closeSessionFactory() {
		edao.closeMyConnection();

	}

	public void addnewEmployee() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter id");
		int eid=sc.nextInt();
		System.out.println("Enter name");
		String ename=sc.next();
		System.out.println("Enter salary");
		double sal=sc.nextDouble();
		System.out.println("Enter Date of Joining (dd/MM/yyyy)");
		String dt=sc.next();
		LocalDate ldt=LocalDate.parse(dt,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.println("Enter department id");
		int deptid=sc.nextInt();

		Employee e=new Employee(eid,ename,sal,ldt,new Department(deptid));
		edao.saveEmployee(e);


	}

	public boolean deleteById(int eid) {
		return edao.removeById(eid);
	}

	public boolean modifyById(int eid, String name, double sal, int deptid) {
		return edao.updateById(eid,name,sal,deptid);
	}

	public Employee findById(int eid) {
		return edao.getById(eid);
	}

	@Override
	public List<Employee> findAll() {
		return edao.getAll();
	}

	@Override
	public List<Employee> sortBySal() {
		return edao.arrangeBySal();
	}

	@Override
	public boolean modifyByDeptId(int deptid2, String dname, String dloc, int eid1) {
		
		return false;
	}

}
