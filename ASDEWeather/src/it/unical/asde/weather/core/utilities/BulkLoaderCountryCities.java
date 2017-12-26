package it.unical.asde.weather.core.utilities;

import java.io.FileReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.eclipse.jdt.internal.compiler.impl.ITypeRequestor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import it.unical.asde.weather.model.bean.geographical.City;
import it.unical.asde.weather.model.bean.geographical.Country;

@Service
public class BulkLoaderCountryCities {

	private static final String COUNTRY_LIST=
			"C:/Users/Marco/git/ASDEWeather2/ASDEWeather/tempData/SimpleCountryList.csv";
	
	private static final String CITY_LIST=
			"C:/Users/Marco/git/ASDEWeather2/ASDEWeather/tempData/city.list.json";
	
	
	public HashMap<Long,Country> loadCountryFromFile()throws Exception{
		HashMap<Long, Country> countries=new HashMap<>();
		Long counter=new Long(0);
		
		String baseString="values (null,";
		
		Reader in = new FileReader(COUNTRY_LIST);
		Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
		
		for (CSVRecord record : records) {
		    String name= record.get(0);
		    String code = record.get(1);
		    
		    
		  //  System.out.println(countries.get(counter-1));
		}
		
		return countries;
	}
	
	public HashMap<Long,City> loadCityFromFile()throws Exception{
		HashMap<Long, City> cities=new HashMap<>();

		Long counter=new Long(0);
		JSONParser parser = new JSONParser();
		
		try {
			
			Object obj = parser.parse(new FileReader(CITY_LIST));
			
			JSONArray jsonArray = (JSONArray) obj;
			
			for(int n = 0; n < jsonArray.size(); n++)
			{
				JSONObject object = (JSONObject) jsonArray.get(n);
				String countryCode=(String) object.get("country");
				String name=(String) object.get("name");
				Long id= (Long) object.get("id");
				JSONObject coordsObj = (JSONObject) object.get("coord");
				
				Double longitude= this.parseCoord(coordsObj.get("lon") );
				Double latitude= this.parseCoord(coordsObj.get("lat") );
				
				cities.put(id, new City(id,name,longitude,latitude,null));
				
				System.out.println(new City(id,name,longitude,latitude,null));
				
				//stop condition.. to boring wit so match
				if(n>40){
					break;
				}
			}
	    		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cities;
	}
	
	
	private Double parseCoord(Object value){
		try{
			return (Double) value;
		}catch (Exception e) {
			try{
				return ((Long) value).doubleValue();
			}catch(Exception e2){
				e2.printStackTrace();
				return null;
			}					
		}
	}
	
	
}
