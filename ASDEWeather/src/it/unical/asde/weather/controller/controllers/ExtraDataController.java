package it.unical.asde.weather.controller.controllers;

import it.unical.asde.weather.model.bean.comunication.request.RequestSingleCity;

public interface ExtraDataController {

	
	public Object getCurrentUVByCity(RequestSingleCity request);
			

}
