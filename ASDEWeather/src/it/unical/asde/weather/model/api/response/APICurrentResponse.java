package it.unical.asde.weather.model.api.response;

import java.util.ArrayList;
import java.util.List;

import it.unical.asde.weather.model.bean.geographical.City;
import it.unical.asde.weather.model.bean.geographical.Country;
import it.unical.asde.weather.model.bean.weather.WeatherData;
import it.unical.asde.weather.model.bean.weather.WeatherForecastData;

public class APICurrentResponse {

	private Integer requestCode;
	private List<WeatherData> listForecastWeather;

//coords are provide from the server but we just do not care...
//	private coordinate;
	
	public APICurrentResponse() {
		listForecastWeather=new ArrayList<>();
	}

	
	public APICurrentResponse(Integer requestCode,
			List<WeatherData> listForecastWeather) {
		super();
		this.requestCode = requestCode;
		this.listForecastWeather = listForecastWeather;
	}


	public Integer getRequestCode() {
		return requestCode;
	}

	public void setRequestCode(Integer requestCode) {
		this.requestCode = requestCode;
	}


	public List<WeatherData> getListForecastWeather() {
		return listForecastWeather;
	}


	public void setListForecastWeather(List<WeatherData> listForecastWeather) {
		this.listForecastWeather = listForecastWeather;
	}
	
	
	
}
