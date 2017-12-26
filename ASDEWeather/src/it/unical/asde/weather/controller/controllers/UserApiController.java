package it.unical.asde.weather.controller.controllers;

import it.unical.asde.weather.model.bean.comunication.response.GenericResponse;
import it.unical.asde.weather.model.bean.user.User;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserApiController {

	/**
	 * request for register new user, minimum requied information: 
	 * 		username, password, firstName, lastName,email
	 * can return few errors:
	 * 	WRONG_INPUT, USERNAME_USED, EMAIL_USED, USERNAME_AND_EMAIL_USED
	 * @param newUser
	 * @return
	 */
	GenericResponse registerUser(User newUser);
	
	
	
}
