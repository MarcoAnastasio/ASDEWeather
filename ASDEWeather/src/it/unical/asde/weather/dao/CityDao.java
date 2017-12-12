package it.unical.asde.weather.dao;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.unical.asde.weather.core.utilities.BulkLoaderCountryCities;
import it.unical.asde.weather.model.bean.geographical.City;

@Service
public class CityDao {

	@Autowired
	BulkLoaderCountryCities bluckLoader;
	
	private static HashMap<Long, City> cities;
	
	@PostConstruct
	public void inti(){
		try {
			cities= bluckLoader.loadCityFromFile();
		} catch (Exception e) {
			cities=new  HashMap<>();
		}
	}
	
	
	/**
	 * this methods return 6 random cities to show in the index 
	 * view when user are not logged in
	 * @return
	 */
	public List<City> getRandomCities(){
		
		List<City> returnList=new ArrayList<>();
		List<Long> keysAsArray = new ArrayList<Long>(cities.keySet());
		
		for(int i=0;i<6;i++){
			int randomNum = ThreadLocalRandom.current().nextInt(0, cities.keySet().size()+ 1);
			returnList.add(cities.get(keysAsArray.get(randomNum)));
		}
		
		return returnList;
	}
	
}
