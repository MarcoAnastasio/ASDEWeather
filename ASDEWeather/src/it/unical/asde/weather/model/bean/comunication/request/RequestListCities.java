package it.unical.asde.weather.model.bean.comunication.request;

import java.util.List;

public class RequestListCities {

	private List<RequestSingleCity> cities;

	public RequestListCities(){
	}

	public List<RequestSingleCity> getCities() {
		return cities;
	}

	public void setCities(List<RequestSingleCity> cities) {
		this.cities = cities;
	}

	@Override
	public String toString() {
		return "RequestListCities [cities=" + cities + "]";
	}
	
	
	
}
