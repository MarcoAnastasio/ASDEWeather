package it.unical.asde.weather.core.services.user;

import java.util.ArrayList;
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
import it.unical.asde.weather.model.bean.geographical.City;
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

	@Override
	@Transactional(readOnly=true)
	public User getCompleteInfo(User currentUser) throws ASDECustomException {
		if(currentUser==null || currentUser.getId()==null){
			throw new ASDECustomException(null, ErrorCode.NOT_LOGGED_USER, null);
		}		
		User tempUser =userDao.findCompleteUserInfoById(currentUser.getId());
		return tempUser;
	}
	
	
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public User updateUser(User currentUser,final User newValues) throws ASDECustomException{
		if(newValues==null || !isUserValid(newValues,false)){
			throw new ASDECustomException(null,ErrorCode.WRONG_INPUT,null);
		}		
		if(currentUser==null || currentUser.getId()!=newValues.getId()){
			throw new ASDECustomException(null,ErrorCode.NOT_LOGGED_USER,null);
		}
	
		currentUser.setFirstName(newValues.getFirstName());
		currentUser.setLastName(newValues.getLastName());
		currentUser.setEmail(newValues.getEmail());
		
		updateDifferenceOnPreferedCities(currentUser,newValues);
		
		userDao.saveOrUpdate(new User(currentUser));
		
		return currentUser;
	}
	
	/**
	 * check if preferedCitiesList is different, so assign the new Values to old Values
	 * @param currentUser
	 * @param newValues
	 */
	private void updateDifferenceOnPreferedCities(User oldValues,User newValues) {
		if(newValues.getPreferedCities()==null || newValues.getPreferedCities().isEmpty()){
			oldValues.setPreferedCities(new ArrayList<>());
			return;
		}		
		oldValues.setPreferedCities(newValues.getPreferedCities());			
	}

	private boolean isUserValid(User newUser) {
		return isUserValid(newUser,true);
	}
	
	/**
	 * this method skeep the password validation if chcekPAssword parameeter is false
	 * @param newUser
	 * @param checkPassword
	 * @return
	 */
	private boolean isUserValid(User newUser,boolean checkPassword) {
		if(
				newUser.getEmail()==null || newUser.getEmail().isEmpty() ||
				newUser.getUsername()==null || newUser.getUsername().isEmpty() ||
				newUser.getFirstName()==null || newUser.getFirstName().isEmpty() ||
				newUser.getLastName()==null || newUser.getLastName().isEmpty() 
		){			
			return false;
		}else{
			if(checkPassword){
				if(newUser.getPassword()==null || newUser.getPassword().isEmpty()){
					return false;
				}
				return true;
			}
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

	
}
