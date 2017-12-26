package it.unical.asde.weather.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.unical.asde.weather.core.utilities.BulkLoaderCountryCities;
import it.unical.asde.weather.model.bean.geographical.City;

@Service
public class OldStaticCityDao {

	@Autowired
	BulkLoaderCountryCities bluckLoader;
	
	private static HashMap<Long, City> cities;
	
	@PostConstruct
	public void inti(){
		
		cities=new  HashMap<>();
		cities.put(new Long(6541467), new City(new Long(6541467), "Cosenza", null, null, null));
		cities.put(new Long(4905006), new City(new Long(4905006), "Ottawa", null, null, null));
		cities.put(new Long(4850657), new City(new Long(4850657), "Cedar", null, null, null));
		cities.put(new Long(6362983), new City(new Long(6362983), "Zaragoza", null, null, null));
		cities.put(new Long(3170196), new City(new Long(3170196), "Pontinia", null, null, null));
		cities.put(new Long(6542115), new City(new Long(6542115), "Latina", null, null, null));
		cities.put(new Long(6362437), new City(new Long(6362437), "Loiu", null, null, null));
		
		/*
		try {
			cities= bluckLoader.loadCityFromFile();
		} catch (Exception e) {
			cities=new  HashMap<>();
		}
		*/
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
			int randomNum = ThreadLocalRandom.current().nextInt(0, cities.keySet().size());
			returnList.add(cities.get(keysAsArray.get(randomNum)));
		}
		
		return returnList;
	}
	
	
	public City getCityFromName(String cityName){
		
		 Iterator it = cities.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        if( ((City)pair.getValue()).getName().equals(cityName)){
	        	return (City)pair.getValue();
	        }
	    }
	    return null;
		    
	}

	
}
