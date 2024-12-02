package com.demo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.demo.beans.Product;
import com.demo.dao.ProductDaoImpl;
import com.demo.dao.ProducttDao;

public class ProductServiceImpl implements ProductService {
	
	private ProducttDao pdao;

	public ProductServiceImpl() {
		super();
		this.pdao = new ProductDaoImpl();
	}

	@Override
	public boolean addProduct() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter pid");
		int pid=sc.nextInt();
		System.out.println("Enter pname: ");
		String pname=sc.next();
		System.out.println("Enter quantity: ");
		int qty = sc.nextInt();
		System.out.println("Enter price: ");
		double price = sc.nextDouble();
		System.out.println("Enter expiry date: YYYY/dd/MM");
		String date = sc.next();
		LocalDate ldt = LocalDate.parse(date, DateTimeFormatter.ofPattern("YYYY/dd/MM"));
		System.out.println("Enter category id: ");
		int cid = sc.nextInt();
		Product p = new Product(pid, pname, qty, price, ldt, cid);
		return pdao.save(p);
	}

	@Override
	public boolean removeById(int pid) {
		return pdao.deleteById(pid);
	}

	@Override
	public boolean updateById(int pid, int qty, double price) {
		return pdao.updateById(pid, qty, price);
	}

	
	@Override
	public Product getById(int pid) {
		return pdao.findById(pid);
	}

	@Override
	public List<Product> getSortedByName() {
		return pdao.getSortedByName();
	}

	@Override
	public List<Product> getAllProducts() {
		return pdao.findAllProducts();
	}

	@Override
	public void closeMyConnection() {
		pdao.closeConnection();
	}



	



	


	
	   
	
	
	

}
