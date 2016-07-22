package com.cooksys.locations.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.locations.model.GetAllAreasResponse;
import com.cooksys.locations.model.GetAreaResponse;
import com.cooksys.locations.repository.AreaRepository;
import com.cooksys.locations.repository.LocationRepository;

@Service
public class AreaService {
	
	@Autowired
	AreaRepository repo;
	
	@Autowired
	LocationRepository locRepo;
	
	public List<GetAllAreasResponse> getAll(){
		return GetAllAreasResponse.listAll(repo.findAll());
	}
	
	public GetAreaResponse getArea(Integer area){
		return GetAreaResponse.getArea(repo.findByArea(area));
	}
	
	public Boolean isNumber(Integer area){
		Boolean flag = false;
		if(getArea(area) != null){
			flag = true;
		}
		return flag;
	}

}
