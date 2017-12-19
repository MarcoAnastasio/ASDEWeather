package it.unical.asde.weather.core.utilities.opneweatherapi.request;

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

import it.unical.asde.weather.core.general.web.request.RestRequestExecutor;
import it.unical.asde.weather.core.utilities.opneweatherapi.ResponseWeatherForecastDecoder;
import it.unical.asde.weather.core.utilities.opneweatherapi.decoder.ResponseOpenWeatherApiDecoder;
import it.unical.asde.weather.model.api.response.APICurrentResponse;
import it.unical.asde.weather.model.api.response.APIForecastResponse;
import it.unical.asde.weather.model.bean.geographical.City;
import it.unical.asde.weather.model.bean.weather.WeatherData;
import it.unical.asde.weather.model.bean.weather.WeatherForecastData;

@Service
@Configuration
@PropertySource("classpath:weatherAPI.properties")
public class WeatherDataRequestExecutorImp extends RestRequestExecutor implements WeatherDataRequestExecutor{

	private static final String ADD_PARAMEETER_CITY_ID="id=";
	private static final String ADD_PARAMEETER_APP_KEY="&appid=";

	
	@Value( "${asde.weather.openweatherapi.endpoint.forecast}" )
	private String openForecastWeatherEndpoint;
//	@Value( "${asde.weather.openweatherapi.endpoint.current}" )
	@Value( "${asde.weather.openweatherapi.endpoint.group}" )
	private String openCurrentWeatherEndpoint;
	
	@Value( "${asde.weather.openweatherapi.key1}" )
	private String key1;
	@Value( "${asde.weather.openweatherapi.key2}" )
	private String key2;
	
	
	@Autowired
	private ResponseWeatherForecastDecoder responseDecoder;
	
	@Autowired
	private ResponseOpenWeatherApiDecoder responseOpenWeatherApiDecoder;
	
	private static final JSONParser jsonParser=new JSONParser();

	
	/**
	 * given a city this methods retrives the forecast 5 days weather,
	 * try to use the city id and if it is not present use the city name 
	 * @param city
	 */
	@Override
	public APIForecastResponse getWeatherForecastforCityFromAPI(City city) {
			
		if(city==null){
			return null;
		}
		
		//1  prepare url String
		String url = openForecastWeatherEndpoint+ADD_PARAMEETER_CITY_ID+city.getId()+
				ADD_PARAMEETER_APP_KEY+key1;
		
		//2 execute request in the superclass
		JSONObject response = super.executeRestRequestAndReturnJSONObject(url);
		
		//3 if response is not null (so maybe no errors occur)
		if(response!=null){
			return responseOpenWeatherApiDecoder.decodeForecastWeatherResponse(response);
		}
		
		return null;
	}


	/**
	 * given a city this methods retrives the current weather,try to use the city id and if it is not present use the city name 
	 * @param city
	 */
	@Override
	public APICurrentResponse getCurrentWeatherforCityFromAPI(City city) {
		if(city== null){
			return null;
		}
		
		String url = openCurrentWeatherEndpoint+ADD_PARAMEETER_CITY_ID+city.getId()+
				ADD_PARAMEETER_APP_KEY+key1;
		
		//2 execute request in the superclass
		JSONObject response = super.executeRestRequestAndReturnJSONObject(url);

		if(response!=null){
			return responseOpenWeatherApiDecoder.decodeCurrentWeatherResponse(response);
		}
		return null;
	}


	@Override
	public APICurrentResponse getCurrentWeatherforCityListFromAPI(List<City> cities) {
		if(cities==null || cities.isEmpty()){
			return null;			
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
		String url=openCurrentWeatherEndpoint+ADD_PARAMEETER_CITY_ID+citiesIds+ADD_PARAMEETER_APP_KEY+key1;
		
		//2 execute request in the superclass
		JSONObject response = super.executeRestRequestAndReturnJSONObject(url);
		
		//3 if response is not null (so maybe no errors occur)
		if(response!=null){
			return responseOpenWeatherApiDecoder.decodeCurrentWeatherResponse(response);
		}
		
		return null;
	}
	
	
	
	
}
