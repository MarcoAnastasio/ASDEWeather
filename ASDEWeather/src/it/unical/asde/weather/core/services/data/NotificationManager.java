package it.unical.asde.weather.core.services.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import it.unical.asde.weather.core.utilities.DateUtils;
import it.unical.asde.weather.model.bean.data.weather.WeatherForecastData;
import it.unical.asde.weather.model.bean.user.Notification;
import it.unical.asde.weather.model.bean.user.Notification.NotificationReason;
import it.unical.asde.weather.model.openweatherapi.response.APIForecastResponse;

@Service
@Configuration
@PropertySource("classpath:application.properties")
public class NotificationManager {

	
	
	@Value( "${asde.weather.notification.wind_speed}" )
	private Float ALLERT_WIND_SPEED;
	
	@Value( "${asde.weather.notification.cold_temp}" )
	private Float ALLERT_COLD_TEMP;
	
	@Value( "${asde.weather.notification.hot_temp}" )
	private Float ALLERT_HOT_TEMP;
	
	@Value( "${asde.weather.notification.rain_level}" )
	private Float ALLERT_RAIN_LEVEL;
	
	
	
	public List<Notification> extractNotificationFromForecastWeather(List<WeatherForecastData> listForecastWeather) {
		
		List<Notification> notificationList=new ArrayList<>();
		
		for(WeatherForecastData tempW:listForecastWeather){
			if(tempW==null ) {
				continue;
			}
			if(tempW.getWeather().getMain().equals("Extreme")){
				NotificationReason reason = NotificationReason.EXTREAM_WEATHER;
				Notification notToAdd=new Notification(tempW,reason,reason.getMessage());
				if(haveToAddNewExtreameNotInList(notificationList,notToAdd)) {
					notificationList.add(notToAdd);						
				}
			}else {
			//custom evalutaion of weather to notify
				if(tempW.getWind()!=null && tempW.getWind().getSpeed()!=null 
						&& tempW.getWind().getSpeed()>=ALLERT_WIND_SPEED) {
					generateNotificationAndCheckIfAdd(tempW,NotificationReason.WIND_SPEED,notificationList);
				}
				if(tempW.getMainTemperature()!=null && tempW.getMainTemperature().getTempMin()!=null 
						&& tempW.getMainTemperature().getTempMin()<=ALLERT_COLD_TEMP) {
					generateNotificationAndCheckIfAdd(tempW,NotificationReason.COLD_TEMP,notificationList);					
				}
				if(tempW.getMainTemperature()!=null && tempW.getMainTemperature().getTempMax()!=null && 
						tempW.getMainTemperature().getTempMax()>=ALLERT_HOT_TEMP) {
					generateNotificationAndCheckIfAdd(tempW,NotificationReason.HOT_TEMP,notificationList);
				}
				if(tempW.getRain()!= null && tempW.getRain()>=ALLERT_RAIN_LEVEL) {
					generateNotificationAndCheckIfAdd(tempW,NotificationReason.RAIN_LEVEL,notificationList);
				}
				
			}
		}
		
		
		return notificationList;
	}
	
	private void generateNotificationAndCheckIfAdd(WeatherForecastData tempW, NotificationReason windSpeed,List<Notification> notificationList) {
		Notification temp=new Notification(tempW, windSpeed, windSpeed.getMessage());
		if(haveToAddNewExtreameNotInList(notificationList, temp)) {
			notificationList.add(temp);
		}
		
		
	}

	
	private boolean haveToAddNewExtreameNotInList(List<Notification> notificationList, Notification not) {
		if(notificationList.isEmpty()){
			return true;
		}
		
		if(not.getNotificationReason().getValue()==NotificationReason.EXTREAM_WEATHER.getValue()) {
			for(Notification tempN:notificationList){
				if(
						tempN.getNotificationReason().getValue()==not.getNotificationReason().getValue() &&
						tempN.getWeatherData().getCity().getId().equals( not.getWeatherData().getCity().getId() ) &&
						tempN.getWeatherData().getWeather().getId().equals(not.getWeatherData().getWeather().getId()) &&
						DateUtils.chackTwoDateSameDay(tempN.getWeatherData().getDateTimeOfForecast(),not.getWeatherData().getDateTimeOfForecast())
						){
					return false;
				}				
			}
			//not Extream notification has different way to be compared
		}else {
			for(Notification tempN:notificationList){
				if(
						tempN.getNotificationReason().getValue()==not.getNotificationReason().getValue() &&
						tempN.getWeatherData().getCity().getId().equals( not.getWeatherData().getCity().getId() ) &&
						DateUtils.chackTwoDateSameDay(tempN.getWeatherData().getDateTimeOfForecast(),not.getWeatherData().getDateTimeOfForecast()) 
						){
					return false;
				}				
			}	
		}
		
		return true;
	}
	
}
