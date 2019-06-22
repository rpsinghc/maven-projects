package com.rpsingh.test;

import org.springframework.stereotype.Component;

@Component
public class Login {

	
	String email;
	String password;
	Boolean checkme;
	
	
	public Boolean getCheckme() {
		return checkme;
	}
	public void setCheckme(Boolean checkme) {
		this.checkme = checkme;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Override
	public String toString() {
		return "Login [email=" + email + ", password=" + password + "]";
	}
	
	
}
