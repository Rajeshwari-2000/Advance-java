package com.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class TestSQLInjection {

	public static void main(String[] args) {
		try {
		
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url="jdbc:mysql://192.168.10.127:3306/dac103";
			Connection con=DriverManager.getConnection(url,"dac103","welcome");
			
			Statement st=con.createStatement();
			String user="yyy";
			String password="xxx' or '1'='1";
			
			String query="select * from user where uname='"+user+"' and password='"+password+"'";
		
			System.out.println(query);
			ResultSet rs=st.executeQuery(query);
			
			System.out.println("-----------------------------------------------------------------------------------");
			while(rs.next()) {
				System.out.println("User : "+rs.getString(1));
				System.out.println("Password : "+rs.getString(2));
				System.out.println("role : "+rs.getString(3));
				System.out.println("-------------------------------------------------------------------------------");
			}
					
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

}
