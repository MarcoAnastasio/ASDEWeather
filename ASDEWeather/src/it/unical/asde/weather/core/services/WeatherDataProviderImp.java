package it.unical.asde.weather.core.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.unical.asde.weather.core.external.opneweatherapi.request.WeatherDataRemoteRequestExecutor;
import it.unical.asde.weather.model.api.response.APICurrentResponse;
import it.unical.asde.weather.model.api.response.APIForecastResponse;
import it.unical.asde.weather.model.bean.comunication.request.RequestListCities;
import it.unical.asde.weather.model.bean.comunication.request.RequestSingleCity;
import it.unical.asde.weather.model.bean.geographical.City;

@Service
public class WeatherDataProviderImp implements WeatherDataProvider{

	@Autowired
	private WeatherDataRemoteRequestExecutor weatherDataRemoteRequestExecutor;
	
	@Override
	public Object getCurrentWeatherByCity(RequestSingleCity request) {
		if(request==null || (request.getCityId()==null && request.getCityName()==null)){
			return null;
		}
		//TODO check if the request for the current weather is present into DB and is not to old
		
		//suppose is not present so call the services
		APICurrentResponse currentWeatherforCityFromAPI = weatherDataRemoteRequestExecutor.getCurrentWeatherForCityFromAPI(new City(request.getCityId(), request.getCityName(), null, null, null));
		
		//TODO store this data in the DB (maybe we can think to use another thread)

		return currentWeatherforCityFromAPI;
	}

	@Override
	public Object getCurrentWeatherByCities(RequestListCities request) {
		if(request==null || request.getCities()==null || request.getCities().isEmpty()){
			return null;
		}
		
		List<City> citiesToFind=new ArrayList<>();
		for(RequestSingleCity temp:request.getCities()){
			if(temp==null || (temp.getCityId()==null && temp.getCityName()==null)){
				return null;
			}
			citiesToFind.add(new City(temp.getCityId(), temp.getCityName(), null, null, null));
		}
		//TODO check if the request for the current weather is present into DB and is not to old
		
		//suppose one or more cities are not present so call the services
		APICurrentResponse currentWeatherForCityListFromAPI = weatherDataRemoteRequestExecutor.getCurrentWeatherForCityListFromAPI(citiesToFind);
		
		return currentWeatherForCityListFromAPI;
	}

	@Override
	public Object getForecastWeatherByCity(RequestSingleCity request) {
		if(request==null || (request.getCityId()==null && request.getCityName()==null)){
			return null;
		}
		//TODO check if the request for the current weather is present into DB and is not to old
		
		//suppose is not present so call the services
		APIForecastResponse forecastWeather = weatherDataRemoteRequestExecutor.getForecastWeatherForCityFromAPI(new City(request.getCityId(), request.getCityName(), null, null, null));
		
		//TODO store this data in the DB (maybe we can think to use another thread)

		return forecastWeather;
	}
	

}
