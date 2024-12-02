package com.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class TestCreateStatement {

	public static void main(String[] args) {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url="jdbc:mysql://192.168.10.127:3306/dac103";
			Connection con=DriverManager.getConnection(url,"dac103","welcome");
			
			Statement st =con.createStatement();
			ResultSet rs=st.executeQuery("Select * from newbooks");
			while(rs.next()) {
				System.out.println("ID:"+rs.getInt(1));
				System.out.println("bookName:"+rs.getString(2));
				System.out.println("Type:"+rs.getString(3));
				System.out.println("Cost:"+rs.getInt(4));
				
				System.out.println("---------------------------------------------------------------------------------");
			}

			int ID=11;
			String bookName="Web Technology";
			String Type="Backpaper";
			int Cost=1020;
			
			
			String Query="insert into newbooks values("+ID+",'"+bookName+"','"+Type+"','"+Cost+"')";
			System.out.println(Query);
			int n=st.executeUpdate(Query);
			if(n>0)
				System.out.println("insertion done!!");
			else
				System.out.println("error ocurred");
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}



}
