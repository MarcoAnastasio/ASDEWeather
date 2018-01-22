package it.unical.asde.weather.dao.geographical;

import it.unical.asde.weather.dao.GenericDao;
import it.unical.asde.weather.model.bean.geographical.City;

import java.util.List;

public interface CityDao extends GenericDao<City>{

	public City findCityByIdAndName(Long cityId, String cityName);

	public City findCityByName(String cityName);

	List<City> findCitiesByName(List<String> cityNameList);

	List<City> findCitiesByName(String[] cityNameList);
	
	List<City> findCityByNameSubstring(String searchKeyword);
	
	List<City> findRandomCities(int number);
}
