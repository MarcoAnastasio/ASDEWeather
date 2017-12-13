package it.unical.asde.weather.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class User implements UserDetails{
	
	
	private Long id;
	
	private String username;
	private String password;
	private String userRole;
	
	private String first_name;
	private String last_name;
	private String email;
	
	
	
	public User() {
		id=new Long(10);
	}
	
	
	public User(String username, String password, String userRole) {
		super();
		id=new Long(10);
		this.username = username;
		this.password = password;
		this.userRole = userRole;
	}


	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}


	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", userRole=" + userRole + "]";
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return new ArrayList<GrantedAuthority>(){{add(new SimpleGrantedAuthority(userRole));}};
	}


	@Override
	public boolean isAccountNonExpired() {
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}


	@Override
	public boolean isEnabled() {
		return true;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	
	
}
