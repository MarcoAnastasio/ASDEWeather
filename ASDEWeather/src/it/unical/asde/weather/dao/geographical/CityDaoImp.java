package it.unical.asde.weather.dao.geographical;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.unical.asde.weather.dao.AbstarctGenericDAO;
import it.unical.asde.weather.model.bean.geographical.City;

@Service
public class CityDaoImp extends AbstarctGenericDAO<City> implements CityDao{

	@Transactional(readOnly=true)
	public List<City> findAll2(){
		Session session = getSession();
		System.out.println("findAllSession="+System.identityHashCode(session));
		return session.createQuery("from City").list();
	}
	
	
}
