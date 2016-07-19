package com.cooksys.locations.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.locations.entity.Area;

public interface AreaRepository extends JpaRepository<Area, Long> {
	
	public Area findByArea(Integer area);
	
	
	

}
