package it.unical.asde.weather.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import it.unical.asde.weather.core.utilities.WeatherDataRequestexecutor;
import it.unical.asde.weather.dao.CityDao;
import it.unical.asde.weather.model.bean.comunication.request.WeatherForecastByCity;
import it.unical.asde.weather.model.bean.geographical.City;
import it.unical.asde.weather.model.bean.weather.SingleWeatherForecast;




@Controller
public class TestController {

	@Autowired
	private WeatherDataRequestexecutor weatherDataRequestexecutor;

	@Autowired
	private CityDao cityDao;
	
    @RequestMapping(value = "/api/test", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity registration() {
    	
    	
    	List<SingleWeatherForecast> weatherForecastforCityFromAPI = weatherDataRequestexecutor.getWeatherForecastforCityFromAPI(new City(2524907, "Cosenza",new Double(16.250191), new Double(16.250191),null));
    	
    	
    	return new ResponseEntity<>(weatherForecastforCityFromAPI,HttpStatus.OK);
    }
	
    
    @RequestMapping(value = "/api/test2", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity test2(@RequestBody WeatherForecastByCity weatherCity) {
    	
    	System.out.println("city name"+weatherCity.getCityName());
    	City cityFromName = cityDao.getCityFromName(weatherCity.getCityName());
    	
    	System.out.println("city retrived"+cityFromName);
    	if(cityFromName==null){
    		//TODO find a method to ahndle errors
    		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    	
    	List<SingleWeatherForecast> weatherForecastforCityFromAPI = weatherDataRequestexecutor.getWeatherForecastforCityFromAPI(cityFromName);
    	
  
//    	weatherDataUpdate.getWeatherforCityFromAPI(new City(3418910, "Upernavik",new Double(16.250191), new Double(16.250191),null));
    	
    	return new ResponseEntity<>(weatherForecastforCityFromAPI,HttpStatus.OK);
    }
    
    
    @RequestMapping(value = "/api/test3", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity test3(@RequestBody WeatherForecastByCity weatherCity) {
    	
    	System.out.println("city name"+weatherCity.getCityName());
    	
    	City cityFromName = new City(2524907, "Cosenza",new Double(16.250191), new Double(16.250191),null);

    	List<SingleWeatherForecast> weatherForecastforCityFromAPI = weatherDataRequestexecutor.getWeatherForecastforCityFromAPI(cityFromName);
    	
  
//    	weatherDataUpdate.getWeatherforCityFromAPI(new City(3418910, "Upernavik",new Double(16.250191), new Double(16.250191),null));
    	
    	return new ResponseEntity<>(weatherForecastforCityFromAPI,HttpStatus.OK);
    }
	
}
