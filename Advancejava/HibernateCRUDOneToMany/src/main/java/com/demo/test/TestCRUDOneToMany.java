package com.demo.test;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Department;
import com.demo.beans.Employee;
import com.demo.service.DeptService;
import com.demo.service.DeptServiceImpl;
import com.demo.service.EmployeeService;
import com.demo.service.EmployeeServiceImpl;

public class TestCRUDOneToMany {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		EmployeeService eservice=new EmployeeServiceImpl();
		DeptService dservice=new DeptServiceImpl();
		int choice=0;
		do {
			System.out.println("1. Add new Employee\n2. Add new Department");
			System.out.println("3. Delete employee\n4. Delete Department");
			System.out.println("5. Modify employee\n6. Modify Department");
			System.out.println("7. Display  employee by id\n8. Display Department by id");
			System.out.println("9. Display all employee\n10. Display all Department");
			System.out.println("11. Display all employee in sorted order\n12.Exit\nChoice :");
			
			choice=sc.nextInt();
			switch(choice) {
			case 1:
				eservice.addnewEmployee();
				break;

			case 2:
				dservice.addnewDepartment();
				break;

			case 3:
				System.out.println("Enter id");
				int eid=sc.nextInt();
				boolean status=eservice.deleteById(eid);
				if(status) {
					System.out.println("deleted successfully");
				}else {
					System.out.println("not found");
				}
				break;


			case 4:
				System.out.println("Enter department id");
				int deptid=sc.nextInt();
				boolean status1=dservice.deleteByDeptId(deptid);
				if(status1) {
					System.out.println("deleted successfully");
				}else {
					System.out.println("not found");
				}
				break;


			case 5:
				System.out.println("Enter id");
				eid=sc.nextInt();
				System.out.println("Enter name");
				String name=sc.next();
				System.out.println("Enter salary");
				double sal=sc.nextDouble();
				System.out.println("Enter department id");
				int deptid1=sc.nextInt();
				status1=eservice.modifyById(eid,name,sal,deptid1);
				if(status1) {
					System.out.println("updated successfully");
				}else {
					System.out.println("not found");
				}
				break;


			case 6:
				System.out.println("Enter department id");
				int deptid2=sc.nextInt();
				
				System.out.println("Enter department name");
				String dname=sc.next();
				
				System.out.println("Enter department Location");
				String dloc=sc.next();
				
				System.out.println("Enter Employee id");
				int eid1=sc.nextInt();
				
				status1=dservice.modifyByDeptId(deptid2,dname,dloc,eid1);
				if(status1) {
					System.out.println("updated successfully");
				}else {
					System.out.println("not found");
				}
				break;


			case 7:
				System.out.println("Enter Employee id");
				eid=sc.nextInt();
				Employee e=eservice.findById(eid);
				if(e!=null) {
					System.out.println(e);
				}else {
					System.out.println("ID not found");
				}
				break;


			case 8:
				System.out.println("Enter department id");
				deptid=sc.nextInt();
				Department d=dservice.findById(deptid);
				if(d!=null) {
					System.out.println(d);
				}else {
					System.out.println("not found");
				}
				break;


			case 9:
				List<Employee> elist=eservice.findAll();
				elist.forEach(System.out::println);
				break;


			case 10:
				List<Department> dlist=dservice.findAllDept();
				dlist.forEach(System.out::println);
				break;


			case 11:
				elist=eservice.sortBySal();
				elist.forEach(System.out::println);
				break;


			case 12:
				System.out.println("Thank you for Visiting......");
				sc.close();
				eservice.closeSessionFactory();
				break;

			default:
				System.out.println("Wrong choice");
				break;
			}
		}while(choice!=12);
	}

}
