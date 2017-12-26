package it.unical.asde.weather.core.services.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.unical.asde.weather.dao.user.UserDao;
import it.unical.asde.weather.model.bean.comunication.response.GenericResponse;
import it.unical.asde.weather.model.bean.comunication.response.GenericResponse.ErrorCode;
import it.unical.asde.weather.model.bean.comunication.response.GenericResponse.Status;
import it.unical.asde.weather.model.bean.user.User;
import it.unical.asde.weather.model.bean.user.UserDetailsImp;
import it.unical.asde.weather.model.exception.ASDECustomException;

@Service
public class UserServiceImp implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public User getUserByUsername(String username) {		
		return userDao.findUserByUsername(username);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return new UserDetailsImp(getUserByUsername(username));
		
	}

	//TODO check different isolation level
	@Override
	@Transactional(isolation=Isolation.SERIALIZABLE,propagation=Propagation.REQUIRES_NEW)
	public User registerNewUser(User newUser) throws ASDECustomException{
		
		if(!isUserValid(newUser)){
			throw new ASDECustomException(null, ErrorCode.WRONG_INPUT, null);
		}

		checkFreeUsernameAndEmail(newUser.getUsername(), newUser.getEmail());
		
		newUser.setPassword(new BCryptPasswordEncoder().encode(newUser.getPassword()));
		userDao.save(newUser);
		
		return newUser;
	}

	
	private boolean isUserValid(User newUser) {
		if(
				newUser.getEmail()==null || newUser.getEmail().isEmpty() ||
				newUser.getUsername()==null || newUser.getUsername().isEmpty() ||
				newUser.getPassword()==null || newUser.getPassword().isEmpty() ||
				newUser.getFirstName()==null || newUser.getFirstName().isEmpty() ||
				newUser.getLastName()==null || newUser.getLastName().isEmpty() 
		){
			return false;
		}else{
			return true;
		}
		
	}
	

	private boolean checkFreeUsernameAndEmail(String username,String email) throws ASDECustomException{
		List<User> usersWhitUsernameOrEmail = userDao.usersWhitUsernameOrEmail(username, email);
		if(usersWhitUsernameOrEmail.isEmpty()){
			return true;
		}else{
			boolean usernameUsed=false;
			boolean emailUsed=false;
			for(User user:usersWhitUsernameOrEmail){
				if(user.getUsername().equals(username)){
					usernameUsed=true;
				}
				if(user.getEmail().equals(email)){
					emailUsed=true;
				}
			}
			if(emailUsed && usernameUsed){
				throw new ASDECustomException(null, ErrorCode.USERNAME_AND_EMAIL_USED, null);
			}else{
				if(emailUsed){
					throw new ASDECustomException(null, ErrorCode.EMAIL_USED, null);
				}else{
					throw new ASDECustomException(null, ErrorCode.USERNAME_USED, null);
				}
			}
		}
	}

	
	@Override
	@Transactional(readOnly=true)
	public User getCompleteInfo(User currentUser) throws ASDECustomException {
		if(currentUser==null || currentUser.getId()==null){
			throw new ASDECustomException(null, ErrorCode.NOT_LOGGED_USER, null);
		}		
		User tempUser =userDao.findCompleteUserInfoById(currentUser.getId());
		return tempUser;
	}
}
