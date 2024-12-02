package com.demo.beans;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="employee13")
public class Employee extends Person{
	private String dept;
	private String desg;
	
	
	public Employee() {
		super();
	}


	public Employee(int pid, String pname, String mob, String dept, String desg) {
		super(pid, pname, mob);
		this.dept = dept;
		this.desg = desg;
	}


	public String getDept() {
		return dept;
	}


	public void setDept(String dept) {
		this.dept = dept;
	}


	public String getDesg() {
		return desg;
	}


	public void setDesg(String desg) {
		this.desg = desg;
	}


	@Override
	public String toString() {
		return "Employee [dept=" + dept + ", desg=" + desg + "]";
	}


	
	
	

}
