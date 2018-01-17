package it.unical.asde.weather.model.openweatherapi.response;

import java.util.ArrayList;
import java.util.List;

import it.unical.asde.weather.model.bean.data.weather.WeatherForecastData;
import it.unical.asde.weather.model.bean.geographical.City;
import it.unical.asde.weather.model.bean.geographical.Country;

public class APIForecastResponse {

	private Integer requestCode;
	private City city;	
	private Country country;
	private List<WeatherForecastData> listForecastWeather;

//coords are provide from the server but we just do not care...
//	private coordinate;
	
	public APIForecastResponse() {
		listForecastWeather=new ArrayList<>();
	}

	
	public APIForecastResponse(Integer requestCode, City city, Country country,
			List<WeatherForecastData> listForecastWeather) {
		super();
		this.requestCode = requestCode;
		this.city = city;
		this.country = country;
		this.listForecastWeather = listForecastWeather;
	}


	public Integer getRequestCode() {
		return requestCode;
	}

	public void setRequestCode(Integer requestCode) {
		this.requestCode = requestCode;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<WeatherForecastData> getListForecastWeather() {
		return listForecastWeather;
	}

	public void setListForecastWeather(List<WeatherForecastData> listForecastWeather) {
		this.listForecastWeather = listForecastWeather;
	}
	
	
	
	
	
	
}
