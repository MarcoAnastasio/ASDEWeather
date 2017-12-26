package it.unical.asde.weather.core.services.user;

import it.unical.asde.weather.dao.user.UserDao;
import it.unical.asde.weather.model.bean.comunication.response.GenericResponse;
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

	
	
	
}
