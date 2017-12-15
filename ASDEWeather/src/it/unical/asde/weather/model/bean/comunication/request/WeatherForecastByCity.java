package it.unical.asde.weather.model.bean.comunication.request;

public class WeatherForecastByCity {

	private String cityName;

	public WeatherForecastByCity(){
	}
	
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	
}
