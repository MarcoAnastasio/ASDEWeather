package it.unical.asde.weather.core.services.dataprovider;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import it.unical.asde.weather.dao.data.extra.UVDataDAO;
import it.unical.asde.weather.model.bean.comunication.request.RequestGeolocation;
import it.unical.asde.weather.model.bean.comunication.request.RequestSingleCity;
import it.unical.asde.weather.model.bean.comunication.response.GenericResponseConstant;
import it.unical.asde.weather.model.bean.comunication.response.GenericResponse.ErrorCode;
import it.unical.asde.weather.model.bean.data.extra.UVData;
import it.unical.asde.weather.model.bean.data.weather.WeatherData;
import it.unical.asde.weather.model.bean.geographical.City;
import it.unical.asde.weather.model.exception.ASDECustomException;
import it.unical.asde.weather.model.openweatherapi.response.APICurrentResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExtraDataProviderImp extends AbstarctGenericProvider implements ExtraDataProvider{

	@Autowired
	private UVDataDAO UVDataDAO;
	
	
	
	@Override
	public Object getCurrentPollutionByCity(RequestSingleCity request)throws ASDECustomException {

		City city=validateSingleCityRequest(request);
		
		
		
		return null;
	}

	@Override
	public Object getCurrentPollutionByCity(City city)
			throws ASDECustomException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getCurrentPollutionByCoord(RequestGeolocation geolocation)throws ASDECustomException {
		// TODO Auto-generated method stub
		return null;
	}

//		http://api.openweathermap.org/pollution/v1/co/{location}/{datetime}.json?appid={api_key}
	
	
	
	private Object getPollutionData(Double longitude,Double latitude){
		
		//3 check if the request for the current weather is present into DB and is not to old (max time old = 1h)
		Date maxOldValue=this.decrementDateByMillis(MAX_OLD_VALUE);

		
		//suppose is not present so call the services
//		APICurrentResponse currentWeatherforCityFromAPI = weatherDataRemoteRequestExecutor.getCurrentWeatherForCityFromAPI(new City(request.getCityId(), request.getCityName(), null, null, null));
		
		
		/**
		
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
		 */
		
		return null;
	}

	
	
	
	@Override
	@Transactional
	public UVData getCurrentUVByCity(RequestSingleCity request) throws ASDECustomException {
		City city=validateSingleCityRequest(request);
		
		return getUVData(city);
	}

	@Override
	@Transactional
	public UVData getCurrentUVByCity(City city) throws ASDECustomException {
		
		City validCity = validateRequestByCity(city);
		return getUVData(city);

	}
	
	
	private UVData getUVData(City city) throws ASDECustomException{
		
		//1 check if the request for the current weather is present into DB 
		//suppose once a day we can skip the check about the calculation time
		Date today=Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
		UVData findUVDataFromCityAndDay = UVDataDAO.findUVDataFromCityAndDay(city.getId(), today);
		
		if(findUVDataFromCityAndDay!=null){
			return findUVDataFromCityAndDay;
		}
		
		//2 is not present so call the services
//		APICurrentResponse currentWeatherforCityFromAPI = weatherDataRemoteRequestExecutor.getCurrentWeatherForCityFromAPI(new City(request.getCityId(), request.getCityName(), null, null, null));
		UVData currentUV = weatherDataRemoteRequestExecutor.getCurrentUVForCoordsFromAPI(city.getLatitude(), city.getLongitude());
		
		//3 store de currentUV
		currentUV.setDateCalulation(today);
		currentUV.setCity(city);
		UVDataDAO.save(currentUV);
		
		return currentUV;
	}

	
}
