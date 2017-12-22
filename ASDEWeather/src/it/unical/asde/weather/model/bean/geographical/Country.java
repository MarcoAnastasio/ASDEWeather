package it.unical.asde.weather.model.bean.geographical;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.lang.NonNull;

@Entity
@Table
public class Country {

	//autoincrement
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(unique=true,nullable=false)
	private String name;
	
	@Column(unique=true,nullable=false,length=2)
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
