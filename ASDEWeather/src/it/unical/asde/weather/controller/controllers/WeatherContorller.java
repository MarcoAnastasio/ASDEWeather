package it.unical.asde.weather.controller.controllers;

import it.unical.asde.weather.model.bean.comunication.request.RequestListCities;
import it.unical.asde.weather.model.bean.comunication.request.RequestSingleCity;

public interface WeatherContorller {

	public Object getCurrentWeatherByCity(RequestSingleCity request);
	
	public Object getCurrentWeatherByCities(RequestListCities request);
	
	public Object getForecastWeatherByCity(RequestSingleCity request);
	
}
