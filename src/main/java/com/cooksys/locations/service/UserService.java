package com.cooksys.locations.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.locations.entity.User;
import com.cooksys.locations.model.GetAllUsersResponse;
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

	private GetUserResponse gur;

	public List<GetAllUsersResponse> getAll() {
		return GetAllUsersResponse.listAll(repo.findAll());
	}

	public GetUserResponse getUser(String username) {
		return GetUserResponse.getUser(repo.findByUsername(username));
	}

	public Boolean verifyPassword(GetUserResponse gur) {
		GetUserResponse temp = getUser(gur.getUsername());
		if ((temp != null) && (temp.equals(gur))) {
			return true;
		} else {
			return false;
		}
	}

	public LoginResponse loginService(GetUserResponse user) {
		LoginResponse lr = new LoginResponse();
		if (repo.findByUsername(user.getUsername()) == null) {
			lr.setUsername("unregistered");
			return lr;
		} else {
			Boolean verify = verifyPassword(user);
			if (verify == false) {
				lr.setUsername("invalid");
				return lr;
			} else {
				lr.setUsername(user.getUsername());
				String test = repo.findByUsername(user.getUsername()).getRole().getRole();
				log.debug("{}", test);
				if (test.equals("admin")) {
					lr.setAdmin(true);
				}
				return lr;
			}
		}

	}

	public User addUser(User user) {
		if (locRepo.findByTitle(user.getTitle()) != null) {
			locsrv.addConversion(user.getLocation());
			repo.save(user);
			return user;
		} else {
			repo.save(user);
			return user;
		}

	}

}
