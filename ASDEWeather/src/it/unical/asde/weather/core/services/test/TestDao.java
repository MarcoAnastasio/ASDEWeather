package it.unical.asde.weather.core.services.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.unical.asde.weather.dao.geographical.CityDao;
import it.unical.asde.weather.dao.geographical.CountryDao;
import it.unical.asde.weather.model.bean.geographical.City;
import it.unical.asde.weather.model.bean.geographical.Country;

@Service
public class TestDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private CountryDao countryDao;
	@Autowired
	private CityDao cityDao;
	
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void executeTestOnCountry(){
		Session currentSession = sessionFactory.getCurrentSession();
		System.out.println("CurrentSession="+System.identityHashCode(currentSession));
		
		List<Country> findAll = countryDao.findAll();
		for(Country c:findAll){
			System.out.println(c);
		}
		
		Country coun=new Country();
		coun.setCode("IT");
		coun.setName("Italy");
		countryDao.save(coun);
		
		Country coun2=new Country();
		coun2.setCode("SP");
		coun2.setName("Spain");
		countryDao.save(coun2);
		
		List<Country> findAll2 = countryDao.findAll();
		for(Country c:findAll2){
			System.out.println(c);
		}
		
		coun2.setName("Spain33333");
		
		City city=new City(null, "TestCity1", null, null, coun2);
		
		cityDao.save(city);
		
		System.out.println(city);
		
		List<City> findAll3 = cityDao.findAll();
		for(City c:findAll3){
			System.out.println(city);
		}
		
		
		System.out.println(countryDao.findById(new Long(2)));
	}
	
}
