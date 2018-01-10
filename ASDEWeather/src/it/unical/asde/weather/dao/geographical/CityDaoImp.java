package it.unical.asde.weather.dao.geographical;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.unical.asde.weather.dao.AbstarctGenericDAO;
import it.unical.asde.weather.model.bean.geographical.City;
import it.unical.asde.weather.model.bean.weather.WeatherData;

@Service
public class CityDaoImp extends AbstarctGenericDAO<City> implements CityDao{

	@Override
	@Transactional(readOnly=true)
	public List<City> findAll2(){
		Session session = getSession();
		System.out.println("findAllSession="+System.identityHashCode(session));
		return session.createQuery("from City").list();
	}

	
	@Override
	@Transactional(readOnly=true)
	public City findCityByName(String cityName) {
		Session session = getSession();
		System.out.println("findCityByNAme="+System.identityHashCode(session));
		return (City)session.createQuery("from City where name =:cityName").setParameter("cityName", cityName).uniqueResult();
	}
	
	
	
	@Override
	@Transactional(readOnly=true)
	public List<City> findCitiesByName(List<String> cityNameList) {
		Session session = getSession();
		System.out.println("findCityByNAme="+System.identityHashCode(session));
		
		return session.createQuery("from City where name IN (:cityNames)",City.class)
				.setParameter("cityNames", cityNameList).list();
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<City> findCitiesByName(String[] cityNameList) {
		Session session = getSession();
		System.out.println("findCityByNAme="+System.identityHashCode(session));
		
		return session.createQuery("from City where name IN (:cityNames)",City.class)
				.setParameter("cityNames", cityNameList).list();
	}
	
	@Override
	@Transactional(readOnly=true)
	public City findCityByIdAndName(Long cityId, String cityName) {
		Session session = getSession();
		System.out.println("findCityByIdAndName="+System.identityHashCode(session));
		return (City)session.createQuery("from City where id=:cityId and name =:cityName")
				.setParameter("cityId", cityId).setParameter("cityName", cityName).uniqueResult();
	}
	
	
}
