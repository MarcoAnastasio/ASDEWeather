package it.unical.asde.weather.core.services.dataprovider;

import it.unical.asde.weather.model.bean.comunication.request.RequestGeolocation;
import it.unical.asde.weather.model.bean.comunication.request.RequestSingleCity;
import it.unical.asde.weather.model.bean.data.extra.UVData;
import it.unical.asde.weather.model.bean.geographical.City;
import it.unical.asde.weather.model.exception.ASDECustomException;
import it.unical.asde.weather.model.openweatherapi.response.APICurrentResponse;

public interface ExtraDataProvider {

	
	public Object getCurrentPollutionByCity(RequestSingleCity request) throws ASDECustomException;
	
	public Object getCurrentPollutionByCity(City city) throws ASDECustomException;
	
	public Object getCurrentPollutionByCoord(RequestGeolocation geolocation) throws ASDECustomException;
	
	
	public UVData getCurrentUVByCity(RequestSingleCity request) throws ASDECustomException;
	
	public UVData getCurrentUVByCity(City city) throws ASDECustomException;
		
}
