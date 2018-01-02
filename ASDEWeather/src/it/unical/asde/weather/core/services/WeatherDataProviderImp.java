package it.unical.asde.weather.core.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.unical.asde.weather.core.external.opneweatherapi.request.WeatherDataRemoteRequestExecutor;
import it.unical.asde.weather.dao.geographical.CityDao;
import it.unical.asde.weather.dao.weather.WeatherDataDAO;
import it.unical.asde.weather.model.bean.comunication.request.RequestListCities;
import it.unical.asde.weather.model.bean.comunication.request.RequestSingleCity;
import it.unical.asde.weather.model.bean.comunication.response.GenericResponse.ErrorCode;
import it.unical.asde.weather.model.bean.comunication.response.GenericResponseConstant;
import it.unical.asde.weather.model.bean.geographical.City;
import it.unical.asde.weather.model.bean.weather.WeatherData;
import it.unical.asde.weather.model.exception.ASDECustomException;
import it.unical.asde.weather.model.openweatherapi.response.APICurrentResponse;
import it.unical.asde.weather.model.openweatherapi.response.APIForecastResponse;

@Service
public class WeatherDataProviderImp implements WeatherDataProvider{

	//max old value stored into DB in millis 1h = 60*60*1000
	private static final Long MAX_OLD_VALUE=new Long(60*60*1000);
	
	@Autowired
	private WeatherDataRemoteRequestExecutor weatherDataRemoteRequestExecutor;
	
	@Autowired
	private CityDao cityDao;
	@Autowired
	private WeatherDataDAO weatherDataDao;
	
	
	@Override
	public Object getCurrentWeatherByCity(RequestSingleCity request) throws ASDECustomException{
		//1 check if input is correct
		if(!isRequestSingleCityValid(request)){
			throw new ASDECustomException(null, ErrorCode.WRONG_INPUT,GenericResponseConstant.WRONG_INPUT_MSG);
		}
		
		//2 check if city is present into DB
		City city = existsCityIntoDB(request.getCityId(),request.getCityName());
		if(city==null){
			throw new ASDECustomException(null, ErrorCode.CITY_NOT_EXISTS,null);			//TODO check if works whit just error code
		}
		
		//3 check if the request for the current weather is present into DB and is not to old (max time old = 1h)
		WeatherData weatherData = weatherDataDao.findWeatherDataFromCityNotOlderThan(city.getId(), MAX_OLD_VALUE);
		if(weatherData!=null){
			APICurrentResponse currentResponse=new APICurrentResponse();
			currentResponse.setListForecastWeather(new ArrayList<WeatherData>(Arrays.asList(weatherData)));
			return currentResponse;
		}
		
		
		//suppose is not present so call the services
		APICurrentResponse currentWeatherforCityFromAPI = weatherDataRemoteRequestExecutor.getCurrentWeatherForCityFromAPI(new City(request.getCityId(), request.getCityName(), null, null, null));

		//before return store it into DB
		weatherDataDao.save(weatherData);
		//TODO store this data in the DB (maybe we can think to use another thread)

		return currentWeatherforCityFromAPI;
	}

	@Override
	public Object getCurrentWeatherByCities(RequestListCities request)  throws ASDECustomException{
		if(request==null || request.getCities()==null || request.getCities().isEmpty()){
			throw new ASDECustomException(null, ErrorCode.WRONG_INPUT, null);
		}
		
		List<City> citiesToFind=new ArrayList<>();
		for(RequestSingleCity temp:request.getCities()){
			if(temp==null || (temp.getCityId()==null && temp.getCityName()==null)){
				throw new ASDECustomException(null, ErrorCode.WRONG_INPUT, null);
			}
			citiesToFind.add(new City(temp.getCityId(), temp.getCityName(), null, null, null));
		}
		
		return this.getCurrentWeatherByCitiesList(citiesToFind);
	}

	@Override
	public Object getForecastWeatherByCity(RequestSingleCity request)  throws ASDECustomException{
		if(!isRequestSingleCityValid(request)){
			throw new ASDECustomException(null, ErrorCode.WRONG_INPUT, null);
		}
		//TODO check if the request for the current weather is present into DB and is not to old
		
		//suppose is not present so call the services
		APIForecastResponse forecastWeather = weatherDataRemoteRequestExecutor.getForecastWeatherForCityFromAPI(new City(request.getCityId(), request.getCityName(), null, null, null));
		
		//TODO store this data in the DB (maybe we can think to use another thread)

		return forecastWeather;
	}
	
	
	@Override
	public APICurrentResponse getCurrentWeatherByCities(List<City> citiesToFind)  throws ASDECustomException{
		if(citiesToFind==null || citiesToFind.isEmpty()){
			throw new ASDECustomException(null, ErrorCode.WRONG_INPUT, null);
		}
		
		for(City tempC:citiesToFind){
			if(tempC==null || (tempC.getId()==null && tempC.getName()==null)){
				throw new ASDECustomException(null, ErrorCode.WRONG_INPUT, null);
			}
		}
		
		return this.getCurrentWeatherByCitiesList(citiesToFind);
	}
	
	private boolean isRequestSingleCityValid(RequestSingleCity request){
		if(request==null || (request.getCityId()==null && (request.getCityName()==null || request.getCityName().isEmpty()) ) ) {
			return false;
		}
		return true;
	}
	
	
	
	private APICurrentResponse getCurrentWeatherByCitiesList(List<City> cities) throws ASDECustomException{
		//TODO check if the request for the current weather is present into DB and is not to old
		
		//suppose one or more cities are not present so call the services
		APICurrentResponse currentWeatherForCityListFromAPI = weatherDataRemoteRequestExecutor.getCurrentWeatherForCityListFromAPI(cities);
		
		return currentWeatherForCityListFromAPI;
	}
	
	/**
	 * for Single City
	 * this method have to be call befor process request, it return the stored instance of city, 
	 * if return null the city doee not exist so thorw exception 
	 * @param cityId
	 * @param cityName
	 * @return
	 */
	private City existsCityIntoDB(Long cityId,String cityName){
//		cityDao.existsCity(cityId,cityName);
		if(cityId==null){
			return cityDao.findCityByName(cityName);
		}
		if(cityName==null){
			return cityDao.findById(cityId);
		}
		return cityDao.findCityByIdAndName(cityId, cityName);
	}

}
