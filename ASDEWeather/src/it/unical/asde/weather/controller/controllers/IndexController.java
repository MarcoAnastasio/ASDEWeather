package it.unical.asde.weather.controller.controllers;

import it.unical.asde.weather.model.bean.comunication.request.RequestCityNameSubstring;
import it.unical.asde.weather.model.bean.comunication.request.RequestGeolocation;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public interface IndexController {

	
	
	/**
	 * this methods return the first main page of the application
	 * @param model
	 * @return
	 */
	public String index(Model model);

	/**
	 * this method is call as soon as possible when index age is loaded, 
	 * and pass the current latitude and longitude, it will return a list of 
	 * current weather from random cities and the current weather of the user location
	 * 
	 * @param request
	 * @return
	 */
	public Object indexRequest(RequestGeolocation request);
	
	/**
	 * return 5 random cities and the associates weather
	 * @return
	 */
	public Object getRandomCities();

	/**
	 * this method is call during the search of a city by name
	 * @param request
	 * @return
	 */
	public Object getCityBySubname(RequestCityNameSubstring request);

}