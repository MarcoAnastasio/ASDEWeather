package it.unical.asde.weather.controller.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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



//this controller was used for testing the security filter chain,
//maybe we will need in the future
//please not remove it 
@Controller
public class TestAuthController {

	
	@RequestMapping(value = "/api/testGET", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity testGET() {
    	
    	System.out.println("testGetDone");
    	showCurrentUser();
    	return new ResponseEntity<>(HttpStatus.OK);
    }
	
	@RequestMapping(value = "/api/auth/testGET", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity testAuthGET() {
    	
    	System.out.println("testAuthGet Done");
    	showCurrentUser();
    	return new ResponseEntity<>(HttpStatus.OK);
    }
	
	@RequestMapping(value = "/api/testPOST", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity testPost(@RequestBody RequestSingleCity request) {
    	
    	System.out.println("testPOST Done\t"+request);
    	showCurrentUser();
    	return new ResponseEntity<>(HttpStatus.OK);
    }
	

	@RequestMapping(value = "/api/auth/testPOST", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity testAuthPOST(@RequestBody RequestSingleCity request) {
    	
    	System.out.println("testAuthPOST Done");
    	showCurrentUser();
    	return new ResponseEntity<>(HttpStatus.OK);
    }

	
	private void showCurrentUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("auth_user="+authentication.getPrincipal());
	}
	
	
	
}