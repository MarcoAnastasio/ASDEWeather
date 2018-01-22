package it.unical.asde.weather.core.services;

import it.unical.asde.weather.core.services.data.dataprovider.WeatherDataProvider;
import it.unical.asde.weather.dao.geographical.CityDao;
import it.unical.asde.weather.model.bean.comunication.request.RequestCityNameSubstring;
import it.unical.asde.weather.model.bean.comunication.request.RequestGeolocation;
import it.unical.asde.weather.model.bean.comunication.response.GenericResponse.ErrorCode;
import it.unical.asde.weather.model.bean.comunication.response.IndexResponseDTO;
import it.unical.asde.weather.model.bean.data.weather.WeatherData;
import it.unical.asde.weather.model.bean.geographical.City;
import it.unical.asde.weather.model.exception.ASDECustomException;
import it.unical.asde.weather.model.openweatherapi.response.APICurrentResponse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class GeneralService {

	
	
	private static final int NUMBER_RANDOM_CITIES=4;
	
	@Autowired
	private CityDao cityDao;
	
	@Autowired
	private WeatherDataProvider weatherDataProvider;

	
	@Transactional
	public IndexResponseDTO getIndexInfo(RequestGeolocation request) throws ASDECustomException{
		IndexResponseDTO response=new IndexResponseDTO();
	
		//retrive info about X random cities,
		List<City> randomCitiesFromList = cityDao.findRandomCities(NUMBER_RANDOM_CITIES);
		APICurrentResponse currentWeatherByCities = weatherDataProvider.getCurrentWeatherByCities(randomCitiesFromList);
		response.setRandomCitiesWeather(currentWeatherByCities.getListForecastWeather());
		
		
		// if request is valid perform request using coords
		if(request!=null && request.getLatitude()!=null && request.getLongitude()!=null){
			APICurrentResponse currentWeatherByCoords = weatherDataProvider.getCurrentWeatherByCoords(request.getLatitude(),request.getLongitude());
			response.setCurrentLocationWeather(currentWeatherByCoords.getListForecastWeather().get(0));
		}
		
		return response;
	}

	@Transactional(readOnly=true)
	public List<City>  getCityByNameSubstring(RequestCityNameSubstring request) throws ASDECustomException{

		if(request==null || request.getSubName()==null || request.getSubName().isEmpty()){
			throw new ASDECustomException(null, ErrorCode.WRONG_INPUT, null);
		}
		System.err.println("random substring="+request.getSubName());
		return cityDao.findCityByNameSubstring(request.getSubName());
	}

	
	@Transactional
	public List<WeatherData> getRandomCitiesCurrentWeather() throws Exception{
		List<City> randomCitiesFromList = cityDao.findRandomCities(NUMBER_RANDOM_CITIES);
		APICurrentResponse currentWeatherByCities = weatherDataProvider.getCurrentWeatherByCities(randomCitiesFromList);
		return currentWeatherByCities.getListForecastWeather();
	}
	
	

	
}
