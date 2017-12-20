package it.unical.asde.weather.core.services;

import it.unical.asde.weather.model.bean.comunication.request.RequestListCities;
import it.unical.asde.weather.model.bean.comunication.request.RequestSingleCity;

public interface WeatherDataProvider {

	public Object getCurrentWeatherByCity(RequestSingleCity request);
	
	public Object getCurrentWeatherByCities(RequestListCities request);
	
	public Object getForecastWeatherByCity(RequestSingleCity request);
	
}
