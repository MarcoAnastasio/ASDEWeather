package it.unical.asde.weather.controller.controllers;

import it.unical.asde.weather.model.bean.comunication.response.GenericResponse;
import it.unical.asde.weather.model.bean.user.User;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserApiController {

	/**
	 * URL: /api/user/registration
	 * 
	 * request for register new user, minimum requied information: 
	 * 		username, password, firstName, lastName,email
	 * can return few errors:
	 * 	WRONG_INPUT, USERNAME_USED, EMAIL_USED, USERNAME_AND_EMAIL_USED
	 * @param newUser
	 * @return
	 */
	GenericResponse registerUser(User newUser);

	/**
	 * URL:  /api/auth/user/showUser
	 * return the complete info for user, complete info mean all information about user entity and also 
	 * the list of prefered cities
	 * 
	 * @return
	 */
	GenericResponse getUserInfo();
	
	
	/**
	 * URL: /api/auth/user/updateUser
	 * 
	 * user must be authenticated, logged
	 * request for update user info, id,email and username can not be changed,
	 * is possible to add new cities as prefered, or remove some from it.
	 * 
	 * Possible rorrors: WRONG_INPUT, NOT_LOGGED_USER
	 * 
	 * @param request
	 * @return
	 */
	GenericResponse updateUser(User request);

	
	/**
	 * this method is call for validate user credentials and also return a big DTO whit 
	 * all the information to display in the homepage, this info inclued:
	 * -user bean and prefered cities,
	 * -for eatch prefered city the current wheater
	 * -eventualy also a list of notification
	 * 
	 * @return
	 */
	GenericResponse login();

	
	
	/**
	 * eatch Xtime (something like 1 h) the client have to call this methods,
	 * to verify eventualy notifications
	 * @return
	 */
	GenericResponse getNotifications();

	
	
	
	
}
