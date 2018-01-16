package it.unical.asde.weather.model.bean.data.weather;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.json.simple.JSONObject;

import it.unical.asde.weather.model.bean.geographical.City;

@Entity
@Table
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class WeatherForecastData extends WeatherData{
	
	@Column
	private Date dateTimeOfForecast;
	
	public WeatherForecastData() {
		super();
	}
	
	
	public WeatherForecastData(Date dateTimeCalulation, MainTemperature mainTemperature, Weather weather, Float clouds,
			Wind wind, Float rain, Float snow,City city,Date storeTime,Date dateTimeOfForecast) {
		super(dateTimeCalulation, mainTemperature, weather, clouds, wind, rain, snow,city,storeTime);
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
