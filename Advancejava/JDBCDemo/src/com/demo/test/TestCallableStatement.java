package com.demo.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestCallableStatement {

	public static void main(String[] args) {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url="jdbc:mysql://192.168.10.127:3306/dac103";
			Connection conn=DriverManager.getConnection(url,"dac103","welcome");
			CallableStatement cst=conn.prepareCall("call getcnt(?,?)"); 
			cst.setInt(1, 10);
			cst.registerOutParameter(2,java.sql.Types.INTEGER );
			cst.execute();
			
			int cnt=cst.getInt(2);
			System.out.println("Count : "+cnt);
			
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	}


