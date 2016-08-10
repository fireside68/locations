package com.cooksys.locations.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.locations.entity.User;
import com.cooksys.locations.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService usrsrv;
	
	private Logger log = LoggerFactory.getLogger(LocationsController.class);

	
//	@RequestMapping("allUsers")
//	public @ResponseBody List<GetAllUsersResponse> showAllUsers() {
//		return usrsrv.getAll();
//	}
	
	@RequestMapping("allUsers")
	public @ResponseBody List<User> getAllUsers() {
		return usrsrv.getAll();
	}
	
	@RequestMapping("findUser/{username}")
	public User findByUsername(@PathVariable String username) {
		return usrsrv.getUserByUsername(username);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Object loginUser(@RequestBody User user) {
		return usrsrv.loginService(user);
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public @ResponseBody User addNewUser(@RequestBody User user) {
		return usrsrv.addUser(user);
	}
}
