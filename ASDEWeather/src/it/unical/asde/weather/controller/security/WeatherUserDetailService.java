package it.unical.asde.weather.controller.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import it.unical.asde.weather.core.UserService;
import it.unical.asde.weather.model.User;

@Service
public class WeatherUserDetailService implements UserDetailsService{

	
	@Autowired
	UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		System.out.println("looking for user whit username="+username);
		
		User userFromUsername = userService.getUserFromUsername(username);
	
		
		return userFromUsername; 
//		return new User(userFromUsername.getUsername(),userFromUsername.getPassword(),getAuthorities(userFromUsername.getUserRole()));

	}
	

}
