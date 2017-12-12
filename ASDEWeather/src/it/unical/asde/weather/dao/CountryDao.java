package it.unical.asde.weather.dao;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.unical.asde.weather.core.utilities.BulkLoaderCountryCities;
import it.unical.asde.weather.model.bean.geographical.Country;


@Service
public class CountryDao {

	@Autowired
	BulkLoaderCountryCities bulckLoader;
	
	private static Map<Long, Country> countryList;
	
	
	@PostConstruct
	private void init(){
		countryList=new HashMap<>();
		try {
//			bulckLoader.loadCountryFromFile();
			bulckLoader.loadCityFromFile();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//TODO use bulk loader service to load all data
	}
	
	public Country getCountryFromName(String name){
		for(long id:countryList.keySet()){
			if(countryList.get(id).getName().equals(name)){
				return countryList.get(id);
			}
		}
		return null;
	}
	
	public Country getCountryFromCode(String code){
		for(long id:countryList.keySet()){
			if(countryList.get(id).getCode().equals(code)){
				return countryList.get(id);
			}
		}
		return null;
	}
	
	public Country getCountryFromId(long id){
		return countryList.get(id);
	}
}
