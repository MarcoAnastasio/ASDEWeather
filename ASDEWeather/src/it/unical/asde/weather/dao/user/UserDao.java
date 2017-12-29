package it.unical.asde.weather.dao.user;

import java.util.List;

import it.unical.asde.weather.dao.GenericDao;
import it.unical.asde.weather.model.bean.user.User;

public interface UserDao extends GenericDao<User>{

	
	User findUserByUsername(String username);

	List<User> usersWhitUsernameOrEmail(String username,String email);

	User findCompleteUserInfoById(Long id);
	
}
