package com.demo.test;
import java.sql.Connection;

import java.sql.Date;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.time.LocalDate;

public class TestPreparedStatement {
	public static void main(String[] args) {

		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url="jdbc:mysql://192.168.10.127:3306/dac103";
			Connection conn=DriverManager.getConnection(url,"dac103","welcome");
			PreparedStatement pst=conn.prepareStatement("select * from newbooks");
			ResultSet rs=pst.executeQuery();
			while (rs.next()) {

				System.out.println("ID :" + rs.getInt(1));
				System.out.println("bookName :" + rs.getString(2));
				System.out.println("Type :" + rs.getString(3));
				System.out.println("Cost :" + rs.getInt(4));
			
				System.out.println("-----------------------------------");
			}

			int ID=12;
			String bookName="Aptitude";
			String Type="Backpaper";
			int Cost=500;
			
			PreparedStatement pst1 = conn.prepareStatement("insert into newbooks values(?,?,?,?)");
			pst1.setInt(1, ID);
			pst1.setString(2, bookName);
			pst1.setString(3, Type);
			pst1.setInt(4, Cost);
			int n =pst1.executeUpdate();

			if (n>0) {
				System.out.println("Data Inserted Succesfully");
			}else {
				System.out.println("Data Not Inserted");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}


