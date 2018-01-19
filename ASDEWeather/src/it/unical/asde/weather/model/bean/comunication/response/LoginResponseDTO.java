package it.unical.asde.weather.model.bean.comunication.response;

import java.util.List;

import it.unical.asde.weather.model.bean.data.weather.WeatherData;
import it.unical.asde.weather.model.bean.user.User;

public class LoginResponseDTO {

	private User user;
	
	private List<WeatherData> currentWeatherForPreferedCities;
	
	// notification is retrived whit a different services for performances reason
	@Deprecated
	private List<Object> notifications;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<WeatherData> getCurrentWeatherForPreferedCities() {
		return currentWeatherForPreferedCities;
	}

	public void setCurrentWeatherForPreferedCities(
			List<WeatherData> currentWeatherForPreferedCities) {
		this.currentWeatherForPreferedCities = currentWeatherForPreferedCities;
	}

	public List<Object> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Object> notifications) {
		this.notifications = notifications;
	}
	
	
	
}
