package it.unical.asde.weather.model.bean.weather;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//TODO maybe rename to WeatherType
@Entity
@Table
public class Weather {

	//dont't know why the WS return me this id into the weather object
	@Id
	@Column
	private Long id;
	@Column
	private String main;
	@Column
	private String descritpion;
	@Column
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
	
	
//	 UNKNOWN                         (Integer.MIN_VALUE),
//			/* Thunderstorm */
//			THUNDERSTORM_WITH_LIGHT_RAIN    (200),
//			THUNDERSTORM_WITH_RAIN          (201),
//			THUNDERSTORM_WITH_HEAVY_RAIN    (202),
//			LIGHT_THUNDERSTORM              (210),
//			THUNDERSTORM                    (211),
//			HEAVY_THUNDERSTORM              (212),
//			RAGGED_THUNDERSTORM             (221),
//			THUNDERSTORM_WITH_LIGHT_DRIZZLE (230),
//			THUNDERSTORM_WITH_DRIZZLE       (231),
//			THUNDERSTORM_WITH_HEAVY_DRIZZLE (232),
//			/* Drizzle */
//			LIGHT_INTENSITY_DRIZZLE         (300),
//			DRIZZLE                         (301),
//			HEAVY_INTENSITY_DRIZZLE         (302),
//			LIGHT_INTENSITY_DRIZZLE_RAIN    (310),
//			DRIZZLE_RAIN                    (311),
//			HEAVY_INTENSITY_DRIZZLE_RAIN    (312),
//			SHOWER_DRIZZLE                  (321),
	
	
//			/* Rain */
//			LIGHT_RAIN                      (500),
//			MODERATE_RAIN                   (501),
//			HEAVY_INTENSITY_RAIN            (502),
//			VERY_HEAVY_RAIN                 (503),
//			EXTREME_RAIN                    (504),
//			FREEZING_RAIN                   (511),
//			LIGHT_INTENSITY_SHOWER_RAIN     (520),
//			SHOWER_RAIN                     (521),
//			HEAVY_INTENSITY_SHOWER_RAIN     (522),
//			/* Snow */
//			LIGHT_SNOW                      (600),
//			SNOW                            (601),
//			HEAVY_SNOW                      (602),
//			SLEET                           (611),
//			SHOWER_SNOW                     (621),
//			/* Atmosphere */
//			MIST                            (701),
//			SMOKE                           (711),
//			HAZE                            (721),
//			SAND_OR_DUST_WHIRLS             (731),
//			FOG                             (741),
//			/* Clouds */
//			SKY_IS_CLEAR                    (800),
//			FEW_CLOUDS                      (801),
//			SCATTERED_CLOUDS                (802),
//			BROKEN_CLOUDS                   (803),
//			OVERCAST_CLOUDS                 (804),
//			/* Extreme */
//			TORNADO                         (900),
//			TROPICAL_STORM                  (901),
//			HURRICANE                       (902),
//			COLD                            (903),
//			HOT                             (904),
//			WINDY                           (905),
//			HAIL                            (906);
	
}
