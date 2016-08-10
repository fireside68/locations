package com.cooksys.locations.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.locations.entity.User;
import com.cooksys.locations.model.GetUserResponse;
import com.cooksys.locations.model.LoginResponse;
import com.cooksys.locations.repository.LocationRepository;
import com.cooksys.locations.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repo;

	@Autowired
	LocationRepository locRepo;
	@Autowired
	LocationService locsrv;

	private Logger log = LoggerFactory.getLogger(UserService.class);

//	public List<GetAllUsersResponse> getAll() {
//		return GetAllUsersResponse.listAll(repo.findAll());
//	}
	
	public List<User> getAll() {
		return repo.findAll();
	}

	
	public User getUserByUsername(String username){
		return repo.findByUsername(username);
	}

	public Boolean verifyPassword(User user) {
		User temp = getUserByUsername(user.getUsername());
		if ((temp != null) && (temp.equals(user))) {
			return true;
		} else {
			return false;
		}
	}

	public Object loginService(User user) {
		if (repo.findByUsername(user.getUsername()) == null) {
			return "unregistered";
		} else {
			Boolean verify = verifyPassword(user);
			if (verify == false) {
				return "invalid";
			} else {
				return user;
			}
		}

	}

	public User addUser(User user) {
		User temp = new User();
		if (user.getLocation() != null) {
			//locsrv.addConversion(user.getLocation());
			temp.setUsername(user.getUsername());
			temp.setPassword(user.getPassword());
			temp.setDateCreated(new Date());
			temp.setDateUpdated(new Date());
			repo.save(temp);
			return temp;
		} else {
			temp.setUsername(user.getUsername());
			temp.setPassword(user.getPassword());
			temp.setDateCreated(new Date());
			temp.setDateUpdated(new Date());
			repo.save(temp);
			return temp;
		}

	}

}
