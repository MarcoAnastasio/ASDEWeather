package it.unical.asde.weather.model.bean.weather;

import java.util.Date;

import org.json.simple.JSONObject;

import it.unical.asde.weather.model.bean.geographical.City;

public class WeatherData {
	
	protected Date dateTimeCalulation;	
	protected MainTemperature mainTemperature ;
	protected Weather weather;
	protected Float clouds;
	protected Wind wind;
	protected Float rain;
	protected Float snow;
	
	//to store this information on DB i think is necessary to add an ID, and a City reference
	
	protected City city;
	
	
	
	public WeatherData() {
		super();
	}

	
	
	public WeatherData(Date dateTimeCalulation, MainTemperature mainTemperature, Weather weather, Float clouds,
			Wind wind, Float rain, Float snow,City city) {
		super();
		this.dateTimeCalulation = dateTimeCalulation;
		this.mainTemperature = mainTemperature;
		this.weather = weather;
		this.clouds = clouds;
		this.wind = wind;
		this.rain = rain;
		this.snow = snow;
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



	@Override
	public String toString() {
		return "WeatherData [dateTimeCalulation=" + dateTimeCalulation + ", mainTemperature=" + mainTemperature
				+ ", weather=" + weather + ", clouds=" + clouds + ", wind=" + wind + ", rain=" + rain + ", snow=" + snow
				+ ", city=" + city + "]";
	}

	
	
}
