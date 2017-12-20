package it.unical.asde.weather.model.bean.comunication.request;

public class RequestSingleCity {

	private Long cityId;
	private String cityName;
	
	
	
	public Long getCityId() {
		return cityId;
	}
	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	@Override
	public String toString() {
		return "RequestSingleCity [cityId=" + cityId + ", cityName=" + cityName + "]";
	}
	

	
}
