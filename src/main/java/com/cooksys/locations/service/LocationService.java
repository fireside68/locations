package com.cooksys.locations.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.locations.entity.Area;
import com.cooksys.locations.entity.Location;
import com.cooksys.locations.model.GetUrlDetailsModel;
import com.cooksys.locations.repository.LocationRepository;

@Service
public class LocationService {

	private Logger log = LoggerFactory.getLogger(LocationService.class);

	@Autowired
	LocationRepository repo;

	public Location findByTitle(String title) {
		if (title == null) {
			return null;
		}
		return repo.findByTitle(title);
	}

	public Location findByArea(Area area){
		return repo.findByArea(area);
	}
	public List<Location> findAll() {
		return repo.findAll();
	}
	
//	public void incrementHits(Location location){
//		if(location == null){
//			return;
//		}
//		location.setHits(location.getHits() + 1);
//		location.setUpdated(new Date());
//		repo.save(location);
//	}
//	
//	public double conversionRate(String title){
//		Location location = repo.findByTitle(title);
//		return location.getConversions() / location.getHits();
//	}
//
//	public void decrementHits(Location location) {
//		if(location==null){
//			return;
//		}
//		location.setHits(location.getHits() - 1);
//		location.setUpdated(new Date());
//		repo.save(location);
//		
//	}

//	public void addConversion(Location location) {
//		location.setConversions(location.getConversions() + 1);
//		location.setHits(location.getHits() + 1);
//		location.setDateUpdated(new Date());
//		repo.save(location);		
//	}

	public Location addLocation(Location location) {
		location.setDateCreated(new Date());
		location.setDateUpdated(new Date());
		repo.save(location);
		return location;
	}
	
	public Location updateLocation(Location location) {
		location.setId(repo.findByTitle(location.getTitle()).getId());
		location.setDateUpdated(new Date());
		repo.save(location);
		return location;
	}
	
	public GetUrlDetailsModel getUrlModel(String title){
		return GetUrlDetailsModel.createModel(repo.findByTitle(title));
	}
	
	public List<GetUrlDetailsModel> getUrlModels(){
		List<Location> temp = repo.findAll();
		return GetUrlDetailsModel.listAllUrls(temp);
	}
}
