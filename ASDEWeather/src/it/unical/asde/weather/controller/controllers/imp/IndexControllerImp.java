package it.unical.asde.weather.controller.controllers.imp;

import it.unical.asde.weather.controller.controllers.IndexController;
import it.unical.asde.weather.core.services.GeneralService;
import it.unical.asde.weather.model.bean.comunication.request.RequestCityNameSubstring;
import it.unical.asde.weather.model.bean.comunication.request.RequestGeolocation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class IndexControllerImp extends AbstractGenericController implements IndexController{

	
	@Autowired
	private GeneralService generalService;

	
	@Override
	@RequestMapping("/")
	public String index(Model model) {
		return "index";
	}
	

    @Override
	@RequestMapping(value = "/api/weather/indexRequest", method = RequestMethod.POST,consumes="application/json")
	public @ResponseBody Object indexRequest(@RequestBody RequestGeolocation request) {

    	
    	try{
			return fillCorrectGenericResponse(request, generalService.getIndexInfo(request));
		}catch (Exception e) {
			return fillWrongGenericResponse(e, request);
		}
	}
	
    
    @Override
	@RequestMapping(value = "/api/weather/getRandomCities", method = RequestMethod.GET)
	public @ResponseBody Object getRandomCities() {
    	
    	try{
			return fillCorrectGenericResponse(null, generalService.getRandomCitiesCurrentWeather());
		}catch (Exception e) {
			return fillWrongGenericResponse(e, null);
		}
	}
    
    

    @Override
	@RequestMapping(value = "/api/commons/cityByNameSubstring", method = RequestMethod.POST,consumes="application/json")
	public @ResponseBody Object getCityBySubname(@RequestBody RequestCityNameSubstring request) {
    	try{
			return fillCorrectGenericResponse(request, generalService.getCityByNameSubstring(request));
		}catch (Exception e) {
			return fillWrongGenericResponse(e, request);
		}
	}
    


}
