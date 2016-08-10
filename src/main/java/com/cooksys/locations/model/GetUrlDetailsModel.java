package com.cooksys.locations.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.cooksys.locations.entity.Area;
import com.cooksys.locations.entity.Location;

public class GetUrlDetailsModel {
	
	private Integer area;
	private String title;
	private String description;
	private Date dateCreated;
	private Date dateUpdated;
	
	
	
	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public GetUrlDetailsModel(Integer area, String title, String description, Date dateCreated, Date dateUpdated) {
		this.area = area;
		this.title = title;
		this.description = description;
		this.dateCreated = dateCreated;
		this.dateUpdated = dateUpdated;
	}

	public GetUrlDetailsModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	@Override
	public String toString() {
		return "GetUrlDetailsModel [area=" + area + ", title=" + title + ", description=" + description
				+ ", dateCreated=" + dateCreated + ", dateUpdated=" + dateUpdated + "]";
	}

	public static GetUrlDetailsModel createModel(Location location){
		Area space = location.getArea();
		return new GetUrlDetailsModel(space.getArea(), location.getTitle(), location.getDescription(), location.getDateCreated(), location.getDateUpdated());
		
	}
	
	public static List<GetUrlDetailsModel> listAllUrls(List<Location> list){
		ArrayList<GetUrlDetailsModel> temp = new ArrayList<GetUrlDetailsModel>();
		for(Location location : list){
			temp.add(new GetUrlDetailsModel(location.getArea().getArea(), location.getTitle(), location.getDescription(), location.getDateCreated(), location.getDateUpdated()));
		}
		return temp;
	}

}
