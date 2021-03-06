package it.unical.asde.weather.model.openweatherapi.response;

import it.unical.asde.weather.model.bean.data.weather.WeatherData;

import java.util.ArrayList;
import java.util.List;

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
