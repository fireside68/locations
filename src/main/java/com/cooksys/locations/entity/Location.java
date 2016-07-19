package com.cooksys.locations.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="location")
public class Location {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="title", unique=true)
	private String title;
	
	@Column (name="hits")
	private Integer hits;
	
	@Column (name="conversions")
	private Integer conversions;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="location_area")
	private Area area;
	
	@OneToMany(mappedBy="location")
	@JsonIgnore
	private List<User> users;

	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Location(String title, Integer hits, Integer conversions) {
		this.title = title;
		this.hits = hits;
		this.conversions = conversions;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public Integer getHits() {
		return hits;
	}



	public void setHits(Integer hits) {
		this.hits = hits;
	}



	public Integer getConversions() {
		return conversions;
	}



	public void setConversions(Integer conversions) {
		this.conversions = conversions;
	}



	public Area getArea() {
		return area;
	}



	public void setArea(Area area) {
		this.area = area;
	}

	

	public List<User> getUsers() {
		return users;
	}



	public void setUsers(List<User> users) {
		this.users = users;
	}



	@Override
	public String toString() {
		return "Location [title=" + title + ", hits=" + hits + ", conversions=" + conversions + "]";
	}


	
	
	
	

}
