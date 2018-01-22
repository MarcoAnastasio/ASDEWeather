package it.unical.asde.weather.dao.user;

import it.unical.asde.weather.dao.GenericDao;
import it.unical.asde.weather.model.bean.user.User;

import java.util.List;

public interface UserDao extends GenericDao<User>{

	
	User findUserByUsername(String username);

	List<User> usersWhitUsernameOrEmail(String username,String email);

	User findCompleteUserInfoById(Long id);
	
}
