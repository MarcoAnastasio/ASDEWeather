package it.unical.asde.weather.dao.weather;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.unical.asde.weather.dao.AbstarctGenericDAO;
import it.unical.asde.weather.model.bean.weather.WeatherData;
import it.unical.asde.weather.model.bean.weather.WeatherForecastData;

@Service
public class WeatherForecastDataDAOImp extends AbstarctGenericDAO<WeatherForecastData> 
	implements WeatherForecastDataDAO{

	@Override
	@Transactional(readOnly=true)
	public List<WeatherForecastData> findWeatherForecastDataFromCityNotOlderThan(Long cityId, Date maxOldDate) {
		
		return getSession().createNativeQuery(
				"SELECT * "
				+ "FROM WeatherForecastData f "
				+ "JOIN City c ON (c.id=f.city_id) "
				+ "JOIN Country cnt ON  (cnt.id=c.country_id) "
				+ "JOIN Weather w ON (w.id=f.weather_id) "
				+ "WHERE f.city_id=?1 "
				+ "AND f.storeTime >?2 "
				+ "ORDER BY dateTimeOfForecast ASC"
				,WeatherForecastData.class)
				.setParameter(1, cityId)
				.setParameter(2, maxOldDate)
				.list();
		
		
//		return getSession().createNativeQuery(
//				"SELECT * "
//				+ "FROM WheatherForecastData f "
//				+ "JOIN City c ON (c.id=f.city_id) "
//				+ "JOIN Country cnt ON  (cnt.id=c.country_id) "
//				+ "JOIN Weather w ON (w.id=f.weather_id) "
//				+ "WHERE city_id=?1 "
//				+ "AND storeTime >?2 "
//				+ "ORDER BY dateTimeOfForecast ASC",WeatherForecastData.class)
//				.setParameter(1, cityId)
//				.setParameter(2, maxOldDate)
//				.list();
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void saveList(List<WeatherForecastData> listForecastWeather) {
		for(WeatherForecastData tempData:listForecastWeather){
			tempData.setStoreTime(new Date());
			super.save(tempData);
		}
		
	}

}
