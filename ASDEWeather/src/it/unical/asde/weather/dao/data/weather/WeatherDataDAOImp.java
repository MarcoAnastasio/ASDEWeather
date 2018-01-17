package it.unical.asde.weather.dao.data.weather;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.unical.asde.weather.dao.AbstarctGenericDAO;
import it.unical.asde.weather.dao.geographical.CityDaoImp;
import it.unical.asde.weather.model.bean.data.weather.WeatherData;
import it.unical.asde.weather.model.bean.geographical.City;

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




	@Override
	@Transactional(readOnly=true)
	public WeatherData findWeatherDataFromCityNotOlderThan(Long cityId,Integer maxOldValue){
		Session session = getSession();
		System.out.println("findAllSession="+System.identityHashCode(session));
		//TODO maybe add TOP 1 and order by desc to have the newest result
		/*
		return (WeatherData) session.createQuery("from WeatherData where city_id=:cityId "
				+ "and  DATEDIFF('MINUTE',CURRENT_TIMESTAMP(),storeTime ) <= :maxOldValue")
				.setParameter("cityId", cityId)
				.setParameter("maxOldValue", maxOldValue)
				.uniqueResult();
				*/
		
		//is not possible to use datediff... so set a max value date
		return (WeatherData) session.createQuery("from WeatherData where city_id=:cityId ")
				//+ "and  DATEDIFF('MINUTE',CURRENT_TIMESTAMP(),storeTime ) <= :maxOldValue")
				.setParameter("cityId", cityId)
//				.setParameter("maxOldValue", maxOldValue)
				.uniqueResult();
	}
	
	
	
	
	@Override
	@Transactional(readOnly=true)
	public WeatherData findWeatherDataFromCityNotOlderThan(Long cityId,Date maxOldDate){
		Session session = getSession();
		System.out.println("findAllSession="+System.identityHashCode(session));
		//TODO maybe add TOP 1 and order by desc to have the newest result
		
		//is not possible to use datediff... so set a max value date
		return session.createQuery("from WeatherData where city_id=:cityId "
				+ "and  storeTime > :maxOldDate order by storeTime desc",WeatherData.class)
				.setParameter("cityId", cityId)
				.setParameter("maxOldDate", maxOldDate)
				.setFirstResult(0)
				.setMaxResults(1)
				.uniqueResult();
	}
	
	
	
	@Override
	@Transactional(readOnly=true)
	public List<WeatherData> findWeatherDataFromCitiesNotOlderThan(List<Long> cityIds,Date maxOldDate){
		Session session = getSession();
		System.out.println("findAllSession="+System.identityHashCode(session));
		//TODO maybe add TOP 1 and order by desc to have the newest result
		
		//is not possible to use datediff... so set a max value date
		return session.createQuery("from WeatherData where city_id IN (:cityIds) "
				+ "and  storeTime > :maxOldDate order by storeTime desc",WeatherData.class)
				.setParameter("cityIds", cityIds)
				.setParameter("maxOldDate", maxOldDate)
				.list();
	}


}
