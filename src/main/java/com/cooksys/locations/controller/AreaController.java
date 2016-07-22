package com.cooksys.locations.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.locations.model.GetAllAreasResponse;
import com.cooksys.locations.model.GetAreaResponse;
import com.cooksys.locations.service.AreaService;

@RestController
@RequestMapping("area")
public class AreaController {
	
	@Autowired
	private AreaService areasrv;
	
	@RequestMapping("/allAreas")
	public @ResponseBody List<GetAllAreasResponse> allAreas(){
		return areasrv.getAll();
	}
	
	@RequestMapping("/{title}")
	public @ResponseBody GetAreaResponse getArea(@PathVariable String title){
		return null;
	}

}
