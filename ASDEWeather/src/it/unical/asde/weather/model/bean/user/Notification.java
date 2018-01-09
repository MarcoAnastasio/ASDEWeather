package it.unical.asde.weather.model.bean.user;

import java.util.Date;

import it.unical.asde.weather.model.bean.geographical.City;
import it.unical.asde.weather.model.bean.weather.Weather;


//
public class Notification {

	
	private City city;
	
	private Weather weather;
	
	private Date date;
	
	
	public Notification() {
		super();
	}
	
	public Notification(City city, Weather weather, Date date) {
		super();
		this.city = city;
		this.weather = weather;
		this.date = date;
	}



	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Weather getWeather() {
		return weather;
	}

	public void setWeather(Weather weather) {
		this.weather = weather;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	
}
