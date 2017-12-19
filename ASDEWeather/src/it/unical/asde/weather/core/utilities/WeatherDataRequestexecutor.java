package it.unical.asde.weather.core.utilities;

import java.awt.List;
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

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import it.unical.asde.weather.core.utilities.opneweatherapi.ResponseWeatherForecastDecoder;
import it.unical.asde.weather.model.bean.geographical.City;
import it.unical.asde.weather.model.bean.weather.SingleWeatherForecast;

@Service
@Configuration
@PropertySource("classpath:weatherAPI.properties")
public class WeatherDataRequestexecutor {

	private static final String ADD_PARAMEETER_CITY_ID="id=";
	private static final String ADD_PARAMEETER_APP_KEY="&appid=";

	
	//properties taken from configuration file
	@Value( "${asde.weather.openweatherapi.endpoint}" )
	private String openWeatherBaseEndpoint;
	@Value( "${asde.weather.openweatherapi.key1}" )
	private String key1;
	@Value( "${asde.weather.openweatherapi.key2}" )
	private String key2;
	
	
	
	
	
	
	@Autowired
	private ResponseWeatherForecastDecoder responseDecoder;
	
	
	private static final JSONParser jsonParser=new JSONParser();

	
	/**
	 * given a city this methods retrives the forecast 5 days weather,
	 * try to use the city id and if it is not present use the city name 
	 * @param city
	 */
	public java.util.List<SingleWeatherForecast> getWeatherForecastforCityFromAPI(City city){
			
		if(city==null){
			return null;
		}
		
		//1  prepare url String
		String url = openWeatherBaseEndpoint+ADD_PARAMEETER_CITY_ID+city.getId()+
				ADD_PARAMEETER_APP_KEY+key1;
		
		System.out.println("going to call:\n"+url);
		//2 call service
		InputStream input=null;
		try {
			input=new URL(url).openStream();
			JSONObject responseObject =(JSONObject) jsonParser.parse(IOUtils.toString(new URL(url),"UTF-8"));
			//1 parse response code chek the status
			int responseCod=Integer.parseInt((String)responseObject.get("cod"));
			if(responseCod==200){
				java.util.List<SingleWeatherForecast> listPrevision=new ArrayList<>();
				JSONArray listArray=(JSONArray) responseObject.get("list");
				for(int i=0;i<listArray.size();i++){

					listPrevision.add( responseDecoder.elaborateForecastInformation((JSONObject)listArray.get(i)) );

				}
				return listPrevision; 
			}else{
				//TODO handle response
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally{
//			input.close();
		}
		

		
		
		return null;
	}


	private void elaborateForecastInformation(JSONObject object) {
		Long dcValue=(Long)object.get("dt");
		//first import data
		Date dateTimeOfForecast=Date.from( Instant.ofEpochSecond (dcValue) ); 
		
		JSONObject main=(JSONObject) object.get("main");
		float temp=(float) main.get("temp");
		float temp_min=(float) main.get("temp_min");
		float temp_max=(float) main.get("temp_max");
		float pressure=(float) main.get("preassure");
		float sea_level=(float) main.get("sea_level");
		float grnd_level=(float) main.get("grnd_level");
		float humidity=(float) main.get("humidity");
		float temp_kf=(float) main.get("temp_kf");		
	}
	
	
	
	
	
}
