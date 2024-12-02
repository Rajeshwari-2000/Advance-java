package com.demo.Dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	boolean saveProduct(Product p);

	List<Product> getAll();

	boolean removeById(int pid);

	boolean modifyById(int pid, int qty, double price);

	Product getById(int pid);

	List<Product> arrangeByName();

	void shutdownSessionFactory();

}
