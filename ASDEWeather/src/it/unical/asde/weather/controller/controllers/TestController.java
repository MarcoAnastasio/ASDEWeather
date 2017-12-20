package it.unical.asde.weather.controller.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import it.unical.asde.weather.dao.CityDao;
import it.unical.asde.weather.model.api.response.APICurrentResponse;
import it.unical.asde.weather.model.api.response.APIForecastResponse;
import it.unical.asde.weather.model.bean.comunication.request.RequestSingleCity;
import it.unical.asde.weather.model.bean.comunication.request.RequestListCities;
import it.unical.asde.weather.model.bean.geographical.City;
import it.unical.asde.weather.model.bean.weather.WeatherData;
import it.unical.asde.weather.model.bean.weather.WeatherForecastData;




@Controller
public class TestController {


	
	@Autowired
	private CityDao cityDao;
	
	/*
    @RequestMapping(value = "/api/test", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity registration() {
    	
    	
    	APIForecastResponse weatherForecastforCityFromAPI = 
    			weatherDataRequestexecutor.getWeatherForecastforCityFromAPI(new City(new Long(2524907), "Cosenza",new Double(16.250191), new Double(16.250191),null));
    	
    	
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
    	
    	APIForecastResponse weatherForecastforCityFromAPI = weatherDataRequestexecutor.getWeatherForecastforCityFromAPI(cityFromName);
    	
  
//    	weatherDataUpdate.getWeatherforCityFromAPI(new City(3418910, "Upernavik",new Double(16.250191), new Double(16.250191),null));
    	
    	return new ResponseEntity<>(weatherForecastforCityFromAPI,HttpStatus.OK);
    }
    
    
    @RequestMapping(value = "/api/test3", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity test3() {
    	
    	City cityFromName = new City(new Long(2524907), "Cosenza",new Double(16.250191), new Double(16.250191),null);


    	APIForecastResponse weatherForecastforCityFromAPI = weatherDataRequestexecutor.getWeatherForecastforCityFromAPI(cityFromName);
    	
  
//    	weatherDataUpdate.getWeatherforCityFromAPI(new City(3418910, "Upernavik",new Double(16.250191), new Double(16.250191),null));
    	
    	return new ResponseEntity<>(weatherForecastforCityFromAPI,HttpStatus.OK);
    }
	
    
    
    @RequestMapping(value = "/api/test4", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity test4() {

    	City cityFromName = new City(new Long(2524907), "Cosenza",new Double(16.250191), new Double(16.250191),null);
    	City cityFromName1 = new City(new Long(2523630), "Reggio Calabria",new Double(16.250191), new Double(16.250191),null);

    	List<City> citiesList=new ArrayList<>();
    	citiesList.add(cityFromName1);
    	citiesList.add(cityFromName);
    	
//    	Object crrentForecastforCityFromAPI = weatherDataRequestexecutor.getCurrentWeatherforCityFromAPI(cityFromName);
    	APICurrentResponse crrentForecastforCityListFromAPI = weatherDataRequestexecutor.getCurrentWeatherforCityListFromAPI(citiesList);;
    	
    	
    	return new ResponseEntity<>(crrentForecastforCityListFromAPI,HttpStatus.OK);
    	
//      	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
    @RequestMapping(value = "/api/test5", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity test5() {

    	City cityFromName = new City(new Long(2524907), "Cosenza",new Double(16.250191), new Double(16.250191),null);
    	City cityFromName1 = new City(new Long(2523630), "Reggio Calabria",new Double(16.250191), new Double(16.250191),null);

    	List<City> citiesList=new ArrayList<>();
    	citiesList.add(cityFromName1);
    	
//    	Object crrentForecastforCityFromAPI = weatherDataRequestexecutor.getCurrentWeatherforCityFromAPI(cityFromName);
    	APICurrentResponse crrentForecastforCityListFromAPI = weatherDataRequestexecutor.getCurrentWeatherforCityListFromAPI(citiesList);;
    	
    	
    	return new ResponseEntity<>(crrentForecastforCityListFromAPI,HttpStatus.OK);
    	
//      	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
    @RequestMapping(value = "/api/testSingleCity", method = RequestMethod.POST, consumes ="application/json")
    public @ResponseBody ResponseEntity testSingleCity(@RequestBody RequestSingleCity singleCityRequest) {
    	
    	List<City> citiesList=new ArrayList<>();
    	citiesList.add(new City(singleCityRequest.getCityId(),singleCityRequest.getCityName(),null,null,null));
    	
//    	Object crrentForecastforCityFromAPI = weatherDataRequestexecutor.getCurrentWeatherforCityFromAPI(cityFromName);
    	APICurrentResponse crrentForecastforCityListFromAPI = weatherDataRequestexecutor.getCurrentWeatherforCityListFromAPI(citiesList);;
    	
    	
    	return new ResponseEntity<>(crrentForecastforCityListFromAPI,HttpStatus.OK);
    	
//      	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    */
}
