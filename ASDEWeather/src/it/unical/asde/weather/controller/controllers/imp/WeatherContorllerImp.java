package it.unical.asde.weather.controller.controllers.imp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import it.unical.asde.weather.controller.controllers.GenericController;
import it.unical.asde.weather.controller.controllers.WeatherContorller;
import it.unical.asde.weather.core.services.dataprovider.WeatherDataProvider;
import it.unical.asde.weather.model.bean.comunication.request.RequestGeolocation;
import it.unical.asde.weather.model.bean.comunication.request.RequestListCities;
import it.unical.asde.weather.model.bean.comunication.request.RequestSingleCity;

//@Controller(value="/api/weather")
@Controller
public class WeatherContorllerImp extends GenericController implements WeatherContorller{

	
	@Autowired
	private WeatherDataProvider weatherDataProvider;
	
	
	@Override
    @RequestMapping(value = "/api/weather/currentWeatherByCity", method = RequestMethod.POST,consumes="application/json")
	public @ResponseBody Object getCurrentWeatherByCity(@RequestBody RequestSingleCity request,HttpServletRequest httpRequest) {
		
		System.out.println(httpRequest.getRemoteAddr());
		
		try{
			return fillCorrectGenericResponse(request, weatherDataProvider.getCurrentWeatherByCity(request));
		}catch (Exception e) {
			return fillWrongGenericResponse(e, request);
		}
	}

	@Override
    @RequestMapping(value = "/api/weather/currentWeatherByCities", method = RequestMethod.POST,consumes="application/json")
	public @ResponseBody Object getCurrentWeatherByCities(@RequestBody RequestListCities request) {	
		try{
			return fillCorrectGenericResponse(request, weatherDataProvider.getCurrentWeatherByCities(request));
		}catch (Exception e) {
			return fillWrongGenericResponse(e, request);
		}
	}

	@Override
    @RequestMapping(value = "/api/weather/forecastWeatherByCity", method = RequestMethod.POST,consumes="application/json;charset=utf-8")
	public @ResponseBody Object getForecastWeatherByCity(@RequestBody RequestSingleCity request) {
		try{
			System.out.println("In forcast");
			return fillCorrectGenericResponse(request, weatherDataProvider.getForecastWeatherByCity(request));
		}catch (Exception e) {
			return fillWrongGenericResponse(e, request);
		}
	}

	@Override
    @RequestMapping(value = "/api/weather/currentWeatherByCoords", method = RequestMethod.POST,consumes="application/json")
	public @ResponseBody Object  getCurrentWeatherByCoords(@RequestBody RequestGeolocation request) {
		try{
			return fillCorrectGenericResponse(request, weatherDataProvider.getCurrentWeatherByCoords(request));
		}catch (Exception e) {
			return fillWrongGenericResponse(e, request);
		}
	}
	
	
	@Override
    @RequestMapping(value = "/api/weather/forecastWeatherAndUVByCity", method = RequestMethod.POST,consumes="application/json")
	public @ResponseBody Object  getForecastWeatherAndUVByCity(@RequestBody RequestSingleCity request) {
		try{
			return fillCorrectGenericResponse(request, weatherDataProvider.getForecastWeatherAndUvByCity(request));
		}catch (Exception e) {
			return fillWrongGenericResponse(e, request);
		}
	}

}
