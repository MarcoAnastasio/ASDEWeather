package it.unical.asde.weather.model.bean.weather;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
public class MainTemperature {

	@Column
	private Float temp;
	@Column
	private Float tempMin;
	@Column
	private Float tempMax;
	@Column
	private Float pressure;
	@Column
	private Float seaLevel;
	@Column
	private Float grndLevel;
	@Column
	private Float humidity;
	@Column
	private Float tempKf;
	
	
	public MainTemperature() {
		super();
	}


	public Float getTemp() {
		return temp;
	}


	public void setTemp(Float temp) {
		this.temp = temp;
	}


	public Float getTempMin() {
		return tempMin;
	}


	public void setTempMin(Float tempMin) {
		this.tempMin = tempMin;
	}


	public Float getTempMax() {
		return tempMax;
	}


	public void setTempMax(Float tempMax) {
		this.tempMax = tempMax;
	}


	public Float getPressure() {
		return pressure;
	}


	public void setPressure(Float pressure) {
		this.pressure = pressure;
	}


	public Float getSeaLevel() {
		return seaLevel;
	}


	public void setSeaLevel(Float seaLevel) {
		this.seaLevel = seaLevel;
	}


	public Float getGrndLevel() {
		return grndLevel;
	}


	public void setGrndLevel(Float grndLevel) {
		this.grndLevel = grndLevel;
	}


	public Float getHumidity() {
		return humidity;
	}


	public void setHumidity(Float humidity) {
		this.humidity = humidity;
	}


	public Float getTempKf() {
		return tempKf;
	}


	public void setTempKf(Float tempKf) {
		this.tempKf = tempKf;
	}


	@Override
	public String toString() {
		return "MainTemperature [temp=" + temp + ", tempMin=" + tempMin + ", tempMax=" + tempMax + ", pressure="
				+ pressure + ", seaLevel=" + seaLevel + ", grndLevel=" + grndLevel + ", humidity=" + humidity
				+ ", tempKf=" + tempKf + "]";
	}
	
	
}
