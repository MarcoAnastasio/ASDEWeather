package it.unical.asde.weather.dao.user;

import it.unical.asde.weather.dao.AbstarctGenericDAO;
import it.unical.asde.weather.model.bean.user.User;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDaoImp extends AbstarctGenericDAO<User> implements UserDao{

	
	@Override
	@Transactional(readOnly=true)
	public User findUserByUsername(String username) {
		Session session = getSession();
		return session.createNativeQuery("SELECT * FROM User as u where u.username=:usernameIn", User.class).setParameter("usernameIn",username ).uniqueResult();
	}

	@Override
	@Transactional(readOnly=true)
	public List<User> usersWhitUsernameOrEmail(String username, String email) {
		return getSession().createNativeQuery(
				"SELECT * FROM User as u where u.username=:usernameIn or u.email=:emailIn", User.class)
				.setParameter("usernameIn",username ).setParameter("emailIn", email).list();
	}

	
	@Override
	@Transactional(readOnly=true)
	public User findCompleteUserInfoById(Long id) {
		User uniqueResult = getSession().createQuery(
				"SELECT u FROM User u LEFT JOIN FETCH u.preferedCities c where u.id=:idIn",User.class)
				.setParameter("idIn",id).uniqueResult();
		return uniqueResult;
		
	}

}
