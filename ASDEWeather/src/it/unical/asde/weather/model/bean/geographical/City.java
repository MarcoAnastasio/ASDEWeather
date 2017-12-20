package it.unical.asde.weather.model.bean.geographical;




public class City {

	
	private Long id;
	private String name;
	private Double longitude;
	private Double latitude;	
	private Country country;

	
	public City() {
		super();
	}

	public City(Long id, String name, Double longitude, Double latitude, Country country) {
		super();
		this.id = id;
		this.name = name;
		this.longitude = longitude;
		this.latitude = latitude;
		this.country = country;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", longitude=" + longitude + ", latitude=" + latitude
				+ ", country=" + country + "]";
	}
	
	
	
}
