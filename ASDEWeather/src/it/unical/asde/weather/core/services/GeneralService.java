package it.unical.asde.weather.core.services;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import it.unical.asde.weather.dao.geographical.CityDao;
import it.unical.asde.weather.model.bean.comunication.request.RequestCityNameSubstring;
import it.unical.asde.weather.model.bean.comunication.request.RequestGeolocation;
import it.unical.asde.weather.model.bean.comunication.response.GenericResponse.ErrorCode;
import it.unical.asde.weather.model.bean.comunication.response.IndexResponseDTO;
import it.unical.asde.weather.model.bean.geographical.City;
import it.unical.asde.weather.model.exception.ASDECustomException;
import it.unical.asde.weather.model.openweatherapi.response.APICurrentResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class GeneralService {

	
	private String[] randomCitiesName=new String[]{"Roma","London","Barcellona","Lisbon","Amsterdam","Prague","Napoli","Cosenza"};
	
	private int numberRandomCitiesInIndex=2;
	
	private City[] randomCities;
	
	@Autowired
	private CityDao cityDao;
	
	@Autowired
	private WeatherDataProvider weatherDataProvider;

	
	@PostConstruct
	private void initListCities(){
		List<City> findCitiesByName = cityDao.findCitiesByName(new ArrayList<String>(Arrays.asList(randomCitiesName)) );
		randomCities = findCitiesByName.toArray(new City[findCitiesByName.size()]);
	}
	
	
	
	
	@Transactional
	public IndexResponseDTO getIndexInfo(RequestGeolocation request) throws ASDECustomException{
		IndexResponseDTO response=new IndexResponseDTO();
	
		//retrive info about X random cities,
		List<City> randomCitiesFromList = getRandomCitiesFromList();
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
		return cityDao.findCityByNameSubstring(request.getSubName());
	}
	
	
	private List<City> getRandomCitiesFromList(){
		
		ArrayList<City> arrayList = new ArrayList<City>();
		for(int i=0;i<numberRandomCitiesInIndex;i++){
			arrayList.add(randomCities[i]);
		}
		
		return arrayList;
	}
	
}
