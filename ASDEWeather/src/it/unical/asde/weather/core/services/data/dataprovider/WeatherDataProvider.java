package it.unical.asde.weather.core.services.data.dataprovider;

import it.unical.asde.weather.model.bean.comunication.request.RequestGeolocation;
import it.unical.asde.weather.model.bean.comunication.request.RequestListCities;
import it.unical.asde.weather.model.bean.comunication.request.RequestSingleCity;
import it.unical.asde.weather.model.bean.comunication.response.ForecastUVResponseDTO;
import it.unical.asde.weather.model.bean.geographical.City;
import it.unical.asde.weather.model.exception.ASDECustomException;
import it.unical.asde.weather.model.openweatherapi.response.APICurrentResponse;
import it.unical.asde.weather.model.openweatherapi.response.APIForecastResponse;

import java.util.List;

public interface WeatherDataProvider {

	public APICurrentResponse getCurrentWeatherByCity(RequestSingleCity request) throws ASDECustomException;
	
	public APICurrentResponse getCurrentWeatherByCities(RequestListCities request) throws ASDECustomException;
	
	public APIForecastResponse getForecastWeatherByCity(RequestSingleCity request) throws ASDECustomException;

	public APICurrentResponse getCurrentWeatherByCities(List<City> cities) throws ASDECustomException;

	public APICurrentResponse getCurrentWeatherByCoords(Double latitude, Double longitude) throws ASDECustomException;

	public APICurrentResponse getCurrentWeatherByCoords(RequestGeolocation request) throws ASDECustomException;

	public ForecastUVResponseDTO getForecastWeatherAndUvByCity(RequestSingleCity request) throws Exception;
		
}
