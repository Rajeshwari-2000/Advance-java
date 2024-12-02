package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.beans.MyUser;

public class LoginDaoImpl implements LoginDao{
	private static Connection conn;
	private static PreparedStatement selUser;
	static {

		try {
			conn=DButil.getMyConnection();
			selUser=conn.prepareStatement("select uname, password,role from user where uname=? and password=?");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public MyUser authenticateUser(String uname, String password) {
		try {
			selUser.setString(1, uname);
			selUser.setString(2, password);
			ResultSet rs=selUser.executeQuery();
			if(rs.next()) {
				return new MyUser(rs.getString(1),rs.getString(2),rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
