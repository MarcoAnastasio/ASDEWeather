package it.unical.asde.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import it.unical.asde.weather.core.utilities.WeatherDataUpdate;
import it.unical.asde.weather.model.bean.geographical.City;




@Controller
public class TestController {

	@Autowired
	private WeatherDataUpdate weatherDataUpdate;
	
	
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity registration() {
    	
    	weatherDataUpdate.getWeatherforCityFromAPI(new City(2524907, "Cosenza",new Double(16.250191), new Double(16.250191),null));
    	
    	return new ResponseEntity<>(HttpStatus.OK);
    }
	
	
}
