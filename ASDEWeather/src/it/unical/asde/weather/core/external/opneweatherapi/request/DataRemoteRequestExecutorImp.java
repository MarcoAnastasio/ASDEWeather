package it.unical.asde.weather.core.external.opneweatherapi.request;

import it.unical.asde.weather.core.external.RestRequestExecutor;
import it.unical.asde.weather.core.external.opneweatherapi.decoder.ResponseOpenWeatherApiDecoder;
import it.unical.asde.weather.model.bean.comunication.response.GenericResponse.ErrorCode;
import it.unical.asde.weather.model.bean.data.extra.UVData;
import it.unical.asde.weather.model.bean.geographical.City;
import it.unical.asde.weather.model.exception.ASDECustomException;
import it.unical.asde.weather.model.openweatherapi.response.APICurrentResponse;
import it.unical.asde.weather.model.openweatherapi.response.APIForecastResponse;

import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@Configuration
@PropertySource("classpath:weatherAPI.properties")
public class DataRemoteRequestExecutorImp extends RestRequestExecutor implements DataRemoteRequestExecutor{

	private static final String ADD_PARAMEETER_CITY_NAME="q=";
	private static final String ADD_PARAMEETER_CITY_ID="id=";

	private static final String ADD_PARAMEETER_COORDS_LAT="lat=";
	private static final String ADD_PARAMEETER_COORDS_LON="&lon=";
	
	private static final String ADD_PARAMEETER_UNITS_FORMAT_CELSIUS="&units=metric";
	
	private static final String ADD_PARAMEETER_APP_KEY="&appid=";
	
	
	@Value( "${asde.weather.openweatherapi.endpoint.forecast}" )
	private String openForecastWeatherEndpoint;

	@Value( "${asde.weather.openweatherapi.endpoint.current}" )
	private String openCurrentWeatherEndpoint;

	@Value( "${asde.weather.openweatherapi.endpoint.group}" )
	private String openCurrentWeatherGroupEndpoint;	
	
	@Value( "${asde.pollution.openweatherapi.endpoint.current}" )
	private String openCurrentPollutionEndpoint;
	
	@Value( "${asde.uv.openweatherapi.endpoint.current}" )
	private String openCurrentUVEndpoint;
	
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


	@Override
	public APICurrentResponse getCurrentWeatherForCoordsFromAPI(Double latitude, Double longitude) throws ASDECustomException {
		
		//1  prepare url String
		String url=generateUrlFromBaseEndpointAndCoords(openCurrentWeatherEndpoint,latitude,longitude);
		
		//2 execute request in the superclass
		JSONObject response = super.executeRestRequestAndReturnJSONObject(url);
		
		//3 if response is not null (so maybe no errors occur)
		if(response!=null){
			return responseOpenWeatherApiDecoder.decodeCurrentWeatherResponse(response);
		}else{
			throw new ASDECustomException(null, ErrorCode.UNKNOW_ERROR, null);
		}
		
	}

	
	@Override
	public Object getCurrentPollutionForCoordsFromAPI(Double latitude,Double longitude) throws ASDECustomException {
		
		//1  prepare url String
		String url=generateUrlFromBaseEndpointAndCoords(openCurrentPollutionEndpoint,latitude,longitude);

		//2 execute request in the superclass
		JSONObject response = super.executeRestRequestAndReturnJSONObject(url);
		
		//3 if response is not null (so maybe no errors occur)
		if(response!=null){
			return responseOpenWeatherApiDecoder.decodeCurrentPollutionResponse(response);
		}else{
			throw new ASDECustomException(null, ErrorCode.UNKNOW_ERROR, null);
		}

	}
	
	
	@Override
	public UVData getCurrentUVForCoordsFromAPI(Double latiude, Double longitude) throws ASDECustomException {
		//1  prepare url String
		String url=generateUrlFromBaseEndpointAndCoordsForUV(latiude, longitude);

		//2 execute request in the superclass
		JSONObject response = super.executeRestRequestAndReturnJSONObject(url);
		
		//3 if response is not null (so maybe no errors occur)
		if(response!=null){
			return responseOpenWeatherApiDecoder.decodeCurrentUVResponse(response);
		}else{
			throw new ASDECustomException(null, ErrorCode.UNKNOW_ERROR, null);
		}

	}
	
	
	

	private String generateUrlFromBaseEndpointAndCoords(String baseEndpoint, Double latitude,Double longitude) {
		
		String url=baseEndpoint+ADD_PARAMEETER_COORDS_LAT+latitude+ADD_PARAMEETER_COORDS_LON+longitude
				+ADD_PARAMEETER_UNITS_FORMAT_CELSIUS+ADD_PARAMEETER_APP_KEY+key1;
		return url;
	}


	private String generateUrlFromBaseEndpointAndCoordsForUV(Double latitude,Double longitude) {
		//Example: http://api.openweathermap.org/data/2.5/uvi?appid=9b6b06b0162f936dd91ff6a0978b875f&lat=39.30999&lon=16.250191
		return openCurrentUVEndpoint+"appid="+key1+"&lat="+latitude+"&lon="+longitude;
	}




	
}
