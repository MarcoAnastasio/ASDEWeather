package it.unical.asde.weather.model.bean.geographical;




public class City {

	
	private long id;
	private String name;
	private double longitude;
	private double latitude;	
	private Country country;

	
	public City() {
		super();
	}

	public City(long id, String name, double longitude, double latitude, Country country) {
		super();
		this.id = id;
		this.name = name;
		this.longitude = longitude;
		this.latitude = latitude;
		this.country = country;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
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
