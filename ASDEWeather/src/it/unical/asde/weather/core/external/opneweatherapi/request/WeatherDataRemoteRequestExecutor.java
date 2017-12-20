package it.unical.asde.weather.core.external.opneweatherapi.request;

import java.util.List;

import it.unical.asde.weather.model.api.response.APICurrentResponse;
import it.unical.asde.weather.model.api.response.APIForecastResponse;
import it.unical.asde.weather.model.bean.geographical.City;
import it.unical.asde.weather.model.bean.weather.WeatherForecastData;

public interface WeatherDataRemoteRequestExecutor {

	
	public APIForecastResponse getForecastWeatherForCityFromAPI(City city);
	
//	public APICurrentWeatherResponse getCurrentWeatherforCityFromAPI(City city);
	public APICurrentResponse getCurrentWeatherForCityFromAPI(City city);
	
	public APICurrentResponse getCurrentWeatherForCityListFromAPI(List<City> cities);

	
}
