package it.unical.asde.weather.dao.geographical;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.unical.asde.weather.dao.AbstarctGenericDAO;
import it.unical.asde.weather.model.bean.data.weather.WeatherData;
import it.unical.asde.weather.model.bean.geographical.City;
import it.unical.asde.weather.model.bean.geographical.Country;

@Service
public class CityDaoImp extends AbstarctGenericDAO<City> implements CityDao{


	@Override
	@Transactional(readOnly=true)
	public City findCityByName(String cityName) {
		Session session = getSession();
		return (City)session.createQuery("from City where name =:cityName").setParameter("cityName", cityName).uniqueResult();
	}
	
	
	
	@Override
	@Transactional(readOnly=true)
	public List<City> findCitiesByName(List<String> cityNameList) {
		Session session = getSession();
		return session.createQuery("from City where name IN (:cityNames)",City.class)
				.setParameter("cityNames", cityNameList).list();
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<City> findCitiesByName(String[] cityNameList) {
		Session session = getSession();
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


	@Override
	@Transactional(readOnly=true)
	public List<City> findCityByNameSubstring(String searchKeyword) {
		return getSession().createQuery("from City where lower(name) LIKE lower(:searchKeyword)",City.class)
				.setParameter("searchKeyword", "%"+searchKeyword+"%").list();
	}



	@Override
	public List<City> findRandomCities(int number) {
		return getSession().createNativeQuery(
				"SELECT * FROM City ORDER BY RAND() LIMIT :number", City.class)
				.setParameter("number",number ).list();
	}
	
	/*
	get random cities
	SELECT column FROM table
	ORDER BY RAND()
	LIMIT 5
	*/
}
