package it.unical.asde.weather.core.external.opneweatherapi.request;

import it.unical.asde.weather.model.bean.data.extra.UVData;
import it.unical.asde.weather.model.bean.geographical.City;
import it.unical.asde.weather.model.exception.ASDECustomException;
import it.unical.asde.weather.model.openweatherapi.response.APICurrentResponse;
import it.unical.asde.weather.model.openweatherapi.response.APIForecastResponse;

import java.util.List;

public interface DataRemoteRequestExecutor {

	
	public APIForecastResponse getForecastWeatherForCityFromAPI(City city) throws ASDECustomException;
	
	public APICurrentResponse getCurrentWeatherForCityFromAPI(City city) throws ASDECustomException;
	
	public APICurrentResponse getCurrentWeatherForCityListFromAPI(List<City> cities) throws ASDECustomException;

	public APICurrentResponse getCurrentWeatherForCoordsFromAPI(Double latitude,Double longitude) throws ASDECustomException;

	
	public Object getCurrentPollutionForCoordsFromAPI(Double latitude,Double longitude) throws ASDECustomException;

	public UVData getCurrentUVForCoordsFromAPI(Double latiude, Double longitude) throws ASDECustomException;
	
}
