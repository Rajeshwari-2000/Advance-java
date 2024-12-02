package com.demo.service;

import java.util.List;
import java.util.Scanner;

import com.demo.Dao.ProductDao;
import com.demo.Dao.ProductDaoImpl;
import com.demo.beans.Product;

public class ProductServiceImpl implements ProductService {

	private ProductDao pdao;

	public ProductServiceImpl() {
		super();
		this.pdao = new ProductDaoImpl();
	}
	@Override
	public boolean addnewProduct() {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter name");
		String pname=sc.next();
		
		System.out.println("Enter the qty");
		int qty=sc.nextInt();
		
		System.out.println("Enter the price");
		double price=sc.nextDouble();
		
		Product p= new Product(pname,qty,price);
		
		return pdao.saveProduct(p);
	}

	
	@Override
	public List<Product> findAll() {
		return pdao.getAll();
	}

	
	@Override
	public boolean deleteById(int pid) {
		return pdao.removeById(pid);
	}

	@Override
	public boolean updateById(int pid, int qty, double price) {
		return pdao.modifyById(pid,qty,price);
	}

	@Override
	public Product findById(int pid) {
		return pdao.getById(pid);
	}

	@Override
	public List<Product> sortByName() {
		
		return pdao.arrangeByName();
	}

	@Override
	public void closeSessionFactory() {
		pdao.shutdownSessionFactory();
		
	}

}
