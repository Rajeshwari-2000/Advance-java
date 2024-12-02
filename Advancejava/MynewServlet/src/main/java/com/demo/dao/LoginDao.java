package com.demo.dao;

import com.demo.beans.MyUser;
import com.demo.beans.Person;

public interface LoginDao {
	
	
	
	MyUser authenticateUser(String uname, String password);
	boolean savedetails(Person p1, MyUser u1);
}
