package com.demo.service;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {

	boolean addProduct();

	boolean removeById(int pid);

	boolean updateById(int pid, int qty, double price);

	Product getById(int pid);

	List<Product> getSortedByName();

	List<Product> getAllProducts();
	void closeMyConnection();

	

}
