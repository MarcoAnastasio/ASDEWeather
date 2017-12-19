package it.unical.asde.weather.core.utilities.opneweatherapi.decoder;

import org.json.simple.JSONObject;

import it.unical.asde.weather.model.api.response.APICurrentResponse;
import it.unical.asde.weather.model.api.response.APIForecastResponse;
import it.unical.asde.weather.model.bean.weather.WeatherForecastData;

public interface ResponseOpenWeatherApiDecoder {

	/**
	 * given the servcire response as json object, it returns a java object whit all the information
	 */
	public APIForecastResponse decodeForecastWeatherResponse(JSONObject object);

	
	public APICurrentResponse decodeCurrentWeatherResponse(JSONObject object);
	
	
	
	
}
