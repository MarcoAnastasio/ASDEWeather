package it.unical.asde.weather.controller.controllers;

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

import it.unical.asde.weather.core.UserService;
import it.unical.asde.weather.core.services.GeneralService;
import it.unical.asde.weather.core.services.dataprovider.WeatherDataProvider;
import it.unical.asde.weather.dao.OldStaticCityDao;
import it.unical.asde.weather.model.bean.comunication.request.RequestCityNameSubstring;
import it.unical.asde.weather.model.bean.comunication.request.RequestGeolocation;
import it.unical.asde.weather.model.bean.comunication.request.RequestSingleCity;
import it.unical.asde.weather.model.bean.user.User;
import it.unical.asde.weather.core.utilities.JsonReader;


@Controller
public class IndexController extends GenericController{

	@Autowired
	private OldStaticCityDao cityDao;
	
	@Autowired
	private GeneralService generalService;

	
	@RequestMapping("/")
	public String index(Model model) {

		System.out.println("index");
		
		
		model.addAttribute("listCities",cityDao.getRandomCities());
		return "index";
	}
	
	
	/**
	 * this method is call as soon as possible when index age is loaded, 
	 * and pass the current latitude and longitude, it will return a list of 
	 * current weather from random cities and the current weather of the user location
	 * 
	 * @param request
	 * @return
	 */
    @RequestMapping(value = "/api/weather/indexRequest", method = RequestMethod.POST,consumes="application/json")
	public @ResponseBody Object getForecastWeatherByCity(@RequestBody RequestGeolocation request) {

    	
    	try{
			return fillCorrectGenericResponse(request, generalService.getIndexInfo(request));
		}catch (Exception e) {
			return fillWrongGenericResponse(e, request);
		}
	}
	

    
    
    @RequestMapping(value = "/api/commons/cityByNameSubstring", method = RequestMethod.POST,consumes="application/json")
	public @ResponseBody Object getForecastWeatherByCity(@RequestBody RequestCityNameSubstring request) {
    	try{
			return fillCorrectGenericResponse(request, generalService.getCityByNameSubstring(request));
		}catch (Exception e) {
			return fillWrongGenericResponse(e, request);
		}
	}
    
    
	//TODO test rest
	@RequestMapping("/weather")
	public ResponseEntity<String> weather() {
		System.out.println("IN weather mapping");
		String returnJson = "{\"Status\":\"Error\", \"Data\":\"null\"}";
		
		ArrayList<String> cities = new ArrayList<String>();
		cities.add("London");
		cities.add("Rome");
		cities.add("Milan");
		cities.add("New York");
		cities.add("Addis Ababa");
		
		JsonReader jr = new JsonReader();
	    JSONObject json= new JSONObject();
	    Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
	  
		try {

			ArrayList<Map<String, Object>> forcastWeek = new ArrayList<Map<String, Object>>();

			for (String city : cities) {
				json = jr.readJsonFromUrl("http://api.openweathermap.org/data/2.5/forecast?q=" + city + "&appid=f803237aaa82cface910b58b8a93942b" + "&units=metric");
				Map<String, Object> map = gson.fromJson(json.toString(), new TypeToken<Map<String, Object>>() {
				}.getType());
				forcastWeek.add(map);

			}
			
			//
			returnJson = "{\"status\":\"done\", \"data\":" + gson.toJson(forcastWeek) + "}";
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(gson.toJson(returnJson));
		
		HttpHeaders responseHeader = new HttpHeaders();
		responseHeader.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<String>(returnJson, responseHeader, HttpStatus.CREATED);
		
	}
	
	
	/*
	@RequestMapping("/auth/")
	public String authHome(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("in auth/home   "+authentication.getPrincipal());
		return "home";
	}
	
	

    @PostMapping(value = "/registration", consumes="application/json")
    public String registration(@RequestBody User newUser) {	
    
    	System.out.println("current user received="+newUser);
    	
    	newUser.setPassword(passwordEncoder().encode(newUser.getPassword()));
    	System.out.println("password="+newUser.getPassword());
        userService.addUser(newUser );

        return "OK";
    }
	
    
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity registration() {
    	
    	return new ResponseEntity<>(new User("ciccio", "ciccio", "user"), HttpStatus.OK);
    }
    
    
    
    
    
    @RequestMapping(value = "/auth/showUser", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<?> showUSer() {
    	
    	Object ob = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	
    	User temp=(User)ob;
    	
    	return new ResponseEntity<>( temp, HttpStatus.OK);
    }
    */
}
