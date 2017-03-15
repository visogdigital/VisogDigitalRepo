package com.visog.util;

import java.io.Serializable;

public class Admin implements Serializable {
	private static final long serialVersionUID = 6297385302078200511L;
	
	private String email;
	private String pass;
	
	public Admin(String email,String pass){
		this.email = email;
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "Admin [email=" + email + ", pass=" + pass + "]";
	}
	
	

}
