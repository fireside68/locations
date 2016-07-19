
package com.cooksys.locations.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.locations.entity.Area;
import com.cooksys.locations.entity.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {
	
	public Location findByTitle(String title);
	
	public Location findByArea(Area area);
	
	public List<Location> findAll();
	
}
