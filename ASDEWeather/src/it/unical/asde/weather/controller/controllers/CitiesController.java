package it.unical.asde.weather.controller.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

public class CitiesController {

	@RequestMapping("/seachCity")
	public String search() {
		return "otherCities";
	}
}
