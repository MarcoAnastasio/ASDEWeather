package it.unical.asde.weather.model.bean.comunication.response;

import it.unical.asde.weather.model.bean.geographical.City;
import it.unical.asde.weather.model.bean.weather.WeatherData;

import java.util.List;

public class IndexResponseDTO {

	private List<WeatherData> randomCitiesWeather; 
	
	private WeatherData currentLocationWeather;

	
	
	public List<WeatherData> getRandomCitiesWeather() {
		return randomCitiesWeather;
	}

	public void setRandomCitiesWeather(List<WeatherData> randomCitiesWeather) {
		this.randomCitiesWeather = randomCitiesWeather;
	}

	public WeatherData getCurrentLocationWeather() {
		return currentLocationWeather;
	}

	public void setCurrentLocationWeather(WeatherData currentLocationWeather) {
		this.currentLocationWeather = currentLocationWeather;
	}
	
	
	
	
}
