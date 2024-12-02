package com.demo.beans;

import java.time.LocalDate;

public class Product {
	
	private int pid;
	private String pname;
	private int qty;
	private double price;
	private LocalDate expDate;
	private int cid;
	public Product() {
		super();
		
	}
	public Product(int pid, String pname, int qty, double price, LocalDate expDate, int cid) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.qty = qty;
		this.price = price;
		this.expDate = expDate;
		this.cid = cid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public LocalDate getExpDate() {
		return expDate;
	}
	public void setExpDate(LocalDate expDate) {
		this.expDate = expDate;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", qty=" + qty + ", price=" + price + ", expDate=" + expDate
				+ ", cid=" + cid + "]";
	}
	
	
	
	
	
	
		
	
	
	

}
