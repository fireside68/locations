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

import com.cooksys.locations.entity.Area;
import com.cooksys.locations.entity.Location;
import com.cooksys.locations.service.LocationService;

@RestController
@RequestMapping("location")
public class LocationsController {

	@Autowired
	private LocationService locsrv;

	private Logger log = LoggerFactory.getLogger(LocationsController.class);

	@RequestMapping("allLocations")
	public @ResponseBody List<Location> showAllLocations() {
		return locsrv.findAll();
	}

	@RequestMapping(value = "/findByArea")
	public @ResponseBody Location findByValue(@RequestBody Area area) {
		return locsrv.findByArea(area);
	}

	
	@RequestMapping("/conversionRate/{title}")
	public @ResponseBody Double conversionRate(@PathVariable String title){
		return locsrv.conversionRate(title);
	}
	
	@RequestMapping("/addHits")
	public @ResponseBody Location addHits(@RequestBody Location location){
		locsrv.incrementHits(location);
		return location;
	}
	
	@RequestMapping("/decrementHits")
	public @ResponseBody Location decrementHits(@RequestBody Location location){
		locsrv.decrementHits(location);
		return location;
	}
	
	@RequestMapping(value = "/addLocation", method = RequestMethod.POST)
	public @ResponseBody Location addLocation(@RequestBody Location location){
		return locsrv.addLocation(location);
	}
}
