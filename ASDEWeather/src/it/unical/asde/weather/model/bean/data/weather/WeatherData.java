package it.unical.asde.weather.model.bean.data.weather;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.InheritanceType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.json.simple.JSONObject;

import it.unical.asde.weather.model.bean.geographical.City;

@Entity
@Table
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class WeatherData {
	
	@Id
	@GeneratedValue
	@Column
	protected Long id;
	@Column
	protected Date dateTimeCalulation;	
	@Embedded
	protected MainTemperature mainTemperature ;
	@ManyToOne(fetch=FetchType.EAGER)
	protected Weather weather;
	@Column
	protected Float clouds;
	@Embedded
	protected Wind wind;
	@Column
	protected Float rain;
	@Column
	protected Float snow;
	
	@Column
	protected Date storeTime;

	@ManyToOne
	protected City city;
	
	
	
	public WeatherData() {
		super();
	}

	
	
	public WeatherData(Date dateTimeCalulation, MainTemperature mainTemperature, Weather weather, Float clouds,
			Wind wind, Float rain, Float snow,City city,Date storeTime) {
		super();
		this.dateTimeCalulation = dateTimeCalulation;
		this.mainTemperature = mainTemperature;
		this.weather = weather;
		this.clouds = clouds;
		this.wind = wind;
		this.rain = rain;
		this.snow = snow;
		this.city=city;
		this.storeTime=storeTime;
	}



	public Date getDateTimeCalulation() {
		return dateTimeCalulation;
	}
	public void setDateTimeCalulation(Date dateTimeCalulation) {
		this.dateTimeCalulation = dateTimeCalulation;
	}
	public MainTemperature getMainTemperature() {
		return mainTemperature;
	}
	public void setMainTemperature(MainTemperature mainTemperature) {
		this.mainTemperature = mainTemperature;
	}
	public Weather getWeather() {
		return weather;
	}
	public void setWeather(Weather weather) {
		this.weather = weather;
	}
	public Float getClouds() {
		return clouds;
	}
	public void setClouds(Float clouds) {
		this.clouds = clouds;
	}
	public Wind getWind() {
		return wind;
	}
	public void setWind(Wind wind) {
		this.wind = wind;
	}
	public Float getRain() {
		return rain;
	}
	public void setRain(Float rain) {
		this.rain = rain;
	}
	public Float getSnow() {
		return snow;
	}
	public void setSnow(Float snow) {
		this.snow = snow;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getStoreTime() {
		return storeTime;
	}



	public void setStoreTime(Date storeTime) {
		this.storeTime = storeTime;
	}



	@Override
	public String toString() {
		return "WeatherData [id=" + id + ", dateTimeCalulation="
				+ dateTimeCalulation + ", mainTemperature=" + mainTemperature
				+ ", weather=" + weather + ", clouds=" + clouds + ", wind="
				+ wind + ", rain=" + rain + ", snow=" + snow + ", storeTime="
				+ storeTime + ", city=" + city + "]";
	}





	
	
}
