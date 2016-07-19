package com.cooksys.locations.model;

import java.util.ArrayList;
import java.util.List;

import com.cooksys.locations.entity.Area;
import com.cooksys.locations.entity.Location;

public class LocationResponse {
	
	private String title;
	private Area area;
	public LocationResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LocationResponse(String title, Area area) {
		this.title = title;
		this.area = area;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	
	public static LocationResponse getLocation(Location location){
		return new LocationResponse(location.getTitle(), location.getArea());
	}
	
	public static List<LocationResponse> getLocations(List<Location> list){
		ArrayList<LocationResponse> temp = new ArrayList<>();
		for(Location loc : list){
			temp.add(new LocationResponse(loc.getTitle(), loc.getArea()));
		}
		return temp;
	}

}
