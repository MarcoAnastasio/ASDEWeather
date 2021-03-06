package it.unical.asde.weather.controller.controllers;

import it.unical.asde.weather.core.services.user.UserService;
import it.unical.asde.weather.model.bean.comunication.request.RequestSingleCity;
import it.unical.asde.weather.model.bean.user.User;
import it.unical.asde.weather.model.bean.user.UserDetailsImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



//this controller was used for testing the security filter chain,
//maybe we will need in the future
//please not remove it 
@Controller
public class TestAuthController {

	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "/api/testGET", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity testGET() {
    	
    	System.out.println("testGetDone");
    	showCurrentUser();
    	return new ResponseEntity<>(HttpStatus.OK);
    }
	
	@RequestMapping(value = "/api/auth/testGET", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity testAuthGET() {
    	
    	System.out.println("testAuthGet Done");
    	showCurrentUser();
    	return new ResponseEntity<>(HttpStatus.OK);
    }
	
	@RequestMapping(value = "/api/testPOST", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity testPost(@RequestBody RequestSingleCity request) {
    	
    	System.out.println("testPOST Done\t"+request);
    	showCurrentUser();
    	return new ResponseEntity<>(HttpStatus.OK);
    }
	

	@RequestMapping(value = "/api/auth/testPOST", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity testAuthPOST(@RequestBody RequestSingleCity request) {
    	System.out.println("testAuthPOST Done");
    	showCurrentUser();
    	return new ResponseEntity<>(HttpStatus.OK);
    }

	
	private void showCurrentUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user=((UserDetailsImp)authentication.getPrincipal()).getUser();
		System.out.println("auth_user="+user);
	}
	
	
	@RequestMapping(value = "/api/testDAO")
	@Transactional
	private @ResponseBody ResponseEntity useCountryDao(){
		System.out.println("/api/testDAO DONE");
		
		userService.getUserByUsername("ciccio");
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	

}
