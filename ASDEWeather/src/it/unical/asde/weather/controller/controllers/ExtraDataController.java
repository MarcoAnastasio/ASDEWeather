package it.unical.asde.weather.controller.controllers;

import it.unical.asde.weather.model.bean.comunication.request.RequestGeolocation;
import it.unical.asde.weather.model.bean.comunication.request.RequestListCities;
import it.unical.asde.weather.model.bean.comunication.request.RequestSingleCity;

import javax.servlet.http.HttpServletRequest;

public interface ExtraDataController {

	
	public Object getCurrentUVByCity(RequestSingleCity request);
			

}
