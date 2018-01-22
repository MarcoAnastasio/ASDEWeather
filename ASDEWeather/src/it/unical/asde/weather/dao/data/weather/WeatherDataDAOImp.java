package it.unical.asde.weather.dao.data.weather;

import it.unical.asde.weather.dao.AbstarctGenericDAO;
import it.unical.asde.weather.model.bean.data.weather.WeatherData;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WeatherDataDAOImp extends AbstarctGenericDAO<WeatherData> implements WeatherDataDAO{

	
	
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void saveList(List<WeatherData> listForecastWeather) {
		//saving a list of object whit this method allow to use only one transaction, so is faster than do it outside this class.
		for(WeatherData tempWeatherData:listForecastWeather){
			tempWeatherData.setStoreTime(new Date());
			super.save(tempWeatherData);
		}
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Serializable save(WeatherData entity) {
		entity.setStoreTime(new Date());
		return super.save(entity);
	}
	




	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void saveOrUpdate(WeatherData entity) {
		entity.setStoreTime(new Date());
		super.saveOrUpdate(entity);
	}




	@Deprecated
	@Override
	@Transactional(readOnly=true)
	public WeatherData findWeatherDataFromCityNotOlderThan(Long cityId,Integer maxOldValue){
		Session session = getSession();
		System.out.println("findAllSession="+System.identityHashCode(session));
		
		return (WeatherData) session.createQuery("from WeatherData where city_id=:cityId ")
				.setParameter("cityId", cityId)
				.uniqueResult();
	}
	
	
	
	
	@Override
	@Transactional(readOnly=true)
	public WeatherData findWeatherDataFromCityNotOlderThan(Long cityId,Date maxOldDate){
		Session session = getSession();
		System.out.println("findAllSession="+System.identityHashCode(session));
		
		//is not possible to use datediff... so set a max value date
		return getSession().createNativeQuery(
				"SELECT * , 0 as clazz_ "
				+ "FROM WeatherData f "
				+ "JOIN City c ON (c.id=f.city_id) "
				+ "JOIN Country cnt ON  (cnt.id=c.country_id) "
				+ "JOIN Weather w ON (w.id=f.weather_id) "
				+ "WHERE f.city_id=?1 "
				+ "AND f.storeTime >?2 "
				,WeatherData.class)
				.setParameter(1, cityId)
				.setParameter(2, maxOldDate).uniqueResult();

	}
	
	
	
	@Override
	@Transactional(readOnly=true)
	public List<WeatherData> findWeatherDataFromCitiesNotOlderThan(List<Long> cityIds,Date maxOldDate){
		Session session = getSession();
		System.out.println("findAllSession="+System.identityHashCode(session));

		return getSession().createNativeQuery(
				"SELECT * , 0 as clazz_  "
				+ "FROM WeatherData f "
				+ "JOIN City c ON (c.id=f.city_id) "
				+ "JOIN Country cnt ON  (cnt.id=c.country_id) "
				+ "JOIN Weather w ON (w.id=f.weather_id) "
				+ "WHERE f.city_id IN (:citiesIds) "
				+ "AND f.storeTime >:maxDate "
				,WeatherData.class)
				.setParameter("citiesIds", cityIds)
				.setParameter("maxDate", maxOldDate).list();
		

	}


}
