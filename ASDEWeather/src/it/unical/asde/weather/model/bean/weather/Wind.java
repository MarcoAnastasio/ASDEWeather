package it.unical.asde.weather.model.bean.weather;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Wind {

	@Column
	private Float speed;
	@Column
	private Float deg;
	
	public Wind(){
		
	}
	
	public Float getSpeed() {
		return speed;
	}
	public void setSpeed(Float wind) {
		this.speed = wind;
	}
	public Float getDeg() {
		return deg;
	}
	public void setDeg(Float deg) {
		this.deg = deg;
	}
	
	
}
