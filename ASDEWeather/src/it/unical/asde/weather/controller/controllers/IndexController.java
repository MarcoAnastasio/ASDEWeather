package it.unical.asde.weather.controller.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.unical.asde.weather.core.UserService;
import it.unical.asde.weather.dao.OldStaticCityDao;
import it.unical.asde.weather.model.bean.user.User;


@Controller
public class IndexController {

	@Autowired
	private OldStaticCityDao cityDao;

	
	@RequestMapping("/")
	public String index(Model model) {

		System.out.println("index");
		
		
		model.addAttribute("listCities",cityDao.getRandomCities());
		return "index";
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
