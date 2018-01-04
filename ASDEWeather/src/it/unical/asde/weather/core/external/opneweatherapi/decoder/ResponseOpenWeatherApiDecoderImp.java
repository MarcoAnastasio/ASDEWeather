package it.unical.asde.weather.core.external.opneweatherapi.decoder;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import it.unical.asde.weather.model.bean.geographical.City;
import it.unical.asde.weather.model.bean.weather.MainTemperature;
import it.unical.asde.weather.model.bean.weather.Weather;
import it.unical.asde.weather.model.bean.weather.WeatherData;
import it.unical.asde.weather.model.bean.weather.WeatherForecastData;
import it.unical.asde.weather.model.bean.weather.Wind;
import it.unical.asde.weather.model.openweatherapi.response.APICurrentResponse;
import it.unical.asde.weather.model.openweatherapi.response.APIForecastResponse;

@Service
public class ResponseOpenWeatherApiDecoderImp implements ResponseOpenWeatherApiDecoder {

	private static final DateFormat forecastDateTimeCalulationFormatter  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Override
	public APIForecastResponse decodeForecastWeatherResponse(JSONObject responseObject,City requestCity) {

		//TODO we can had reference to cityes and/or to state if we want...
		APIForecastResponse forecastResponse=new APIForecastResponse();
		
		forecastResponse.setRequestCode(Integer.parseInt((String)responseObject.get("cod")) );
		if(forecastResponse.getRequestCode()!=200){
			return forecastResponse;
		}
		
		
		//City city=decodeCity((JSONObject)responseObject.get("city"));
		forecastResponse.setCity(requestCity);
		
		
		List<WeatherForecastData> listPrevision=new ArrayList<>();
		JSONArray listArray=(JSONArray) responseObject.get("list");
		for(int i=0;i<listArray.size();i++){
			listPrevision.add( this.elaborateForecastInformation((JSONObject)listArray.get(i),requestCity ) );
		}

		forecastResponse.setListForecastWeather(listPrevision);
		return forecastResponse;	
	}

	@Override
	public APICurrentResponse decodeCurrentWeatherResponse(JSONObject responseObject) {
		APICurrentResponse response=new APICurrentResponse();
		WeatherData elaborateWeatherInformation = elaborateWeatherInformation(responseObject);
		
		List<WeatherData> list=new ArrayList<>();
		list.add(elaborateWeatherInformation);
		response.setListForecastWeather(list);
		
		return response;
	}

	
	@Override
	public APICurrentResponse decodeCurrentWeatherGroupResponse(JSONObject responseObject) {

		APICurrentResponse response=new APICurrentResponse();

		List<WeatherData> currentListWeather=new ArrayList<>();
		JSONArray listArray=(JSONArray) responseObject.get("list");
		for(int i=0;i<listArray.size();i++){
			currentListWeather.add( this.elaborateWeatherInformation((JSONObject)listArray.get(i)) );
		}
		//TODO why response not return code??? for now i set it.. after we will see...
		response.setRequestCode(200);
		response.setListForecastWeather(currentListWeather);
		return response;
	}
	
	
	//TODO check how handle the city: now we just get it from the response, 
	//but maybe can be necessary to retrive it from DB to have additional info
	private WeatherData elaborateWeatherInformation(JSONObject object) {
	
		WeatherData weatherData=new WeatherData();
		weatherData.setMainTemperature(decodeMainObject((JSONObject) object.get("main")) );
		weatherData.setWeather(decodeWeatherObject((JSONArray) object.get("weather")) );
		weatherData.setClouds(decodeSimpleObjectHinnerValue((JSONObject)object.get("clouds"), "all"));
		weatherData.setWind(decodeWindObject((JSONObject) object.get("wind")));
		weatherData.setRain(decodeSimpleObjectHinnerValue((JSONObject) object.get("rain"),"3h") );
		weatherData.setSnow(decodeSimpleObjectHinnerValue((JSONObject) object.get("snow"),"3h") );
		weatherData.setDateTimeCalulation( decodeDateTime((Long)object.get("dt")) );
		Long cityID=(Long)object.get("id");
		String cityName=(String)object.get("name");
		weatherData.setCity(new City(cityID, cityName, null, null, null));
		return weatherData;
	}

	private WeatherForecastData elaborateForecastInformation(JSONObject object,City city) {
		

		WeatherData weather = this.elaborateWeatherInformation(object);		
		WeatherForecastData forecast=new WeatherForecastData(
				weather.getDateTimeCalulation(), 
				weather.getMainTemperature(), 
				weather.getWeather(), 
				weather.getClouds(), 
				weather.getWind(), 
				weather.getRain(), 
				weather.getSnow(), 
				city,
				new Date(),		//storing time
				//TODO change it whit thew others dt-****???
				decodeDateTimeStringFormat((String)object.get("dt_txt"))
		);
				 
		return forecast;
	}

	private Wind decodeWindObject(JSONObject jsonObject) {
		if(jsonObject==null){
			return null;
		}
		Wind wind=new Wind();
		wind.setSpeed(castNumericValueToFloat(jsonObject.get("speed")));
		wind.setDeg(castNumericValueToFloat(jsonObject.get("deg")));
		return wind;
	}


	private Weather decodeWeatherObject(JSONArray jsonArray) {
		if(jsonArray==null || jsonArray.isEmpty()){
			return null;
		}
		//TODO i do not know why return a list, but i keep only the first if exists
		JSONObject jsonObject=(JSONObject) jsonArray.get(0);
		Weather weather=new Weather();
		weather.setId((Long)jsonObject.get("id"));		
		weather.setDescritpion((String)jsonObject.get("description"));
		weather.setMain((String)jsonObject.get("main"));
		weather.setIcon((String)jsonObject.get("icon"));
		return weather;
	}


	private MainTemperature decodeMainObject(JSONObject main){
		if(main==null){
			return null;
		}
		MainTemperature mainTemp=new MainTemperature();
		mainTemp.setTemp(castNumericValueToFloat(main.get("temp")));
		mainTemp.setTempMin(castNumericValueToFloat(main.get("temp_min")));
		mainTemp.setTempMax(castNumericValueToFloat(main.get("temp_max")));
		mainTemp.setPressure(castNumericValueToFloat(main.get("pressure")));
		mainTemp.setSeaLevel(castNumericValueToFloat(main.get("sea_level")));
		mainTemp.setGrndLevel(castNumericValueToFloat(main.get("grnd_level")));
		mainTemp.setHumidity(castNumericValueToFloat(main.get("humidity")));
		mainTemp.setTempKf(castNumericValueToFloat(main.get("temp_kf")));
		
		return mainTemp;
	}
	
	
	private City decodeCity(JSONObject object){
		City city=new City();
		city.setId((Long)object.get("id"));
		city.setName((String)object.get("name"));
		return city;
	}

	//********************	GENERAL	*******************
	
	/**
	 * the same vlaue can be an integer or float so we have to handle this whit this method, 
	 * in general to make everythings works we decide to use only float
	 * @param numericValue
	 * @return
	 */
	private Float castNumericValueToFloat(Object numericValue){
		if(numericValue==null){
			return null;
		}
		if(numericValue.getClass().equals(Long.class)){
			return ((Long)numericValue).floatValue();
		}
		if(numericValue.getClass().equals(Double.class)){
			return ((Double)numericValue).floatValue();
		}
		
		return null;
	}
	
	private Date decodeDateTime(Long utcDateTime){
		if(utcDateTime==null){
			return null;
		}
		return Date.from( Instant.ofEpochSecond (utcDateTime) );
	}
	
	private Float decodeSimpleObjectHinnerValue(JSONObject jsonObject,String hinnerValue) {
		if(jsonObject==null){
			return null;
		}
		return castNumericValueToFloat(jsonObject.get(hinnerValue));
	}

	private Date decodeDateTimeStringFormat(String string) {
		if(string== null){
			return null;
		}
		try {
			return forecastDateTimeCalulationFormatter.parse(string);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}

	}


}
