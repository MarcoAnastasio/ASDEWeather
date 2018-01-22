package it.unical.asde.weather.controller.controllers;

import it.unical.asde.weather.model.bean.comunication.request.RequestGeolocation;
import it.unical.asde.weather.model.bean.comunication.request.RequestListCities;
import it.unical.asde.weather.model.bean.comunication.request.RequestSingleCity;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;

public interface WeatherContorller {

	public Object getCurrentWeatherByCity(RequestSingleCity request,HttpServletRequest httpRequest);
	
	public Object getCurrentWeatherByCities(RequestListCities request);
	
	public Object getForecastWeatherByCity(RequestSingleCity request);

	public Object getCurrentWeatherByCoords(RequestGeolocation request);

	public Object getForecastWeatherAndUVByCity(@RequestBody RequestSingleCity request);
	
}
