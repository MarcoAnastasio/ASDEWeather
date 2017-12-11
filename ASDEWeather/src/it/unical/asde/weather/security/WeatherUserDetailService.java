package it.unical.asde.weather.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import it.unical.asde.weather.core.UserService;

@Service
public class WeatherUserDetailService implements UserDetailsService{

	
	@Autowired
	UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		System.out.println("looking for user whit username="+username);
		
		it.unical.asde.weather.model.User userFromUsername = userService.getUserFromUsername(username);
	
		User returnUser=new User(userFromUsername.getUsername(),userFromUsername.getPassword(),getAuthorities(userFromUsername.getUserRole()));;
		
		return returnUser; 
//		return new User(userFromUsername.getUsername(),userFromUsername.getPassword(),getAuthorities(userFromUsername.getUserRole()));

	}
	
	
	private Collection<GrantedAuthority> getAuthorities(String userRole) {
	    List<GrantedAuthority> authList = new ArrayList<>();
	    authList.add(new SimpleGrantedAuthority(userRole));
	    return authList;
	}
}
