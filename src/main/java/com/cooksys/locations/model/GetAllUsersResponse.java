package com.cooksys.locations.model;

import java.util.ArrayList;
import java.util.List;

import com.cooksys.locations.entity.User;
import com.cooksys.locations.entity.UserRole;

public class GetAllUsersResponse {
	
	private String username;
	private String password;
	private Integer area;
	private String role;
	
	public GetAllUsersResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GetAllUsersResponse(String username, String password, Integer area, String role) {
		this.username = username;
		this.password = password;
		this.role = role;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

	public Integer getArea() {
		return area;
	}
	public void setArea(Integer area) {
		this.area = area;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public static List<GetAllUsersResponse> listAll(List<User> list){
		ArrayList<GetAllUsersResponse> temp = new ArrayList<>();
		for(User user : list){
			temp.add(new GetAllUsersResponse(user.getUsername(), user.getPassword(), user.getArea(), user.getRole().getRole()));
		}
		return temp;
	}

}
