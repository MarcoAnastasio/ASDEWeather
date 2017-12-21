package it.unical.asde.weather.model.bean.geographical;

public class Country {

	//autoincrement
	private long id;
	
	private String name;
	private String code;
	
	
	public Country(){
		
	}
	
	
	
	public Country(long id, String name, String code) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}



	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", code=" + code + "]";
	}
	
	
	
	
	
}
