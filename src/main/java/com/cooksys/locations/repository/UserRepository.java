package com.cooksys.locations.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.locations.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByUsername(String username);
	
	public List<User> findAll();
	
	public User findByArea(Integer area);
}
