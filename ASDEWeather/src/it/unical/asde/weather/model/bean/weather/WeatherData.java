package it.unical.asde.weather.model.bean.weather;

import java.util.Date;

import org.json.simple.JSONObject;

public class WeatherData {
	
	protected Date dateTimeCalulation;	
	protected MainTemperature mainTemperature ;
	protected Weather weather;
	protected Float clouds;
	protected Wind wind;
	protected Float rain;
	protected Float snow;
	
	
	
	public WeatherData() {
		super();
	}

	
	
	public WeatherData(Date dateTimeCalulation, MainTemperature mainTemperature, Weather weather, Float clouds,
			Wind wind, Float rain, Float snow) {
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
	
	
	@Override
	public String toString() {
		return "WeatherForecast [dateTimeCalulation="+ dateTimeCalulation + ", mainTemperature=" 
				+ mainTemperature + ", weather=" + weather + ", clouds="
				+ clouds + ", wind=" + wind + ", rain=" + rain + ", snow=" + snow + "]";
	}
	
	
	
	
}
