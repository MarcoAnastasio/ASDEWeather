package it.unical.asde.weather.model.bean.comunication.response;

import it.unical.asde.weather.model.bean.data.extra.UVData;
import it.unical.asde.weather.model.bean.data.weather.WeatherForecastData;
import it.unical.asde.weather.model.bean.geographical.City;

import java.util.List;

public class ForecastUVResponseDTO {

	
	private City city;	
	private List<WeatherForecastData> listForecastWeather;
	private UVData UVData;
	
	public ForecastUVResponseDTO() {
	}
	
	public ForecastUVResponseDTO(City city, List<WeatherForecastData> listForecastWeather,
			it.unical.asde.weather.model.bean.data.extra.UVData uVData) {
		super();
		this.city = city;
		this.listForecastWeather = listForecastWeather;
		UVData = uVData;
	}

	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public List<WeatherForecastData> getListForecastWeather() {
		return listForecastWeather;
	}
	public void setListForecastWeather(List<WeatherForecastData> listForecastWeather) {
		this.listForecastWeather = listForecastWeather;
	}
	public UVData getUVData() {
		return UVData;
	}
	public void setUVData(UVData uVData) {
		UVData = uVData;
	}
	
	
	
	
	
	
}
