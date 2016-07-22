package com.cooksys.locations.entity;

import java.sql.Date;
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
	
	@Column(name="description")
	private String description;
	
	@Column(name="updated")
	private Date updated;

	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Location(Long id, String title, Integer hits, Integer conversions, Area area, List<User> users,
			String description, Date updated) {
		this.id = id;
		this.title = title;
		this.hits = hits;
		this.conversions = conversions;
		this.area = area;
		this.users = users;
		this.description = description;
		this.updated = updated;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", title=" + title + ", hits=" + hits + ", conversions=" + conversions + ", area="
				+ area + ", users=" + users + ", description=" + description + ", updated=" + updated + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + ((conversions == null) ? 0 : conversions.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((hits == null) ? 0 : hits.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((updated == null) ? 0 : updated.hashCode());
		result = prime * result + ((users == null) ? 0 : users.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (conversions == null) {
			if (other.conversions != null)
				return false;
		} else if (!conversions.equals(other.conversions))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (hits == null) {
			if (other.hits != null)
				return false;
		} else if (!hits.equals(other.hits))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (updated == null) {
			if (other.updated != null)
				return false;
		} else if (!updated.equals(other.updated))
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}
	
	
}
