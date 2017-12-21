package it.unical.asde.weather.core.services;

import it.unical.asde.weather.model.bean.comunication.request.RequestListCities;
import it.unical.asde.weather.model.bean.comunication.request.RequestSingleCity;
import it.unical.asde.weather.model.exception.ASDECustomException;

public interface WeatherDataProvider {

	public Object getCurrentWeatherByCity(RequestSingleCity request) throws ASDECustomException;
	
	public Object getCurrentWeatherByCities(RequestListCities request) throws ASDECustomException;
	
	public Object getForecastWeatherByCity(RequestSingleCity request) throws ASDECustomException;
	
}
