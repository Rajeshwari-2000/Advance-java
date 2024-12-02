package com.demo.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {
	private static Connection conn =null;
	public static Connection getMyConnection(){
		if(conn==null) {
			try {
				DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
				String url="jdbc:mysql://192.168.10.127:3306/dac103";
				 conn=DriverManager.getConnection(url,"dac103","welcome");
				if(conn!=null) {
					System.out.println("Connection done..");
				}else {
					System.out.println("not connected");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return conn;

	}
	public static void CloseMyConnection() {
		if(conn!=null) {

			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
