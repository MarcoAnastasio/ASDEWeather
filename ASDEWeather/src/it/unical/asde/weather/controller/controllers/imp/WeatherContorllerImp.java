package it.unical.asde.weather.controller.controllers.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import it.unical.asde.weather.controller.controllers.WeatherContorller;
import it.unical.asde.weather.core.services.WeatherDataProvider;
import it.unical.asde.weather.model.bean.comunication.request.RequestListCities;
import it.unical.asde.weather.model.bean.comunication.request.RequestSingleCity;

//@Controller(value="/api/weather")
@Controller
public class WeatherContorllerImp implements WeatherContorller{

	
	@Autowired
	private WeatherDataProvider weatherDataProvider;
	
	
	@Override
    @RequestMapping(value = "/api/weather/currentWeatherByCity", method = RequestMethod.POST,consumes="application/json")
	public @ResponseBody Object getCurrentWeatherByCity(@RequestBody RequestSingleCity request) {
		return weatherDataProvider.getCurrentWeatherByCity(request);
	}

	@Override
    @RequestMapping(value = "/api/weather/currentWeatherByCities", method = RequestMethod.POST,consumes="application/json")
	public @ResponseBody Object getCurrentWeatherByCities(@RequestBody RequestListCities request) {		
		return weatherDataProvider.getCurrentWeatherByCities(request);
	}

	@Override
    @RequestMapping(value = "/api/weather/forecastWeatherByCity", method = RequestMethod.POST,consumes="application/json")
	public @ResponseBody Object getForecastWeatherByCity(@RequestBody RequestSingleCity request) {
		return weatherDataProvider.getForecastWeatherByCity(request);
	}

}