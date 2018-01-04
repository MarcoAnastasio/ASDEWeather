package it.unical.asde.weather.core.external.opneweatherapi.request;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import it.unical.asde.weather.core.external.RestRequestExecutor;
import it.unical.asde.weather.core.external.opneweatherapi.decoder.ResponseOpenWeatherApiDecoder;
import it.unical.asde.weather.model.bean.comunication.response.GenericResponse.ErrorCode;
import it.unical.asde.weather.model.bean.geographical.City;
import it.unical.asde.weather.model.bean.weather.WeatherData;
import it.unical.asde.weather.model.bean.weather.WeatherForecastData;
import it.unical.asde.weather.model.exception.ASDECustomException;
import it.unical.asde.weather.model.openweatherapi.response.APICurrentResponse;
import it.unical.asde.weather.model.openweatherapi.response.APIForecastResponse;

@Service
@Configuration
@PropertySource("classpath:weatherAPI.properties")
public class WeatherDataRemoteRequestExecutorImp extends RestRequestExecutor implements WeatherDataRemoteRequestExecutor{

	private static final String ADD_PARAMEETER_CITY_NAME="q=";
	private static final String ADD_PARAMEETER_CITY_ID="id=";
	
	private static final String ADD_PARAMEETER_UNITS_FORMAT_CELSIUS="&units=metric";
	
	private static final String ADD_PARAMEETER_APP_KEY="&appid=";
	
	
	@Value( "${asde.weather.openweatherapi.endpoint.forecast}" )
	private String openForecastWeatherEndpoint;

	@Value( "${asde.weather.openweatherapi.endpoint.current}" )
	private String openCurrentWeatherEndpoint;

	@Value( "${asde.weather.openweatherapi.endpoint.group}" )
	private String openCurrentWeatherGroupEndpoint;
	
	@Value( "${asde.weather.openweatherapi.key1}" )
	private String key1;
	@Value( "${asde.weather.openweatherapi.key2}" )
	private String key2;
	
	
	@Autowired
	private ResponseOpenWeatherApiDecoder responseOpenWeatherApiDecoder;
	
	private static final JSONParser jsonParser=new JSONParser();

	
	/**
	 * given a city this methods retrives the forecast 5 days weather,
	 * try to use the city id and if it is not present use the city name 
	 * @param city
	 */
	@Override
	public APIForecastResponse getForecastWeatherForCityFromAPI(City city) throws ASDECustomException{
			
		if(city==null){
			throw new ASDECustomException(null, ErrorCode.WRONG_INPUT, null);
		}
		
		//1  prepare url String
		String url=generateUrlFromBaseEndpointAndCity(openForecastWeatherEndpoint,city);
		
		//2 execute request in the superclass
		JSONObject response = super.executeRestRequestAndReturnJSONObject(url);
		
		//3 if response is not null (so maybe no errors occur)
		if(response!=null){
			return responseOpenWeatherApiDecoder.decodeForecastWeatherResponse(response,city);
		}else{
			throw new ASDECustomException(null, ErrorCode.UNKNOW_ERROR, null);
		}

	}


	/**
	 * given a city this methods retrives the current weather,try to use the city id and if it is not present use the city name 
	 * @param city
	 */
	@Override
	public APICurrentResponse getCurrentWeatherForCityFromAPI(City city) throws ASDECustomException{
		if(city== null){
			throw new ASDECustomException(null, ErrorCode.WRONG_INPUT, null);
		}
		
		String url=generateUrlFromBaseEndpointAndCity(openCurrentWeatherEndpoint,city);
		
		//2 execute request in the superclass
		JSONObject response = super.executeRestRequestAndReturnJSONObject(url);

		if(response!=null){
			return responseOpenWeatherApiDecoder.decodeCurrentWeatherResponse(response);
		}else{
			throw new ASDECustomException(null, ErrorCode.UNKNOW_ERROR, null);
		}
	}


	/**
	 * given a List of Cities retrive the current Weather for all, input cities must have a valid id, 
	 * is not possible to submit request whitout the cities 's id 
	 */
	@Override
	public APICurrentResponse getCurrentWeatherForCityListFromAPI(List<City> cities) throws ASDECustomException{
		if(cities==null || cities.isEmpty()){
			throw new ASDECustomException(null, ErrorCode.WRONG_INPUT, null);
		}
		
		String citiesIds="";
		boolean first=true;
		for(City tempCity:cities){
			if(first){
				citiesIds+=tempCity.getId();
				first=false;
			}else{
				citiesIds+=","+tempCity.getId();
			}
		}
		
		//1  prepare url String
		String url=openCurrentWeatherGroupEndpoint+ADD_PARAMEETER_CITY_ID+citiesIds+
				ADD_PARAMEETER_UNITS_FORMAT_CELSIUS+ADD_PARAMEETER_APP_KEY+key1;
		
		//2 execute request in the superclass
		JSONObject response = super.executeRestRequestAndReturnJSONObject(url);
		
		//3 if response is not null (so maybe no errors occur)
		if(response!=null){
			return responseOpenWeatherApiDecoder.decodeCurrentWeatherGroupResponse(response);
		}else{
			throw new ASDECustomException(null, ErrorCode.UNKNOW_ERROR, null);
		}
	}
	
	
	/**
	 * given a base nedpoint and a city generate the url, city mast have at least the id or the name
	 * 
	 * @param baseEndpoint
	 * @param city
	 * @return
	 */
	private String generateUrlFromBaseEndpointAndCity(String baseEndpoint,City city){
		String url=null;
		if(city.getId()!=null){
			url=baseEndpoint+ADD_PARAMEETER_CITY_ID+city.getId();
		}else{
			if(city.getName()!=null){
				url = baseEndpoint+ADD_PARAMEETER_CITY_NAME+city.getName();
			}else{
				return null;
			}
		}
		url+=ADD_PARAMEETER_UNITS_FORMAT_CELSIUS+ADD_PARAMEETER_APP_KEY+key1;
		return url;
	}
	
}
