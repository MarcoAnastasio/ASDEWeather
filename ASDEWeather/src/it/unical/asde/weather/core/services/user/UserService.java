package it.unical.asde.weather.core.services.user;

import java.util.List;

import it.unical.asde.weather.dao.user.UserDao;
import it.unical.asde.weather.model.bean.comunication.response.GenericResponse;
import it.unical.asde.weather.model.bean.comunication.response.LoginResponseDTO;
import it.unical.asde.weather.model.bean.user.Notification;
import it.unical.asde.weather.model.bean.user.User;
import it.unical.asde.weather.model.exception.ASDECustomException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

public interface UserService extends UserDetailsService{

	User getUserByUsername(String username);

	User registerNewUser(User newUser) throws ASDECustomException;

	/**
	 * starting from an user , retrive all informatio (example prefered cities)
	 * @param currentUser
	 * @return
	 * @throws ASDECustomException
	 */
	User getCompleteInfo(User currentUser) throws ASDECustomException;

	
	/**
	 * update informatotion about user (id,username and password can not be changed)
	 * will be changed firstName, lastNAme,email
	 * @param currentUser
	 * @return
	 * @throws ASDECustomException
	 */
	User updateUser(User currentUser,User newValues) throws ASDECustomException;

	/**
	 * after submission of user's credentials system has to display all information for user, 
	 * like user info, current weather in preferedCities, and also notifications
	 * @param currentLoggedUser
	 * @return
	 */
	LoginResponseDTO login(User currentLoggedUser);

	
	/**
	 * check if for eatch prefered city of the user exists a forecast whit the weather type extreme
	 * @param currentLoggedUser
	 * @return
	 * @throws ASDECustomException 
	 */
	List<Notification> getNotifications(User currentLoggedUser) throws ASDECustomException;
	
}
