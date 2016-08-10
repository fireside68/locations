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
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
	
	@Column(name="date_created")
	private Date dateCreated;
	
	@Column(name="date_updated")
	private Date dateUpdated;

	public Location() {
		super();
	}

	public Location(Long id, String title, Integer hits, Integer conversions, Area area, String description,
			Date dateCreated, Date dateUpdated) {
		super();
		this.id = id;
		this.title = title;
		this.hits = hits;
		this.conversions = conversions;
		this.area = area;
		this.description = description;
		this.dateCreated = dateCreated;
		this.dateUpdated = dateUpdated;
	}

	public Location(String title, Integer hits, Integer conversions, Area area, String description, Date dateCreated,
			Date dateUpdated) {
		super();
		this.title = title;
		this.hits = hits;
		this.conversions = conversions;
		this.area = area;
		this.description = description;
		this.dateCreated = dateCreated;
		this.dateUpdated = dateUpdated;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + ((conversions == null) ? 0 : conversions.hashCode());
		result = prime * result + ((dateCreated == null) ? 0 : dateCreated.hashCode());
		result = prime * result + ((dateUpdated == null) ? 0 : dateUpdated.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((hits == null) ? 0 : hits.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		if (dateCreated == null) {
			if (other.dateCreated != null)
				return false;
		} else if (!dateCreated.equals(other.dateCreated))
			return false;
		if (dateUpdated == null) {
			if (other.dateUpdated != null)
				return false;
		} else if (!dateUpdated.equals(other.dateUpdated))
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
		return true;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", title=" + title + ", hits=" + hits + ", conversions=" + conversions + ", area="
				+ area + ", description=" + description + ", dateCreated=" + dateCreated + ", dateUpdated="
				+ dateUpdated + "]";
	}
	
	
	
}
