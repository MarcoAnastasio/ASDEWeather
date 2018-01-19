package it.unical.asde.weather.controller.controllers.imp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import it.unical.asde.weather.controller.controllers.ExtraDataController;
import it.unical.asde.weather.controller.controllers.WeatherContorller;
import it.unical.asde.weather.core.services.data.dataprovider.ExtraDataProvider;
import it.unical.asde.weather.core.services.data.dataprovider.WeatherDataProvider;
import it.unical.asde.weather.model.bean.comunication.request.RequestGeolocation;
import it.unical.asde.weather.model.bean.comunication.request.RequestListCities;
import it.unical.asde.weather.model.bean.comunication.request.RequestSingleCity;


@Controller
public class ExtraDataControllerImp extends AbstractGenericController implements ExtraDataController{

	@Autowired
	public ExtraDataProvider extraDataProvider;
	
	@Override
    @RequestMapping(value = "/api/extra/currentUVByCity", method = RequestMethod.POST,consumes="application/json")
	public @ResponseBody Object getCurrentUVByCity(@RequestBody RequestSingleCity request) {
				
		try{
			return fillCorrectGenericResponse(request, extraDataProvider.getCurrentUVByCity(request));
		}catch (Exception e) {
			return fillWrongGenericResponse(e, request);
		}
	}
	

	

}
