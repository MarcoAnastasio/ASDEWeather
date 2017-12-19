package it.unical.asde.weather.model.bean.weather;

import java.util.Date;

import org.json.simple.JSONObject;

public class WeatherForecastData extends WeatherData{
	
	private Date dateTimeOfForecast;
	
	public WeatherForecastData() {
		super();
	}
	
	
	public WeatherForecastData(Date dateTimeCalulation, MainTemperature mainTemperature, Weather weather, Float clouds,
			Wind wind, Float rain, Float snow,Date dateTimeOfForecast) {
		super(dateTimeCalulation, mainTemperature, weather, clouds, wind, rain, snow);
		this.dateTimeOfForecast=dateTimeOfForecast;
	}


	public Date getDateTimeOfForecast() {
		return dateTimeOfForecast;
	}
	public void setDateTimeOfForecast(Date dateTimeOfForecast) {
		this.dateTimeOfForecast = dateTimeOfForecast;
	}

	
	
	@Override
	public String toString() {
		return "WeatherForecast [dateTimeOfForecast=" + dateTimeOfForecast + ", dateTimeCalulation="
				+ dateTimeCalulation + ", mainTemperature=" + mainTemperature + ", weather=" + weather + ", clouds="
				+ clouds + ", wind=" + wind + ", rain=" + rain + ", snow=" + snow + "]";
	}
	
	
	
	
}
