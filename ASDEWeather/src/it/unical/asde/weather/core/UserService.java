package it.unical.asde.weather.core;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import it.unical.asde.weather.model.User;

@Service
public class UserService {

	private static List<User> users=new ArrayList<>();
	
	@PostConstruct
	private void init() {
		//psw=ciccio
		users.add(new User("ciccio", "$2a$10$Vg7o.6MLz6NWOnsGlY16T..B7bWY5ybBco9IRGokOx.kMiuN7tL/e", "ROLE_USER"));
	}

	public User getUserFromUsername(String username){

		
		for(User user:users) {
			if(user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
	}
	
	public void addUser(User user) {
		users.add(user);
	}
	
}