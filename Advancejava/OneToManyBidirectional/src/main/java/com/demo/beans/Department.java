package com.demo.beans;



import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity(name = "mavendepartment")
public class Department {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 

	private int deptid;
	private String dname;
	private String dloc;
	@OneToMany(mappedBy = "d")
	private Set<Employee> elist;

	public Department() {
		super();
	}

	public Department(int deptid, String dname, String dloc, Set<Employee> elist) {
		super();
		this.deptid = deptid;
		this.dname = dname;
		this.dloc = dloc;
		this.elist = elist;
	}

	public int getDeptid() {
		return deptid;
	}

	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDloc() {
		return dloc;
	}

	public void setDloc(String dloc) {
		this.dloc = dloc;
	}

	public Set<Employee> getElist() {
		return elist;
	}

	public void setElist(Set<Employee> elist) {
		this.elist = elist;
	}

	@Override
	public String toString() {
		return "Department [deptid=" + deptid + ", dname=" + dname + ", dloc=" + dloc + ", elist=" + elist + "]";
	}

}