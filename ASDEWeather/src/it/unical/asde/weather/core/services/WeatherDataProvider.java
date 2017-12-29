package it.unical.asde.weather.core.services;

import java.util.List;

import it.unical.asde.weather.model.bean.comunication.request.RequestListCities;
import it.unical.asde.weather.model.bean.comunication.request.RequestSingleCity;
import it.unical.asde.weather.model.bean.geographical.City;
import it.unical.asde.weather.model.exception.ASDECustomException;
import it.unical.asde.weather.model.openweatherapi.response.APICurrentResponse;

public interface WeatherDataProvider {

	public Object getCurrentWeatherByCity(RequestSingleCity request) throws ASDECustomException;
	
	public Object getCurrentWeatherByCities(RequestListCities request) throws ASDECustomException;
	
	public Object getForecastWeatherByCity(RequestSingleCity request) throws ASDECustomException;

	public APICurrentResponse getCurrentWeatherByCities(List<City> cities) throws ASDECustomException;
	
}
