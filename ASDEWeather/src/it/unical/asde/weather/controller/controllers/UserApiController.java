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
	 * URL: /api/auth/user/updateUser
	 * 
	 * user must be authenticated, logged
	 * request for update user info, id,email and username can not be changed,
	 * is possible to add new cities as prefered, or remove some from it.
	 * @param request
	 * @return
	 */
	GenericResponse updateUserUser(User request);
	
	
	
}
