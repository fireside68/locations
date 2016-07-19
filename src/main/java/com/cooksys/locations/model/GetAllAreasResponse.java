package com.cooksys.locations.model;

import java.util.ArrayList;
import java.util.List;

import com.cooksys.locations.entity.Area;

public class GetAllAreasResponse {
	
	private Integer area;

	public GetAllAreasResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

	public GetAllAreasResponse(Integer area) {
		this.area = area;
	}

	public static List<GetAllAreasResponse> listAll(List<Area> list){
		ArrayList<GetAllAreasResponse> temp = new ArrayList<>();
		for(Area area : list){
			temp.add(new GetAllAreasResponse(area.getArea()));
		}
		return temp;
	}
}
