package it.unical.asde.weather.core.external.opneweatherapi.decoder;

import org.json.simple.JSONObject;

import it.unical.asde.weather.model.bean.geographical.City;
import it.unical.asde.weather.model.bean.weather.WeatherForecastData;
import it.unical.asde.weather.model.openweatherapi.response.APICurrentResponse;
import it.unical.asde.weather.model.openweatherapi.response.APIForecastResponse;

public interface ResponseOpenWeatherApiDecoder {

	/**
	 * given the servcire response as json object, it returns a java object whit all the information
	 */
	public APIForecastResponse decodeForecastWeatherResponse(JSONObject object,City requestCity);

	/**
	 * decode the result of current  Weather request for a single city
	 * @param response
	 * @return
	 */
	public APICurrentResponse decodeCurrentWeatherResponse(JSONObject response);
	
	/**
	 * decode the result of current  Weather request for a list of cities
	 * @param response
	 * @return
	 */
	public APICurrentResponse decodeCurrentWeatherGroupResponse(JSONObject object);


	
	
	
	
}
