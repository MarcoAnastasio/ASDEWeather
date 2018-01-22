package it.unical.asde.weather.core.services.data.dataprovider;

import it.unical.asde.weather.dao.data.extra.UVDataDAO;
import it.unical.asde.weather.model.bean.comunication.request.RequestGeolocation;
import it.unical.asde.weather.model.bean.comunication.request.RequestSingleCity;
import it.unical.asde.weather.model.bean.data.extra.UVData;
import it.unical.asde.weather.model.bean.geographical.City;
import it.unical.asde.weather.model.exception.ASDECustomException;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExtraDataProviderImp extends AbstarctGenericProvider implements ExtraDataProvider{

	@Autowired
	private UVDataDAO UVDataDAO;
	
	
	
	@Override
	@Deprecated
	public Object getCurrentPollutionByCity(RequestSingleCity request)throws ASDECustomException {

		City city=validateSingleCityRequest(request);
		
		
		
		return null;
	}

	@Deprecated
	@Override
	public Object getCurrentPollutionByCity(City city)
			throws ASDECustomException {
		return null;
	}

	@Override
	@Deprecated
	public Object getCurrentPollutionByCoord(RequestGeolocation geolocation)throws ASDECustomException {
		return null;
	}

	
	
	@Deprecated
	private Object getPollutionData(Double longitude,Double latitude){
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
