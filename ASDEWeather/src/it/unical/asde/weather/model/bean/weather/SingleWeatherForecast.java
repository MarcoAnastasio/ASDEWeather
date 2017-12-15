package it.unical.asde.weather.model.bean.weather;

import java.util.Date;

import org.json.simple.JSONObject;

public class SingleWeatherForecast {
	
	private Date dateTimeOfForecast;
	private Date dateTimeCalulation;	
	private MainTemperature mainTemperature ;
	private Weather weather;
	private Float clouds;
	private Wind wind;
	private Float rain;
	private Float snow;
	
	
	
	public SingleWeatherForecast() {
		super();
	}
	public Date getDateTimeOfForecast() {
		return dateTimeOfForecast;
	}
	public void setDateTimeOfForecast(Date dateTimeOfForecast) {
		this.dateTimeOfForecast = dateTimeOfForecast;
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
		return "WeatherForecast [dateTimeOfForecast=" + dateTimeOfForecast + ", dateTimeCalulation="
				+ dateTimeCalulation + ", mainTemperature=" + mainTemperature + ", weather=" + weather + ", clouds="
				+ clouds + ", wind=" + wind + ", rain=" + rain + ", snow=" + snow + "]";
	}
	
	
	
	
}
