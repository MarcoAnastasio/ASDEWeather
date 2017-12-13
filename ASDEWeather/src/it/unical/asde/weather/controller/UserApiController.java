package it.unical.asde.weather.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import it.unical.asde.weather.model.User;

@Controller
public class UserApiController {


	
	 @RequestMapping(value = "/api/showUser", method = RequestMethod.GET)
	    public @ResponseBody ResponseEntity<?> showUSer() {
	    	
	    	Object ob = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    	
	    	User temp=(User)ob;
	    	
	    	return new ResponseEntity<>( temp, HttpStatus.OK);
	    }
	 
	 
	 @RequestMapping(value = "/registration", method = RequestMethod.POST)
	    public @ResponseBody ResponseEntity<?> registerUser(@RequestBody User newUser) {
	    	
		 System.out.println(newUser);
		 
	    	return new ResponseEntity<>( HttpStatus.OK);
	    }
	 
}
