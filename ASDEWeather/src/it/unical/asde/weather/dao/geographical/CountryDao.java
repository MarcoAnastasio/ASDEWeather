package it.unical.asde.weather.dao.geographical;

import it.unical.asde.weather.dao.GenericDao;
import it.unical.asde.weather.model.bean.geographical.Country;

public interface CountryDao extends GenericDao<Country>{

	
	public Country getCountryFromName(String name);
	
	public Country getCountryFromCode(String code);
	

}
