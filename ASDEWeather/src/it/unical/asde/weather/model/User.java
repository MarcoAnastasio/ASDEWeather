package it.unical.asde.weather.model;


public class User{
	
		
	private String username;
	private String password;
	private String userRole;
	
	public User() {
		
	}
	
	
	public User(String username, String password, String userRole) {
		super();
		this.username = username;
		this.password = password;
		this.userRole = userRole;
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

	
	
}
