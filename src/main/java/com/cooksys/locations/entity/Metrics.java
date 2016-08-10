package com.cooksys.locations.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="metrics")
public class Metrics {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="anon_hits")
	private Long anonHits;
	
	@Column(name="conversions")
	private Long conversions;
	
	@Column(name="signups")
	private Long signups;
	
	@Column(name="total_hits")
	private Long totalHits;
	
	@Column(name="date_updated")
	private Date dateUpdated;
	
	@ManyToOne(targetEntity = Area.class)
	@JoinColumn(name="area_id")
	private Area area;

	public Metrics() {
		super();
	}

	public Metrics(Long id, Long anonHits, Long conversions, Long signups, Long totalHits, Date dateUpdated,
			Area area) {
		super();
		this.id = id;
		this.anonHits = anonHits;
		this.conversions = conversions;
		this.signups = signups;
		this.totalHits = totalHits;
		this.dateUpdated = dateUpdated;
		this.area = area;
	}

	public Metrics(Long anonHits, Long conversions, Long signups, Long totalHits, Date dateUpdated, Area area) {
		super();
		this.anonHits = anonHits;
		this.conversions = conversions;
		this.signups = signups;
		this.totalHits = totalHits;
		this.dateUpdated = dateUpdated;
		this.area = area;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAnonHits() {
		return anonHits;
	}

	public void setAnonHits(Long anonHits) {
		this.anonHits = anonHits;
	}

	public Long getConversions() {
		return conversions;
	}

	public void setConversions(Long conversions) {
		this.conversions = conversions;
	}

	public Long getSignups() {
		return signups;
	}

	public void setSignups(Long signups) {
		this.signups = signups;
	}

	public Long getTotalHits() {
		return totalHits;
	}

	public void setTotalHits(Long totalHits) {
		this.totalHits = totalHits;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anonHits == null) ? 0 : anonHits.hashCode());
		result = prime * result + ((conversions == null) ? 0 : conversions.hashCode());
		result = prime * result + ((dateUpdated == null) ? 0 : dateUpdated.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((signups == null) ? 0 : signups.hashCode());
		result = prime * result + ((totalHits == null) ? 0 : totalHits.hashCode());
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
		Metrics other = (Metrics) obj;
		if (anonHits == null) {
			if (other.anonHits != null)
				return false;
		} else if (!anonHits.equals(other.anonHits))
			return false;
		if (conversions == null) {
			if (other.conversions != null)
				return false;
		} else if (!conversions.equals(other.conversions))
			return false;
		if (dateUpdated == null) {
			if (other.dateUpdated != null)
				return false;
		} else if (!dateUpdated.equals(other.dateUpdated))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (signups == null) {
			if (other.signups != null)
				return false;
		} else if (!signups.equals(other.signups))
			return false;
		if (totalHits == null) {
			if (other.totalHits != null)
				return false;
		} else if (!totalHits.equals(other.totalHits))
			return false;
		return true;
	}
	
	

}
