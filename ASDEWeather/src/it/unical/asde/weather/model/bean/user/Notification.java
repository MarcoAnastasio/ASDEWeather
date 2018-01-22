package it.unical.asde.weather.model.bean.user;

import it.unical.asde.weather.model.bean.data.weather.WeatherForecastData;



public class Notification {
	
	private static final Integer EXTREME_WEATHER_CODE=0;
	private static final String EXTREME_WEATHER_MSG="";
	private static final Integer WIND_SPEED_CODE=1;
	private static final String WIND_SPEED_MSG="Wind speed allert";
	private static final Integer COLD_TEMP_CODE=2;
	private static final String COLD_TEMP_MSG="Cold temperature allert";
	private static final Integer HOT_TEMP_CODE=3;
	private static final String HOT_TEMP_MSG="Hot temperature allert";
	private static final Integer RAIN_LEVEL_CODE=4;
	private static final String RAIN_LEVEL_MSG="Rain level allert";

	
	public enum NotificationReason {
	    EXTREM_WEATHER(Notification.EXTREME_WEATHER_CODE,Notification.EXTREME_WEATHER_MSG),
	    WIND_SPEED(Notification.WIND_SPEED_CODE,Notification.WIND_SPEED_MSG),
	    COLD_TEMP(Notification.COLD_TEMP_CODE,Notification.COLD_TEMP_MSG),
	    HOT_TEMP(Notification.HOT_TEMP_CODE,Notification.HOT_TEMP_MSG),
	    RAIN_LEVEL(Notification.RAIN_LEVEL_CODE,Notification.RAIN_LEVEL_MSG)
	    ;

	    private final int value;
	    private final String defaultErrorMessage;
	    
	    private NotificationReason(int value,String defaultErrorMessage) {
	        this.value = value;
	        this.defaultErrorMessage=defaultErrorMessage;
	    }
	    public int getValue() {
	        return value;
	    }
	    public String getMessage(){
	    	return defaultErrorMessage;
	    }
	}
	
	
//	private City city;
//	
//	private Weather weather;
//	
//	private Date date;
	
	private WeatherForecastData weatherData;
	
	private NotificationReason notificationReason;
	
	private String messageForUser;
	
	
	public Notification() {
		super();
	}
	
	public Notification(WeatherForecastData weatherData,NotificationReason reason,String message) {
		super();
		this.weatherData=weatherData;
		this.messageForUser=message;
		this.notificationReason=reason;
	}


/*
	public City getCity() {
		return weatherData.getCity();
	}


	public Weather getWeather() {
		return weatherData.getWeather();
	}

	public Date getDate() {
		return weatherData.getDateTimeCalulation();
	}
*/

	public NotificationReason getNotificationReason() {
		return notificationReason;
	}

	public void setNotificationReason(NotificationReason notificationReason) {
		this.notificationReason = notificationReason;
	}

	public String getMessageForUser() {
		return messageForUser;
	}

	public void setMessageForUser(String messageForUser) {
		this.messageForUser = messageForUser;
	}

	public WeatherForecastData getWeatherData() {
		return weatherData;
	}

	public void setWeatherData(WeatherForecastData weatherData) {
		this.weatherData = weatherData;
	}
	
	
	
	
}
