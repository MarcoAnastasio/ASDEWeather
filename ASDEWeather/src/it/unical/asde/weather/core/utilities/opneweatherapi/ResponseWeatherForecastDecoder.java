package it.unical.asde.weather.core.utilities.opneweatherapi;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import it.unical.asde.weather.model.bean.weather.MainTemperature;
import it.unical.asde.weather.model.bean.weather.Weather;
import it.unical.asde.weather.model.bean.weather.WeatherForecastData;
import it.unical.asde.weather.model.bean.weather.Wind;

@Service
public class ResponseWeatherForecastDecoder {
	
	private static final DateFormat forecastDateTimeCalulationFormatter  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public WeatherForecastData elaborateForecastInformation(JSONObject object) {
		
		WeatherForecastData forecast=new WeatherForecastData();
		forecast.setDateTimeOfForecast(decodeDateTime((Long)object.get("dt")) ); 
		forecast.setMainTemperature(decodeMainObject((JSONObject) object.get("main")) );
		forecast.setWeather(decodeWeatherObject((JSONObject) object.get("main")) );
		forecast.setClouds(decodeSimpleObjectHinnerValue((JSONObject)object.get("clouds"), "all"));
		forecast.setWind(decodeWindObject((JSONObject) object.get("wind")));
		forecast.setRain(decodeSimpleObjectHinnerValue((JSONObject) object.get("rain"),"3h") );
		forecast.setSnow(decodeSimpleObjectHinnerValue((JSONObject) object.get("snow"),"3h") );

		//this date tiem is sent like 2017-12-15 12:00:00
		forecast.setDateTimeCalulation(decodeDateTimeStringFormat( ((String)object.get("dt_txt")) ) );
				 
		return forecast;
	}

	private Wind decodeWindObject(JSONObject jsonObject) {
		if(jsonObject==null){
			return null;
		}
		Wind wind=new Wind();
		wind.setWind(castNumericValueToFloat(jsonObject.get("wind")));
		wind.setDeg(castNumericValueToFloat(jsonObject.get("deg")));
		return wind;
	}


	private Weather decodeWeatherObject(JSONObject jsonObject) {
		if(jsonObject==null){
			return null;
		}
		Weather weather=new Weather();
		weather.setId((Long)jsonObject.get("id"));
		weather.setDescritpion((String)jsonObject.get("descritpion"));
		weather.setMain((String)jsonObject.get("main"));
		weather.setIcon((String)jsonObject.get("icon"));
		return null;
	}


	private MainTemperature decodeMainObject(JSONObject main){
		if(main==null){
			return null;
		}
		MainTemperature mainTemp=new MainTemperature();
		mainTemp.setTemp(castNumericValueToFloat(main.get("temp")));
		mainTemp.setTempMin(castNumericValueToFloat(main.get("temp_min")));
		mainTemp.setTempMax(castNumericValueToFloat(main.get("temp_max")));
		mainTemp.setPressure(castNumericValueToFloat(main.get("preassure")));
		mainTemp.setSeaLevel(castNumericValueToFloat(main.get("sea_level")));
		mainTemp.setGrndLevel(castNumericValueToFloat(main.get("grnd_level")));
		mainTemp.setHumidity(castNumericValueToFloat(main.get("humidity")));
		mainTemp.setTempKf(castNumericValueToFloat(main.get("temp_kf")));
		
		return mainTemp;
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

	
	DateTimeFormatter f = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
}
