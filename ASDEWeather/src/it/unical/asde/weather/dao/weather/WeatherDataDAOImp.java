package it.unical.asde.weather.dao.weather;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.unical.asde.weather.dao.AbstarctGenericDAO;
import it.unical.asde.weather.model.bean.geographical.City;
import it.unical.asde.weather.model.bean.weather.WeatherData;

@Service
public class WeatherDataDAOImp extends AbstarctGenericDAO<WeatherData> implements WeatherDataDAO{

	@Override
	@Transactional(readOnly=true)
	public WeatherData findWeatherDataFromCityNotOlderThan(Long cityId,Long maxOldValue){
		Session session = getSession();
		System.out.println("findAllSession="+System.identityHashCode(session));
		//TODO maybe add TOP 1 and order by desc to have the newest result
		return (WeatherData) session.createQuery("from WeatherData where city_id=:cityId "
				+ "and  DATEDIFF('MILLISECOND',storeTime , CURRENT_TIMESTAMP()) <= :maxOldValue")
				.setParameter("cityId", cityId)
				.setParameter("maxOldValue", maxOldValue)
				.uniqueResult();
	}
}
