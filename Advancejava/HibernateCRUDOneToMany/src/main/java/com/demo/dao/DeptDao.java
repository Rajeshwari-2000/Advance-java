package com.demo.dao;

import java.util.List;

import com.demo.beans.Department;

public interface DeptDao {

	void saveDepartment(Department d);

	boolean removeByDeptId(int deptid);

	boolean updateByDeptId(int deptid2, String dname, String dloc, int eid1);

	List<Department> getAllDept();

	Department getById(int deptid);

}
