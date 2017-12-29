package it.unical.asde.weather.model.bean.user;

import it.unical.asde.weather.model.bean.geographical.City;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Entity
@Table
//hide password when return the bean User
@JsonIgnoreProperties(value="password",allowSetters=true,allowGetters=false)
public class User implements Serializable{
	
	private static final long serialVersionUID = 7388373041201405285L;

	protected static final String USER_ROLE = "ROLE_USER";


	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable=false,unique=true)
	private String username;

	@Column(nullable=false)
	private String password;
	@Column(nullable=false)
	private String firstName;
	@Column(nullable=false)
	private String lastName;
	@Column(nullable=false)
	private String email;
	
	@ManyToMany(fetch=FetchType.LAZY)
	private List<City> preferedCities;
	
	
	public User() {
		super();
	}
	
	

	public User(Long id, String username, String password, String firstName,
			String lastName, String email, List<City> preferedCities) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.preferedCities = preferedCities;
	}



	public User(User user) {
		this.id = user.id;
		this.username = user.username;
		this.password = user.password;
		this.firstName = user.firstName;
		this.lastName = user.lastName;
		this.email = user.email;
		this.preferedCities = user.preferedCities;
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



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public List<City> getPreferedCities() {
		return preferedCities;
	}



	public void setPreferedCities(List<City> preferedCities) {
		this.preferedCities = preferedCities;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", preferedCities= NOT_FETCHED]";
	}
	
	
	
	
}
