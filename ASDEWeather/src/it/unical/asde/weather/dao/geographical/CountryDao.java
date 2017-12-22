package it.unical.asde.weather.dao.geographical;

import it.unical.asde.weather.model.bean.geographical.Country;

public interface CountryDao {

	
	public Country getCountryFromName(String name);
	
	public Country getCountryFromCode(String code);
	
	public Country getCountryFromId(long id);
	
	
}
