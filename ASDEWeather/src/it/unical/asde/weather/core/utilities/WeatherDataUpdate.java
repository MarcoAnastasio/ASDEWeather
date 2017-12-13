package it.unical.asde.weather.core.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import it.unical.asde.weather.model.bean.geographical.City;

@Configuration
@Service
public class WeatherDataUpdate {

	private static final String ADD_PARAMEETER_CITY_ID="id=";
	private static final String ADD_PARAMEETER_APP_KEY="appid=";
	private static final String ADD_PARAMEETER_SIGN="?";
	
	@Value( "${asde.weather.openweatherapi.key1}" )
	private String key1;
	
	
	@Value( "${asde.weather.openweatherapi.endpoint}" )
	//"http://api.openweathermap.org/data/2.5/forecast?"
	private String openWeatherBaseEndpoint;
	
	
	
	
	/**
	 * given a city this methods retrives the forecast 5 days weather,
	 * try to use the city id and if it is not present use the city name 
	 * @param city
	 */
	public Object getWeatherforCityFromAPI(City city){
		
		if(city==null){
			return null;
		}
		
		//http://api.openweathermap.org/data/2.5/forecast?id=2524907&appid=80632c3603d35d937052d7efea13fac8
		//1  prepare url String
		String url = openWeatherBaseEndpoint+ADD_PARAMEETER_CITY_ID+city.getId()+
				ADD_PARAMEETER_SIGN+ADD_PARAMEETER_APP_KEY+key1;
		
		System.out.println("going to call:\n"+url);
		//2 call service
		InputStream input=null;
		try {
			input=new URL(url).openStream();
			String genreJson = IOUtils.toString(new URL(url));		
		
		
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally{
			input.close();
		}
		
		
		/*
		String url = "http://freemusicarchive.org/api/get/genres.json?api_key=60BLHNQCAOUFPIBZ&limit=2";
		String genreJson = IOUtils.toString(new URL(url));
		JSONObject json = new JSONObject(genreJson);
		// get the title
		System.out.println(json.get("title"));
		// get the data
		JSONArray genreArray = (JSONArray) json.get("dataset");
		// get the first genre
		JSONObject firstGenre = (JSONObject) genreArray.get(0);
		System.out.println(firstGenre.get("genre_title"));
		*/
		
		
		return null;
	}
	
	
	
	
	
}
