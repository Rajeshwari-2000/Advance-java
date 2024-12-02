package com.demo.test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class TestPreparedStatement2 {
	public static void main(String[] args) {

		try {

			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url="jdbc:mysql://192.168.10.127:3306/dac103";
			Connection conn=DriverManager.getConnection(url,"dac103","welcome");
			PreparedStatement pst=conn.prepareStatement("select * from Student_Order");
			ResultSet rs=pst.executeQuery();
			while (rs.next()) {


				System.out.println("Id :" + rs.getInt(1));
				System.out.println("StudentId :" + rs.getInt(2));
				System.out.println("Orderdate :" + rs.getDate(3));
				System.out.println("Amount:" + rs.getInt(4));
				
			
				System.out.println("-----------------------------------");
			}

			int Id=41;
			int StudentId=4;
			LocalDate dt=LocalDate.of(2025,03,02);
			java.sql.Date sdt=Date.valueOf(dt);
			int Amount=200;
			
			

			PreparedStatement pst1 = conn.prepareStatement("insert into Student_Order values(?,?,?,?)");

			pst1.setInt(1,Id);
			pst1.setInt(2, StudentId);
			pst1.setDate(3, sdt);
			pst1.setInt(4,Amount);
			
			

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

