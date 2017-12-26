package it.unical.asde.weather.dao.geographical;

import java.util.List;

import it.unical.asde.weather.dao.GenericDao;
import it.unical.asde.weather.model.bean.geographical.City;

public interface CityDao extends GenericDao<City>{

	public List<City> findAll2();
	
}
