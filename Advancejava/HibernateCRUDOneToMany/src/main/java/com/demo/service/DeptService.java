package com.demo.service;

import java.util.List;

import com.demo.beans.Department;
import com.demo.beans.Employee;

public interface DeptService {

	void addnewDepartment();

	boolean deleteByDeptId(int deptid);

	boolean modifyByDeptId(int deptid2, String dname, String dloc, int eid1);

	List<Department> findAllDept();

	Department findById(int deptid);

}
