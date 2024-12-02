package com.demo.test;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

public class TestCrudDemo {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		ProductService pservice=new ProductServiceImpl();
		int choice=0;
		do {
			System.out.println("1.Add New Product\n2.DisplayALL\n3.Delete By Id\n4.Update By Id \n5. Display By Id");
			System.out.println("6.Sort By Name\n7.exit\n.choice:");
			choice=sc.nextInt();
			switch(choice) {

			case 1:
				boolean status=pservice.addnewProduct();
				if(status) {
					System.out.println("Product added Sucessfully..");
				}else {
					System.out.println("error ocurred");
				}
				break;
				

			case 2:
				List<Product>plist=pservice.findAll();
				plist.forEach(System.out::println);
				break;
				
			case 3:
				System.out.println("Enter the ID");
				int pid=sc.nextInt();
				status=pservice.deleteById(pid);
				if(status) {
					System.out.println("Product Deleted Sucessfully..");
				}else {
					System.out.println("error ocurred");
				}
				break;
				
			case 4:
				System.out.println("Enter the ID");
				int pid1=sc.nextInt();
				
				System.out.println("Enter Qty");
				int qty=sc.nextInt();
				
				System.out.println("Enter the price");
				double price=sc.nextDouble();
				status=pservice.updateById(pid1,qty,price);
				if(status) {
					System.out.println("Product update Sucessfully..");
				}else {
					System.out.println("error ocurred");
				}
				break;
				
			case 5:
				
				System.out.println("Enter the Id");
				int pid2=sc.nextInt();
				Product p=pservice.findById(pid2);
				if(p!=null) {
					System.out.println(p);
				}else {
					System.out.println("Product not Found"+pid2);
				}
				break;
				
			case 6:
				plist=pservice.sortByName();
				if(plist!=null)
					plist.forEach(System.out::println);
				else
					System.out.println("Table is empty...");
				break;
				
				
			case 7:
				System.out.println("Thank you for visiting....");
				sc.close();
				pservice.closeSessionFactory();
				break;
				
			default:
				System.out.println("Wrong choice");
				break;
			}

		}while(choice!=7);

	}

}
