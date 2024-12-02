package com.demo.beans;

public class Address {
	private int addrid;
	private String state;
	private String City;
	private String Pin;
	
	public Address() {
		super();
	}

	public Address(int addrid, String state, String city, String pin) {
		super();
		this.addrid = addrid;
		this.state = state;
		City = city;
		Pin = pin;
	}

	public int getAddrid() {
		return addrid;
	}

	public void setAddrid(int addrid) {
		this.addrid = addrid;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getPin() {
		return Pin;
	}

	public void setPin(String pin) {
		Pin = pin;
	}

	@Override
	public String toString() {
		return "Address [addrid=" + addrid + ", state=" + state + ", City=" + City + ", Pin=" + Pin + "]";
	}
	
	

}
