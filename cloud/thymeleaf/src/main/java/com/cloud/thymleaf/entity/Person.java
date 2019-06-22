package com.cloud.thymleaf.entity;

public class Person {
	
	String name;
	String password;
	String date;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", password=" + password + ", date=" + date + "]";
	}


}
