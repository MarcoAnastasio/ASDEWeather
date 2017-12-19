package it.unical.asde.weather.model.bean.weather;

public class Weather {

	//dont't know why the WS return me this id into the weather object
	private Long id;
	private String main;
	private String descritpion;
	private String icon;
	
	
	//TODO if we want to persist this bean on DB we have to add ID and date when it was saved
	
	public Weather() {
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMain() {
		return main;
	}
	public void setMain(String main) {
		this.main = main;
	}
	public String getDescritpion() {
		return descritpion;
	}
	public void setDescritpion(String descritpion) {
		this.descritpion = descritpion;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	
	
}
