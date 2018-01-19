package it.unical.asde.weather.controller.controllers.imp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import it.unical.asde.weather.controller.controllers.IndexController;
import it.unical.asde.weather.core.UserService;
import it.unical.asde.weather.core.services.GeneralService;
import it.unical.asde.weather.core.services.data.dataprovider.WeatherDataProvider;
import it.unical.asde.weather.dao.OldStaticCityDao;
import it.unical.asde.weather.model.bean.comunication.request.RequestCityNameSubstring;
import it.unical.asde.weather.model.bean.comunication.request.RequestGeolocation;
import it.unical.asde.weather.model.bean.comunication.request.RequestSingleCity;
import it.unical.asde.weather.model.bean.user.User;
import it.unical.asde.weather.core.utilities.JsonReader;


@Controller
public class IndexControllerImp extends AbstractGenericController implements IndexController{

	@Autowired
	private OldStaticCityDao cityDao;
	
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
