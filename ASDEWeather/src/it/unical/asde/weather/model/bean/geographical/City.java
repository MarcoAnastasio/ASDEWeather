package it.unical.asde.weather.model.bean.geographical;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class City implements Serializable{

	private static final long serialVersionUID = -5122728796174630673L;

	@Id
	@Column
	@GeneratedValue
	private Long id;
	
	@Column(nullable=false,unique=true)
	private String name;
	
	@Column
	private Double longitude;
	@Column
	private Double latitude;	

	@ManyToOne(fetch=FetchType.LAZY)
	private Country country;

	
	public City() {
		super();
	}

	public City(Long id, String name, Double longitude, Double latitude, Country country) {
		super();
		this.id = id;
		this.name = name;
		this.longitude = longitude;
		this.latitude = latitude;
		this.country = country;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", longitude=" + longitude + ", latitude=" + latitude
				+ ", country=" + country + "]";
	}
	
	
	
}
