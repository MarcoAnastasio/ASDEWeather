package it.unical.asde.weather.model.bean.data.extra;

import it.unical.asde.weather.model.bean.data.weather.MainTemperature;
import it.unical.asde.weather.model.bean.data.weather.Weather;
import it.unical.asde.weather.model.bean.data.weather.Wind;
import it.unical.asde.weather.model.bean.geographical.City;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class UVData {

	//{"lat":39.30999,"lon":16.250191,"date_iso":"2018-01-11T12:00:00Z","date":1515672000,"value":1.52}
	
	@Id
	@GeneratedValue
	@Column
	private Long id;
	
	@Column
	private Date dateCalulation;	
	
	@Column
	private Float value;
	
	@Column
	private Date storeTime;

	@ManyToOne
	private City city;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateCalulation() {
		return dateCalulation;
	}

	public void setDateCalulation(Date dateTimeCalulation) {
		this.dateCalulation = dateTimeCalulation;
	}

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

	public Date getStoreTime() {
		return storeTime;
	}

	public void setStoreTime(Date storeTime) {
		this.storeTime = storeTime;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	
	
	
}
