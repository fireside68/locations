package com.cooksys.locations.model;

import com.cooksys.locations.entity.Area;

public class GetAreaResponse {
	
	private Integer area;

	public GetAreaResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GetAreaResponse(Integer area) {
		this.area = area;
	}

	public Integer getArea() {
		return area;
	}

	public void setValue(Integer area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "GetAreaResponse [area=" + area + "]";
	}
	
	public static GetAreaResponse getArea(Area area){
		return new GetAreaResponse(area.getArea());
	}
}
