package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoginDaoImpl implements LoginDao{
	static Connection conn;
	static PreparedStatement seluser,adduser,sdetails;
	static {
		
		try {
			conn=DBUtil.getMyConnection();
			seluser=conn.prepareStatement("select uid,uname,role from user11 where uid=? and uname=?");
			adduser=conn.prepareStatement("insert into user(Uid,Uname,role) values(?,?,?)");
			sdetails=conn.prepareStatement("insert into person1(aid,name,email,balance) values(?,?,?,?)");	
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
