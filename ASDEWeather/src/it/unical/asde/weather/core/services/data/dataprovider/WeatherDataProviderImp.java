package it.unical.asde.weather.core.services.data.dataprovider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.unical.asde.weather.core.external.opneweatherapi.request.DataRemoteRequestExecutor;
import it.unical.asde.weather.dao.data.weather.WeatherDataDAO;
import it.unical.asde.weather.dao.data.weather.WeatherForecastDataDAO;
import it.unical.asde.weather.dao.geographical.CityDao;
import it.unical.asde.weather.model.bean.comunication.request.RequestGeolocation;
import it.unical.asde.weather.model.bean.comunication.request.RequestListCities;
import it.unical.asde.weather.model.bean.comunication.request.RequestSingleCity;
import it.unical.asde.weather.model.bean.comunication.response.ForecastUVResponseDTO;
import it.unical.asde.weather.model.bean.comunication.response.GenericResponse.ErrorCode;
import it.unical.asde.weather.model.bean.comunication.response.GenericResponseConstant;
import it.unical.asde.weather.model.bean.data.extra.UVData;
import it.unical.asde.weather.model.bean.data.weather.WeatherData;
import it.unical.asde.weather.model.bean.data.weather.WeatherForecastData;
import it.unical.asde.weather.model.bean.geographical.City;
import it.unical.asde.weather.model.exception.ASDECustomException;
import it.unical.asde.weather.model.openweatherapi.response.APICurrentResponse;
import it.unical.asde.weather.model.openweatherapi.response.APIForecastResponse;

@Service
public class WeatherDataProviderImp extends AbstarctGenericProvider implements WeatherDataProvider{

	@Autowired
	private WeatherDataDAO weatherDataDao;
	@Autowired
	private WeatherForecastDataDAO weatherForecastDataDAO;
	@Autowired
	private ExtraDataProvider extraDataProvider;
	
	@Override
	public APICurrentResponse getCurrentWeatherByCoords(Double latitude, Double longitude) throws ASDECustomException {
		return  weatherDataRemoteRequestExecutor.getCurrentWeatherForCoordsFromAPI(latitude,longitude);
	}
	
	@Override
	@Transactional
	public APICurrentResponse getCurrentWeatherByCity(RequestSingleCity request) throws ASDECustomException{
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
		Date maxOldValue=this.decrementDateByMillis(MAX_OLD_VALUE);
		WeatherData weatherData = weatherDataDao.findWeatherDataFromCityNotOlderThan(city.getId(), maxOldValue);
		if(weatherData!=null){
			APICurrentResponse currentResponse=new APICurrentResponse();
			currentResponse.setListForecastWeather(new ArrayList<WeatherData>(Arrays.asList(weatherData)));
			return currentResponse;
		}
		
		
		//suppose is not present so call the services
		APICurrentResponse currentWeatherforCityFromAPI = weatherDataRemoteRequestExecutor.getCurrentWeatherForCityFromAPI(new City(request.getCityId(), request.getCityName(), null, null, null));

		//before return store it into DB
		WeatherData dataToSave=currentWeatherforCityFromAPI.getListForecastWeather().get(0);
		if(dataToSave!=null){
			weatherDataDao.save(dataToSave);			
		}
		//TODO store this data in the DB (maybe we can think to use another thread)

		return currentWeatherforCityFromAPI;
	}

	@Override
	@Transactional
	public APICurrentResponse getCurrentWeatherByCities(RequestListCities request)  throws ASDECustomException{
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
	@Transactional
	public APIForecastResponse getForecastWeatherByCity(RequestSingleCity request)  throws ASDECustomException{
		if(!isRequestSingleCityValid(request)){
			throw new ASDECustomException(null, ErrorCode.WRONG_INPUT, null);
		}
		
		//2 check if city is present into DB
		City city = existsCityIntoDB(request.getCityId(),request.getCityName());
		if(city==null){
			throw new ASDECustomException(null, ErrorCode.CITY_NOT_EXISTS,null);			//TODO check if works whit just error code
		}
		
		//3 check if the request for the forecast weather is present into DB and is not to old (max time old = 1h)
		Date maxOldValue=this.decrementDateByMillis(MAX_OLD_VALUE);
		List<WeatherForecastData> forecastDataFromDB=weatherForecastDataDAO.findWeatherForecastDataFromCityNotOlderThan(city.getId(), maxOldValue);
		if(forecastDataFromDB!=null && !forecastDataFromDB.isEmpty()){
			APIForecastResponse forecastWeather=new APIForecastResponse(null, city, city.getCountry(), forecastDataFromDB);
			return forecastWeather;
		}
		
		//4 is not present so call the services
		APIForecastResponse forecastWeather = weatherDataRemoteRequestExecutor.getForecastWeatherForCityFromAPI(city);
		
		//5 store this data in the DB 		//TODO  (maybe we can think to use another thread)
		List<WeatherForecastData> listForecastWeather = forecastWeather.getListForecastWeather();
		if(listForecastWeather!=null && !listForecastWeather.isEmpty()){
			weatherForecastDataDAO.saveList(forecastWeather.getListForecastWeather());			
		}
		
		return forecastWeather;
	}
	
	
	@Override
	@Transactional
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
	

	
	
	//no transactional, no interaction Whit DB....
	@Override
	public APICurrentResponse getCurrentWeatherByCoords(RequestGeolocation request) throws ASDECustomException {

		if(request==null || request.getLatitude()==null || request.getLongitude()==null){
			throw new ASDECustomException(null, ErrorCode.WRONG_INPUT, null);
		}
			
		return this.getCurrentWeatherByCoords(request.getLatitude(),request.getLongitude());

	}
	
	

	private APICurrentResponse getCurrentWeatherByCitiesList(List<City> cities) throws ASDECustomException{
		//1 check list of cities exists into DB
		//TODO analyze the usage of this method.. maybe this test can be skippedd as i think... so for now it is not implemented...
		
		//2 check if the request for the current weather is present into DB and is not to old... 
		Date maxOldValue=this.decrementDateByMillis(MAX_OLD_VALUE);
		List<WeatherData> weatherDataDB= weatherDataDao.findWeatherDataFromCitiesNotOlderThan(getIdsFromListCities(cities),maxOldValue);
	
		//3 remove froom request the cities alreadyFound
		List<City> citiesStillNotPresent=removeFindedCities(cities,weatherDataDB);
		
		if(citiesStillNotPresent==null || citiesStillNotPresent.isEmpty()){
			return new APICurrentResponse(null,weatherDataDB);
		}
		
		//4 suppose one or more cities are not present so call the services
		APICurrentResponse currentWeatherForCityListFromAPI = weatherDataRemoteRequestExecutor.getCurrentWeatherForCityListFromAPI(citiesStillNotPresent);
		
		//5 store new weather...
		List<WeatherData> listForecastWeather = currentWeatherForCityListFromAPI.getListForecastWeather();
		if(listForecastWeather!=null && !listForecastWeather.isEmpty()){
			weatherDataDao.saveList(listForecastWeather);			
		}
		
		//6 add finded cities
		currentWeatherForCityListFromAPI.getListForecastWeather().addAll(weatherDataDB);
		
		return currentWeatherForCityListFromAPI;
	}

	@Override
	@Transactional
	public ForecastUVResponseDTO getForecastWeatherAndUvByCity(RequestSingleCity request) throws Exception {
		APIForecastResponse forecastByCity = this.getForecastWeatherByCity(request);
		UVData currentUVByCity = extraDataProvider.getCurrentUVByCity(request);
		return new ForecastUVResponseDTO(forecastByCity.getCity(), forecastByCity.getListForecastWeather(), currentUVByCity);
	}

	
	
	



	
	


	
}
