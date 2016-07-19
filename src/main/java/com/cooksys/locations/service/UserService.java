package com.cooksys.locations.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.locations.entity.Location;
import com.cooksys.locations.entity.User;
import com.cooksys.locations.model.GetAllUsersResponse;
import com.cooksys.locations.model.GetUserResponse;
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
	
	private GetUserResponse gur;	

	public List<GetAllUsersResponse> getAll() {
		return GetAllUsersResponse.listAll(repo.findAll());
	}

	public GetUserResponse getUser(String username) {
		return GetUserResponse.getUser(repo.findByUsername(username));
	}

	public Boolean verifyPassword(GetUserResponse gur) {
		GetUserResponse temp = getUser(gur.getUsername());
		if (temp.equals(gur)) {
			return true;
		} else {
			return false;
		}
	}

	public Boolean loginService(User user) {
		Location location = new Location();
		gur = getUser(user.getUsername());
		Boolean verify = verifyPassword(gur);
		if (locRepo.findByTitle(user.getTitle()) != null) {
			location = locRepo.findByTitle(user.getTitle());
			locsrv.incrementHits(location);
			if (verify == true) {
				locsrv.decrementHits(location);
				return true;
			} else {
				return false;
			}
		} else if (verify == true) {
			location = locRepo.findByTitle(user.getTitle());
			locsrv.decrementHits(location);
			return true;
		} else
			return false;
	}
	
	public User addUser(User user){
		if (locRepo.findByTitle(user.getTitle()) != null){
			locsrv.addConversion(user.getLocation());
			repo.save(user);
			return user;
		}else {
			repo.save(user);
			return user;
		}
			
	}
	
	

}
