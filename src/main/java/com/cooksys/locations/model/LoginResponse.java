package com.cooksys.locations.model;

import com.cooksys.locations.entity.User;

public class LoginResponse {
	
	private String username;
	private Boolean admin;
	public LoginResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginResponse(String username, Boolean admin) {
		this.username = username;
		this.admin = admin;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Boolean getAdmin() {
		return admin;
	}
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	
	public static LoginResponse response(User user){
		return new LoginResponse(user.getUsername(), false);
	}

}
