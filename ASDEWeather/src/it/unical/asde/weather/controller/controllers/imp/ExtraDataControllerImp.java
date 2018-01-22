package it.unical.asde.weather.controller.controllers.imp;

import it.unical.asde.weather.controller.controllers.ExtraDataController;
import it.unical.asde.weather.core.services.data.dataprovider.ExtraDataProvider;
import it.unical.asde.weather.model.bean.comunication.request.RequestSingleCity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


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
