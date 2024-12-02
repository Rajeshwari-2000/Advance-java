package com.demo.service;

import java.util.List;

import com.demo.beans.Employee;

public interface EmployeeService {

	void addnewEmployee();

	boolean deleteById(int eid);

	boolean modifyById(int eid, String name, double sal, int deptid);

	Employee findById(int eid);

	List<Employee> findAll();

	List<Employee> sortBySal();

	void closeSessionFactory();

	boolean modifyByDeptId(int deptid2, String dname, String dloc, int eid1);

}
