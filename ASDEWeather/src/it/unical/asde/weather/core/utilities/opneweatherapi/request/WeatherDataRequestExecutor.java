package it.unical.asde.weather.core.utilities.opneweatherapi.request;

import java.util.List;

import it.unical.asde.weather.model.api.response.APICurrentResponse;
import it.unical.asde.weather.model.api.response.APIForecastResponse;
import it.unical.asde.weather.model.bean.geographical.City;
import it.unical.asde.weather.model.bean.weather.WeatherForecastData;

public interface WeatherDataRequestExecutor {

	
	public APIForecastResponse getWeatherForecastforCityFromAPI(City city);
	
//	public APICurrentWeatherResponse getCurrentWeatherforCityFromAPI(City city);
	public APICurrentResponse getCurrentWeatherforCityFromAPI(City city);
	
	public APICurrentResponse getCurrentWeatherforCityListFromAPI(List<City> cities);

	
}
