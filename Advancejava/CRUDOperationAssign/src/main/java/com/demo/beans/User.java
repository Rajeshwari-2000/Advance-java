package com.demo.beans;

public class User {
	private int Uid;
	private String Uname;
	private String Role;
	
	public User() {
		super();
	}

	public User(int uid, String uname, String role) {
		super();
		Uid = uid;
		Uname = uname;
		Role = role;
	}

	public int getUid() {
		return Uid;
	}

	public void setUid(int uid) {
		Uid = uid;
	}

	public String getUname() {
		return Uname;
	}

	public void setUname(String uname) {
		Uname = uname;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	@Override
	public String toString() {
		return "User [Uid=" + Uid + ", Uname=" + Uname + ", Role=" + Role + "]";
	}
	
	

}
