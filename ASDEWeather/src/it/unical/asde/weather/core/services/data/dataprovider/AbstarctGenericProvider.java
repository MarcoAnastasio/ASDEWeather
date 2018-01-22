package it.unical.asde.weather.core.services.data.dataprovider;

import it.unical.asde.weather.core.external.opneweatherapi.request.DataRemoteRequestExecutor;
import it.unical.asde.weather.dao.geographical.CityDao;
import it.unical.asde.weather.model.bean.comunication.request.RequestSingleCity;
import it.unical.asde.weather.model.bean.comunication.response.GenericResponse.ErrorCode;
import it.unical.asde.weather.model.bean.comunication.response.GenericResponseConstant;
import it.unical.asde.weather.model.bean.data.weather.WeatherData;
import it.unical.asde.weather.model.bean.geographical.City;
import it.unical.asde.weather.model.exception.ASDECustomException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public abstract class AbstarctGenericProvider {

	//max old value stored into DB in millis 1h 
	@Value( "${asde.weather.data_refresh_time}" )
	protected Long MAX_OLD_VALUE;
	
	@Autowired
	protected CityDao cityDao;
	
	@Autowired
	protected DataRemoteRequestExecutor weatherDataRemoteRequestExecutor;
	
	
	protected boolean isRequestSingleCityValid(RequestSingleCity request){
		if(request==null || (request.getCityId()==null && (request.getCityName()==null || request.getCityName().isEmpty()) ) ) {
			return false;
		}
		return true;
	}
	
	
	protected City validateRequestByCity(City request) throws ASDECustomException{
		
		if(request==null || (request.getId()==null && request.getName()==null)){
			throw new ASDECustomException(null, ErrorCode.WRONG_INPUT, null);
		}
		
		City existsCityIntoDB = existsCityIntoDB(request.getId(), request.getName());
		
		if(existsCityIntoDB!=null){
			return existsCityIntoDB;
		}else{
			throw new ASDECustomException(null, ErrorCode.CITY_NOT_EXISTS, null);
		}
		
	}
	
	
	/**
	 * for Single City
	 * this method have to be call befor process request, it return the stored instance of city, 
	 * if return null the city doee not exist so thorw exception 
	 * @param cityId
	 * @param cityName
	 * @return
	 */
	protected City existsCityIntoDB(Long cityId,String cityName){
//		cityDao.existsCity(cityId,cityName);
		if(cityId==null){
			return cityDao.findCityByName(cityName);
		}
		if(cityName==null){
			return cityDao.findById(cityId);
		}
		return cityDao.findCityByIdAndName(cityId, cityName);
	}
	
	
	protected Date decrementDateByMillis(Long millis){
		return new Date(
				new Date().getTime()-millis
				);
	}
	
	protected List<Long> getIdsFromListCities(List<City> cities){
		List<Long> returnList=new ArrayList<>();
		for(City c:cities){
			returnList.add(c.getId());
		}
		return returnList;
	}

	
	protected List<City> removeFindedCities(List<City> cities,List<WeatherData> weatherDataDB) {
		if(weatherDataDB.isEmpty()){
			return cities;
		}
		List<City> returnList=new ArrayList<City>();
		
		
		for(City tempCity:cities){
			boolean find=false;
		
			for(WeatherData tempWeather:weatherDataDB){
				Long tempId=tempWeather.getCity().getId();
				if(tempCity.getId().equals(tempId)){
					find=true;
					break;
				}
			}

			if(!find){
				returnList.add(tempCity);
			}
		}
		return returnList;
	}
	
	
	protected City validateSingleCityRequest(RequestSingleCity request) throws ASDECustomException{
		 //1 check if input is correct
		if(!isRequestSingleCityValid(request)){
			throw new ASDECustomException(null, ErrorCode.WRONG_INPUT,GenericResponseConstant.WRONG_INPUT_MSG);
		}
		
		//2 check if city is present into DB
		City city = existsCityIntoDB(request.getCityId(),request.getCityName());
		if(city==null){
			throw new ASDECustomException(null, ErrorCode.CITY_NOT_EXISTS,null);			//TODO check if works whit just error code
		}
		return city;
	}
	
}
