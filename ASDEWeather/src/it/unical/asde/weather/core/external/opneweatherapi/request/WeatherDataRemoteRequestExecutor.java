package it.unical.asde.weather.core.external.opneweatherapi.request;

import java.util.List;

import it.unical.asde.weather.model.bean.geographical.City;
import it.unical.asde.weather.model.bean.weather.WeatherForecastData;
import it.unical.asde.weather.model.exception.ASDECustomException;
import it.unical.asde.weather.model.openweatherapi.response.APICurrentResponse;
import it.unical.asde.weather.model.openweatherapi.response.APIForecastResponse;

public interface WeatherDataRemoteRequestExecutor {

	
	public APIForecastResponse getForecastWeatherForCityFromAPI(City city) throws ASDECustomException;
	
	public APICurrentResponse getCurrentWeatherForCityFromAPI(City city) throws ASDECustomException;
	
	public APICurrentResponse getCurrentWeatherForCityListFromAPI(List<City> cities) throws ASDECustomException;

	public APICurrentResponse getCurrentWeatherForCoordsFromAPI(Double latitude,Double longitude) throws ASDECustomException;

	
}
