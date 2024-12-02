package com.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {

	public static void main(String[] args) {
	
	try {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		String url="jdbc:mysql://192.168.10.127:3306/dac103";
		Connection con=DriverManager.getConnection(url,"dac103","welcome");
		if(con!=null) {
			System.out.println("Connection done..");
		}else {
			System.out.println("not connected");
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	}

}

